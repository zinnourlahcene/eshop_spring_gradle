package com.lahcenezinnour.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lahcen on 4/4/17.
 */
public abstract class AbstractService<T, ID extends Serializable> {

    private JpaRepository<T, ID> repository;

    public AbstractService(JpaRepository<T, ID> jpaRepository) {
        repository = jpaRepository;
    }

    T find(ID id){
        return repository.getOne(id);
    }

    T save(T entity){
        return repository.save(entity);
    }

    List<T> save(Iterable<T> entities){
        return repository.saveAll(entities);
    }

    boolean exists(ID id){
        return repository.existsById(id);
    }

    long count(){
        return repository.count();
    }

    void delete(ID id){
        repository.deleteById(id);
    }

    void delete(T entity){
        repository.delete(entity);
    }

    T saveAndFlush(T entity){
        return repository.saveAndFlush(entity);
    }
}
