package com.rodrigoleon.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class Audit {
    @Column(unique = true)
    private String externalId;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant disabledAt;

    public Audit() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.disabledAt = null;
        this.setRandomExternalId();
    }

    public void setRandomExternalId() {
        this.externalId = UUID.randomUUID().toString();
    }

    public void active() {
        this.updatedAt = Instant.now();
        this.disabledAt = null;
    }

    public void disable() {
        this.updatedAt = Instant.now();
        this.disabledAt = Instant.now();
    }
}
