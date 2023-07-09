package com.mjc.school.repository.impl;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.domain.DataSource;
import com.mjc.school.repository.entity.NewsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsRepositoryImpl implements NewsRepository<NewsModel> {
    private DataSource dataSource;

    public NewsRepositoryImpl(){
        dataSource = DataSource.getInstance();
    }
    @Override
    public NewsModel create(NewsModel entity) {
        Long id = readAll().get(readAll().size() -1).getId() + 1L;
        entity.setId(id);
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        dataSource.getAllNews().add(entity);
        return entity;
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getAllNews();
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource.getAllNews().stream().filter(e -> Objects.equals(e.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public NewsModel update(NewsModel entity) {
        NewsModel updatedNews = readById(entity.getId());
        updatedNews.setTitle(entity.getTitle());
        updatedNews.setContent(entity.getContent());
        updatedNews.setLastUpdateDate(entity.getLastUpdateDate());
        updatedNews.setAuthorId(entity.getAuthorId());
        return updatedNews;
    }

    @Override
    public Boolean delete(Long id) {
        List<NewsModel> removeList = new ArrayList<>();
        removeList.add(readById(id));
        return dataSource.getAllNews().removeAll(removeList);
    }
}
