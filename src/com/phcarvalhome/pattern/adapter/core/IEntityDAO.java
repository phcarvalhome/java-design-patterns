package com.phcarvalhome.pattern.adapter.core;

public interface IEntityDAO<T> {

    T get(int id);

    T saveOrUpdate(T entity);

    void delete(T entity);
}
