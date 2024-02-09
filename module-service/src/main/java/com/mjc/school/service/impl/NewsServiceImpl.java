package com.mjc.school.service.impl;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.impl.NewsRepositoryImpl;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.mapper.NewsMapper;

import java.util.List;

public class NewsServiceImpl implements NewsService<NewsDtoRequest, NewsDtoResponse> {
    private final NewsMapper newsMapper;
    private final NewsRepository<NewsModel> newsRepository;

    public NewsServiceImpl(NewsMapper newsMapper, NewsRepository<NewsModel> newsRepository) {
        this.newsMapper = NewsMapper.INSTANCE;
        this.newsRepository = new NewsRepositoryImpl();
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return null;
    }

    @Override
    public NewsDtoResponse readById(Long newsId) {
        return null;
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest dtoRequest) {
        return null;
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest dtoRequest) {
        return null;
    }

    @Override
    public Boolean deleteById(Long newsId) {
        return null;
    }
}
