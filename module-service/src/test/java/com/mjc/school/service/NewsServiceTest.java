package com.mjc.school.service;

import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.impl.NewsServiceImpl;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsServiceTest {

    NewsService<NewsDtoRequest, NewsDtoResponse> newsService = new NewsServiceImpl();
    private NewsModel model = new NewsModel(
            15L,
            "Some title",
            "Some content",
            LocalDateTime.now(),
            LocalDateTime.now(),
            9L);

    private NewsDtoRequest newsDtoRequest = new NewsDtoRequest(
            3L,
            "Some request title",
            "Some request content",
            2L);

    private NewsDtoResponse newsDtoResponse = new NewsDtoResponse(
            14L,
            "Some response title",
            "Some response content",
            LocalDateTime.now(),
            LocalDateTime.now(),
            7L);

    @Test
    void testGetAllNews(){
        List<NewsDtoResponse> list = newsService.readAll();
        list.stream().forEach(System.out::println);
        assertEquals(list.size(),20);


    }


}
