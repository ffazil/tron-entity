package com.tracebucket.tron.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author sadath
 * @since 28-01-2015
 * @version 0.1
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
public abstract class BaseValueObject {

    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    private boolean passive;

    public boolean isPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }
}
