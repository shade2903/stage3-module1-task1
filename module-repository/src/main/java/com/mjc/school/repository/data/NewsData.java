package com.mjc.school.repository.data;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.repository.utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mjc.school.repository.data.AuthorData.getAuthorData;

public class NewsData {
    private static NewsData newsData;

    public List<NewsModel> getNewsList() {
        return newsList;
    }

    private List<NewsModel> newsList;

    private NewsData(List<AuthorModel> authorModelList){
        initNews(authorModelList);
    }

    public static NewsData getNewsData(List<AuthorModel> authorModelList){
        if(newsData == null){
            newsData = new NewsData(authorModelList);
        }
        return newsData;
    }


    private void initNews(List<AuthorModel> authorModelList) {
        List<String> dataNews = Utils.getRandomContentResourceFile(ConstData.NEWS_FILE_NAME);
        List<String> dataContent = Utils.getRandomContentResourceFile(ConstData.CONTENT_FILE_NAME);
        newsList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= (dataNews.size() >= ConstData.SIZE_CONTENT ? ConstData.SIZE_CONTENT : dataNews.size()); i++) {
            LocalDateTime date = Utils.getRandomDate();
            newsList.add(new NewsModel(
                    (long) i,
                    dataNews.get(i),
                    dataContent.get(i),
                    date,
                    date,
                    authorModelList.get(random.nextInt(authorModelList.size())).getId()));
        }
    }


}
