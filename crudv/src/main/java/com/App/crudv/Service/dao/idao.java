package com.App.crudv.Service.dao;

import com.App.crudv.Entity.User;

import java.util.List;

public interface idao <T , ID>
{
    public void add(T object);
    public List<T> findAll();
    public T findById(ID id);
    public void save(T Object);
    public void update();
    public void delete();

}
