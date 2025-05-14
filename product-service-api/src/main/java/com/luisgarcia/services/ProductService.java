package com.luisgarcia.services;

import com.luisgarcia.controllers.dtos.ProductDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

  ProductDto getById(long id);
  List<ProductDto> getAll(Pageable pageable);
  void delete(long id);
  ProductDto create(ProductDto productRequest);
  ProductDto update(long id, ProductDto productRequest);

}
