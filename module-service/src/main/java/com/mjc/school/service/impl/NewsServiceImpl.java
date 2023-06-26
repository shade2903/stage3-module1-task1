package com.mjc.school.service.impl;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.impl.NewsRepositoryImpl;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.utils.NewsValidator;

import java.util.ArrayList;
import java.util.List;


public class NewsServiceImpl implements NewsService<NewsDto> {
    private final NewsMapper newsMapper;
    private final NewsRepository<NewsModel> repository;

    private final NewsValidator newsValidator;

    public NewsServiceImpl(){
        newsMapper = NewsMapper.INSTANCE;
        repository = new NewsRepositoryImpl();
        newsValidator = new NewsValidator();
    }
    @Override
    public NewsDto createNews(NewsDto entity) throws RuntimeException {
        newsValidator.validateDTO(entity);
        NewsModel news = repository.create(newsMapper.NewsModelFromDto(entity));
        return newsMapper.NewsModelToDto(news);
    }

    @Override
    public List<NewsDto> getAllNews() {
        List<NewsDto> newsDtoList = new ArrayList<>();
        for(NewsModel e : repository.readAll()){
            newsDtoList.add(newsMapper.NewsModelToDto(e));
        }
        return newsDtoList;
    }


    @Override
    public NewsDto getNewsById(Long id) throws RuntimeException {
        NewsDto newsDto = newsMapper.NewsModelToDto(repository.readById(id));
        newsValidator.validateNewsExist(id,newsDto);
        return newsDto;
    }

    @Override
    public NewsDto updateNews(NewsDto entity) throws RuntimeException {
        newsValidator.validateDTO(entity);
        newsValidator.validateNewsExist(entity.getId(), entity);

        NewsModel updatedModel = repository.update(newsMapper.NewsModelFromDto(entity));
        return newsMapper.NewsModelToDto(updatedModel);
    }

    @Override
    public Boolean deleteNews(Long id) throws RuntimeException {
        NewsDto newsDto = newsMapper.NewsModelToDto(repository.readById(id));
        newsValidator.validateNewsExist(id,newsDto);
        return repository.delete(id);
    }
}
