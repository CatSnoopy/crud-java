package com.practica.crudoriginal.Service;

import java.util.List;

public interface idao<T, ID> {
    public List<T> findAll();
    public T getById(ID id);
    public void update(T entity);
    public void save(T entity);

    public void create(T entity);
    public void delete(long id_documents);
}
