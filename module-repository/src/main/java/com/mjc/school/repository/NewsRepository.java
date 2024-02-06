package com.mjc.school.repository;

import java.util.List;

public interface NewsRepository<T> {
    T create(T entity);
    List<T> readAll();
    T readById(Long id);
    T update(T entity);
    Boolean delete(Long id);

}
