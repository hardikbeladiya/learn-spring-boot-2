package com.example.spring.boot.dao.entity.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public abstract class BaseEntity implements Serializable {

    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private Date updatedDate;

    @Version
    private Long version;

    private Boolean delete = Boolean.FALSE;

}
