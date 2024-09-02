package com.example.springpractice.support;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@MappedSuperclass
public abstract class BaseAuditEntity extends BaseTimeEntity {

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;
}
