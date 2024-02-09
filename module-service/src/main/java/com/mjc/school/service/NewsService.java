package com.mjc.school.service;

import java.util.List;

public interface NewsService <T,R> {
    List<R> readAll();
    R readById(Long newsId);
    R create(T dtoRequest);
    R update(T dtoRequest);
    Boolean deleteById(Long newsId);
}
