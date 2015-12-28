package com.tracebucket.tron.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;

/**
 * Created by ffl on 22-01-2015.
 * This is Organization in the partner bounded context.
 */
@Embeddable
public class Tenant {
    @Column(name = "TENANT__ID")
    @Basic(fetch = FetchType.EAGER)
    private String tenantUid;

    public Tenant() {

    }

    public Tenant(String tenantUid) {
        this.tenantUid = tenantUid;
    }

    public String getTenantUid() {
        return tenantUid;
    }

    public void setTenantUid(String tenantUid) {
        this.tenantUid = tenantUid;
    }
}
