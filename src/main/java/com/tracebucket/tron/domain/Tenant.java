package com.tracebucket.tron.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;

@Embeddable
public class Tenant {
    @Column(name = "TENANT__ID")
    @Basic(fetch = FetchType.EAGER)
    private String uid;

    public Tenant() {
    }

    public Tenant(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
