package com.mjc.school.service.impl;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.impl.NewsRepositoryImpl;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.utils.NewsValidator;

import java.util.List;

import static com.mjc.school.service.utils.NewsValidator.*;

public class NewsServiceImpl implements NewsService<NewsDtoRequest, NewsDtoResponse> {
    private final NewsMapper newsMapper;
    private final NewsRepository<NewsModel> newsRepository;
    private final NewsValidator newsValidator;

    public NewsServiceImpl() {
        this.newsMapper = NewsMapper.INSTANCE;
        this.newsRepository = new NewsRepositoryImpl();
        this.newsValidator = getNewsValidator();
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsRepository.readAll().stream().map(newsMapper::newsToDtoResponse).toList();
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
