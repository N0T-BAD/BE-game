package com.blockpage.gameservice.adaptor.infrastructure.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "register_time", nullable = false, updatable = false)
    private LocalDateTime registerTime;

    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateDate;

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

}
