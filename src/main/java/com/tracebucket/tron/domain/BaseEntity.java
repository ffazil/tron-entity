package com.tracebucket.tron.domain;

import java.util.UUID;

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
public abstract class BaseEntity {

    @Id
/*    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")*/
    @Column(name = "UID")
    protected String uid;

    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    @Basic(fetch = FetchType.EAGER)
    private boolean passive;

    public BaseEntity() {
        uid = UUID.randomUUID().toString();
    }

    public BaseEntity(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
    public void prePersist() {
        if(this.uid == null) {
            uid = UUID.randomUUID().toString();
        }
    }
}