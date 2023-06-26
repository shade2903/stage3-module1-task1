package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class ControllerImpl implements Controller<NewsDto> {
    private final NewsService<NewsDto> newsService;

    public ControllerImpl(){
        newsService = new NewsServiceImpl();
    }
    @Override
    public List<NewsDto> readAllNews() {
        return newsService.getAllNews();
    }

    @Override
    public NewsDto getById(Long id) throws RuntimeException {
        return newsService.getNewsById(id);
    }

    @Override
    public NewsDto create(NewsDto entity) throws RuntimeException {
        return newsService.createNews(entity);
    }

    @Override
    public NewsDto update(NewsDto entity) throws RuntimeException {
        return newsService.updateNews(entity);
    }

    @Override
    public Boolean delete(Long id) throws RuntimeException {
        return newsService.deleteNews(id);
    }
}
