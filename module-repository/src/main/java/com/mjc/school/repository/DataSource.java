package com.mjc.school.repository;


import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;


import java.util.List;

import static com.mjc.school.repository.data.AuthorData.getAuthorData;
import static com.mjc.school.repository.data.NewsData.getNewsData;

public class DataSource {
    private final List<NewsModel> news;
    private final List<AuthorModel> authors;

    private  DataSource(){
        this.authors = getAuthorData().getAuthorList();
        this.news = getNewsData(authors).getNewsList();
    }

    public List<NewsModel> getNews() {
        return news;
    }
    public static DataSource getInstance(){
        return LazyDataSource.INSTANCE;

    }
    private static class LazyDataSource {
        static final DataSource INSTANCE = new DataSource();
    }
}
