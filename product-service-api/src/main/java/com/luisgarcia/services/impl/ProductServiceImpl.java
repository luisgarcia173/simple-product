package com.luisgarcia.services.impl;

import com.luisgarcia.controllers.dtos.ProductDto;
import com.luisgarcia.controllers.mappers.ProductMapper;
import com.luisgarcia.exceptions.ProductNotFoundException;
import com.luisgarcia.repositories.CategoryRepository;
import com.luisgarcia.repositories.ProductRepository;
import com.luisgarcia.repositories.entities.CategoryEntity;
import com.luisgarcia.repositories.entities.ProductEntity;
import com.luisgarcia.repositories.enums.StatusEnum;
import com.luisgarcia.services.ProductService;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;
  private final CategoryRepository categoryRepository;
  private final ProductMapper mapper;

  @Override
  public ProductDto getById(long id) {
    ProductEntity product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
    return mapper.toDto(product);
  }

  @Override
  public List<ProductDto> getAll(Pageable pageable, boolean onlyActives) {
    List<ProductEntity> products =
        onlyActives
            ? repository.findAll(pageable).stream().toList()
            : repository.findAllByStatusIsActive(pageable).stream().toList();
    if (!products.isEmpty()) {
      return products.stream().map(mapper::toDto).toList();
    }
    throw new ProductNotFoundException();
  }

  @Override
  public void delete(long id) {
    // repository.deleteById(id);
    ProductEntity product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
    product.setUpdatedDate(new Date());
    product.setStatus(StatusEnum.INACTIVE);
    repository.save(product);
  }

  @Override
  public ProductDto create(ProductDto productRequest) {
    ProductEntity product = mapper.toEntity(productRequest);
    product.setCreatedDate(new Date());
    product.setStatus(StatusEnum.ACTIVE);
    CategoryEntity category = categoryRepository.findByName(productRequest.getCategoryPath());
    product.setCategory(category);
    repository.save(product);

    return mapper.toDto(product);
  }

  @Override
  public ProductDto update(long id, ProductDto productRequest) {
    ProductEntity product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
    mapper.updateEntityFromDto(productRequest, product);
    product.setUpdatedDate(new Date());
    CategoryEntity category = categoryRepository.findByName(productRequest.getCategoryPath());
    product.setCategory(category);
    repository.save(product);

    return mapper.toDto(product);
  }
}
