package com.mjc.school.repository.domain;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSource {

    private final List<AuthorModel> authorModels;
    private final List<NewsModel> newsModels;
    private static final String PATH_AUTHOR = "author.txt";
    private static final String PATH_CONTENT = "content.txt";
    private static final String PATH_NEWS = "news.txt";
    private static final int DATA_SOURCE_SIZE = 20;


    private DataSource() {
        this.authorModels = initAuthorModels();
        this.newsModels = initNewsModels();
    }

    public static DataSource getInstance() {
        return LazyDataSource.INSTANCE;
    }

    private static class LazyDataSource{
        static final DataSource INSTANCE = new DataSource();
    }

    private List<AuthorModel> initAuthorModels() {
        List<AuthorModel> authors = new ArrayList<>();
        Long id = 1L;
        for (String s : readResourceFile(PATH_AUTHOR)) {
            authors.add(new AuthorModel(id,s));
            id++;
        }
        return authors;
    }

    private List<NewsModel> initNewsModels() {
        List<NewsModel> newsList = new ArrayList<>();
        List<String> news = readResourceFile(PATH_NEWS);
        List<String> content = readResourceFile(PATH_CONTENT);
        Long id = 1L;
        for (int i = 0; i < DATA_SOURCE_SIZE; i++) {
            newsList.add(
                    new NewsModel(id++,
                            news.get(i),
                            content.get(i),
                            LocalDateTime.now(),
                            LocalDateTime.now(),
                            authorModels.get(i).getId())
                            );
        }
        return newsList;
    }

    private List<String> readResourceFile(String path) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(path);
        List<String> listData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listData;
    }

    public List<NewsModel> getAllNews() {
        return newsModels;
    }

    public NewsModel getNewsById(Long id){
        return newsModels.stream().filter(e -> Objects.equals(e.getId(), id))
                .findFirst().orElse(null);
    }


    public NewsModel addNews(NewsModel entity) {
        Long id = newsModels.get(newsModels.size() -1).getId() + 1L;
        entity.setId(id);
        entity.setCreateDate(LocalDateTime.now());
        entity.setLastUpdateDate(LocalDateTime.now());
        newsModels.add(entity);
        return entity;
    }

    public boolean removeNews(NewsModel entity){
        return newsModels.remove(entity);
    }

    public NewsModel updateNews(NewsModel entity){
        NewsModel updatedNews = getNewsById(entity.getId());
        updatedNews.setContent(entity.getContent());
        updatedNews.setTitle(entity.getTitle());
        updatedNews.setLastUpdateDate(entity.getLastUpdateDate());
        updatedNews.setAuthorId(entity.getAuthorId());
        return updatedNews;
    }

}
