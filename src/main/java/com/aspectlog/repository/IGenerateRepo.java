package com.aspectlog.repository;

import java.util.List;

public interface IGenerateRepo<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
