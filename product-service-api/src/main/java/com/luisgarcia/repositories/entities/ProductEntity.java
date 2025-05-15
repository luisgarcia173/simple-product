package com.luisgarcia.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends AuditDataEntity implements Serializable {

  @NotBlank private String name;
  private String description;
  private BigDecimal price;
  private CategoryEntity category;
  private boolean available;
}
