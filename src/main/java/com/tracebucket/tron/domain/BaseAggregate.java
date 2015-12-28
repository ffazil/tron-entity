package com.tracebucket.tron.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ffl
 * @since 13-01-2015
 * @version 0.1
 */
@MappedSuperclass
public abstract class BaseAggregate implements Serializable{

	@EmbeddedId
	@AttributeOverrides({
		  @AttributeOverride(name = "aggregateId", column = @Column(name = "ID", nullable = false))})
	protected AggregateId aggregateId;

	@Version
	private Long version;

    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    @Basic(fetch = FetchType.EAGER)
    private boolean passive;

    public BaseAggregate(){
    }

    public AggregateId getAggregateId() {
        return aggregateId;
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
    public void initAggregateId() {
        if(this.aggregateId == null) {
            this.aggregateId = AggregateId.generate();
        }
    }
}
