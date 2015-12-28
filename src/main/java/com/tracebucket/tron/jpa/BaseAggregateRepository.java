package com.tracebucket.tron.jpa;

import com.tracebucket.tron.domain.BaseAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author sadath
 * @since 27-01-2015
 * @version 0.1
 */

@NoRepositoryBean
public interface BaseAggregateRepository<T extends BaseAggregate, ID extends Serializable> extends JpaRepository<T, ID> {
    public void delete(ID id, String tenantId);
    public T findOne(ID id, String tenantId);
    public List<T> findAll(String tenantId);
}