package com.tracebucket.tron.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @author ffl
 * @since 13-01-2015
 * @version 0.1
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "entityId", column = @Column(name = "ID", nullable = false))})
    protected EntityId entityId;

    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    @Basic(fetch = FetchType.EAGER)
    private boolean passive;

    public BaseEntity(){
        this.entityId = EntityId.generate();
    }

    public EntityId getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    @PrePersist
    public void initEntityId() {
        if(this.entityId == null) {
            this.entityId = EntityId.generate();
        }
    }
}
