package org.sarahwdt.model.dao;

import java.util.List;

public interface DAO<T> {
    T findById(int id);
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> findAll();
}
