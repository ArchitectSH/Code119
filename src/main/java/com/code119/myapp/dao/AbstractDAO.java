package com.code119.myapp.dao;

import java.util.List;

public interface AbstractDAO<E, K> {
    public E getOne(String queryId, K key);
    public List<E> getList(String queryId, K key);
    public int insert(String queryId, K key);
    public int delete(String queryId, K key);
    public int update(String queryId, K key);
}
