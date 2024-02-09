package com.mjc.school.repository.impl;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.model.impl.NewsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mjc.school.repository.DataSource.*;

public class NewsRepositoryImpl implements NewsRepository<NewsModel> {

    private DataSource dataSource;

    public NewsRepositoryImpl() {
        dataSource = getInstance();
    }

    @Override
    public NewsModel create(NewsModel entity) {
        List<NewsModel> newsModelList = getInstance().getNews();

        if (!newsModelList.isEmpty()) {
          entity.setId(newsModelList.get(readAll().size() - 1).getId() + 1L);
        }else {
            entity.setId(1L);
        }
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        dataSource.getNews().add(entity);
        return entity;
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNews();
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource.getNews().stream().filter(e -> Objects.equals(e.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public NewsModel update(NewsModel entity) {
        NewsModel updatedNews = readById(entity.getId());
        updatedNews.setTitle(entity.getTitle());
        updatedNews.setContent(entity.getContent());
        updatedNews.setLastUpdateDate(entity.getLastUpdateDate());
        updatedNews.setAuthorId(entity.getId());
        return updatedNews;
    }

    @Override
    public Boolean delete(Long id) {
        List<NewsModel> removeList = new ArrayList<>();
        removeList.add(readById(id));
        return dataSource.getNews().removeAll(removeList);
    }
}
