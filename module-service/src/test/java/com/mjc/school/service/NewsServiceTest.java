package com.mjc.school.service;

import com.mjc.school.repository.model.impl.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.time.LocalDateTime;

public class NewsServiceTest {
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
            "Some responce title",
            "Some responce content",
            LocalDateTime.now(),
            LocalDateTime.now(),
            7L);

}
