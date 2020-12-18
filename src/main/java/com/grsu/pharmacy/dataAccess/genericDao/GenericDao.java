package com.grsu.pharmacy.dataAccess.genericDao;

public interface GenericDao<T> {

    T findById(int id);

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);
}
