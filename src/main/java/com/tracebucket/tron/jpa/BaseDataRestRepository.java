package com.tracebucket.tron.jpa;

import com.tracebucket.tron.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sadath on 03-Feb-2016.
 */
@NoRepositoryBean
public interface BaseDataRestRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
    void delete(ID id, String tenantId);
    T findOne(ID id, String tenantId);
    List<T> findAll(String tenantId);
}