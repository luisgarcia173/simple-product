package com.luisgarcia.controllers.mappers;

import com.luisgarcia.controllers.dtos.ProductDto;
import com.luisgarcia.repositories.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(source = "category.name", target = "categoryPath")
  ProductDto toDto(ProductEntity entity);

  ProductEntity toEntity(ProductDto dto);

  void updateEntityFromDto(ProductDto dto, @MappingTarget ProductEntity entity);
}
