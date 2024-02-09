package com.mjc.school.repository;

import com.mjc.school.repository.data.ConstData;
import com.mjc.school.repository.impl.NewsRepositoryImpl;
import com.mjc.school.repository.model.impl.NewsModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsRepositoryTest {
    Integer ACTUAL_SIZE_CONTENT = ConstData.SIZE_CONTENT;
    NewsRepository<NewsModel> repository = new NewsRepositoryImpl();

    @Test
    void testReadAll(){
        List<NewsModel> models = repository.readAll();
        assertEquals(models.size(), ACTUAL_SIZE_CONTENT);
    }



}
