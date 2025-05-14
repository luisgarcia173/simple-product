package com.luisgarcia.controllers.dtos;

import com.luisgarcia.repositories.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

  private long id;
  private String name;
  private String description;
  private BigDecimal price;
  private String categoryPath;
  private boolean available;
  private boolean status;

}
