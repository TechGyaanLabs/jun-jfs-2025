package com.careerit.lsdata.domain;

import com.careerit.lsdata.util.UserContextUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private UUID id;
    @Column(name = "created_date", updatable = false, insertable = true, nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "modified_date", updatable = true, insertable = true, nullable = false)
    private LocalDateTime modifiedDate;
    @Column(name = "created_by", updatable = false, insertable = true, nullable = false)
    private UUID createdBy;
    @Column(name = "modified_by", updatable = true, insertable = true, nullable = false)
    private UUID modifiedBy;
    @Column(name = "deleted")
    private boolean deleted;

    @PrePersist
    public void init() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
        this.createdBy = UserContextUtil.getLoginUserId();
        this.modifiedBy = UserContextUtil.getLoginUserId();
        this.deleted = false;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
        this.modifiedBy = UserContextUtil.getLoginUserId();
    }


}
