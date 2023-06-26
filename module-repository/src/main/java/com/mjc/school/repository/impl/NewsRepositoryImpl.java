package com.mjc.school.repository.impl;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.domain.DataSource;
import com.mjc.school.repository.entity.NewsModel;

import java.util.List;

public class NewsRepositoryImpl implements NewsRepository<NewsModel> {
    private DataSource dataSource;

    public NewsRepositoryImpl(){
        dataSource = DataSource.getInstance();
    }
    @Override
    public NewsModel create(NewsModel entity) {
        return dataSource.addNews(entity);
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getAllNews();
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource.getNewsById(id);
    }

    @Override
    public NewsModel update(NewsModel entity) {
        return dataSource.updateNews(entity);
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.removeNews(readById(id));
    }
}
