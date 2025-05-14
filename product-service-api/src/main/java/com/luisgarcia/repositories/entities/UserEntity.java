package com.luisgarcia.repositories.entities;

import com.luisgarcia.repositories.enums.RolesEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends AuditDataEntity implements Serializable {

  @NotBlank
  private String username;
  @NotBlank
  private String password;

  @Enumerated(EnumType.STRING)
  private RolesEnum role;

}
