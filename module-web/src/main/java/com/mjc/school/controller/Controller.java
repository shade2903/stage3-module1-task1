package com.mjc.school.controller;

import java.util.List;

public interface Controller <T>{
    List<T> readAllNews();

    T getById(Long id) throws RuntimeException;

    T create(T entity) throws RuntimeException;

    T update(T entity) throws RuntimeException;

    Boolean delete(Long id) throws RuntimeException;
}
