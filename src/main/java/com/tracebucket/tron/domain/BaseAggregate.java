package com.tracebucket.tron.domain;


import javax.persistence.*;
import java.util.UUID;

/**
 * @author ffl
 * @since 13-01-2015
 * @version 0.1
 */
@MappedSuperclass
public abstract class BaseAggregate {
    @Id
/*    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")*/
    @Column(name = "UID")
    protected String uid;

	@Version
	private Long version;

    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    @Basic(fetch = FetchType.EAGER)
    private boolean passive;

    public BaseAggregate() {
        uid = UUID.randomUUID().toString();
    }

    public BaseAggregate(String uid) {
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