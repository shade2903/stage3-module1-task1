package com.mjc.school.service;

import java.util.List;

public interface NewsService <T> {
    T createNews(T entity) throws RuntimeException;
    List<T> getAllNews();

    T getNewsById(Long id) throws RuntimeException;
    T updateNews(T entity) throws RuntimeException;

    Boolean deleteNews(Long id) throws RuntimeException;
}
