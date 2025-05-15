package com.luisgarcia.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryEntity extends AuditDataEntity implements Serializable {

  @NotBlank private String name;
  private String description;
}
