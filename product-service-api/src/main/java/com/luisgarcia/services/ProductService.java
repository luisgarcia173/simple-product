package com.luisgarcia.services;

import com.luisgarcia.controllers.dtos.ProductDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  ProductDto getById(long id);

  List<ProductDto> getAll(Pageable pageable, boolean onlyActives);

  void delete(long id);

  ProductDto create(ProductDto productRequest);

  ProductDto update(long id, ProductDto productRequest);
}
