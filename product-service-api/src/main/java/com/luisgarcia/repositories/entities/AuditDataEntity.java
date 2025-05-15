package com.luisgarcia.repositories.entities;

import com.luisgarcia.repositories.enums.StatusEnum;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@MappedSuperclass
@Data
public class AuditDataEntity {

  @Id @GeneratedValue private long id;

  private Date createdDate;
  private Date updatedDate;

  @Enumerated(EnumType.STRING)
  private StatusEnum status;

  public AuditDataEntity() {
    this.createdDate = new Date();
    this.status = StatusEnum.ACTIVE;
  }
}
