package com.tracebucket.tron.jpa;

import com.tracebucket.tron.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author sadath
 * @since 06-02-2015
 * @version 0.1
 */

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
    public void delete(ID id, String tenantId);
    public T findOne(ID id, String tenantId);
    public List<T> findAll(String tenantId);
}