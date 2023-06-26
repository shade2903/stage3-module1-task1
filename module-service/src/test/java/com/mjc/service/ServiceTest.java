package com.mjc.service;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.impl.NewsRepositoryImpl;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.impl.NewsServiceImpl;
import com.mjc.school.service.mapper.NewsMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {


    NewsService<NewsDto> newsService = new NewsServiceImpl();
    private NewsModel modelNews = NewsModel.getBuilder()
            .setId(15L)
            .setTitle("Some test title")
            .setContent("Some test content")
            .setCreateDate(LocalDateTime.now())
            .setLastUpdateDate(LocalDateTime.now())
            .setAuthorId(11L)
            .build();

    private NewsDto newsDto = NewsDto.getBuilder()
            .setId(2L)
            .setTitle("Some new test title")
            .setContent("Some new test content")
            .setCreateDate(LocalDateTime.now())
            .setLastUpdateDate(LocalDateTime.now())
            .setAuthorId(7l)
            .build();


    @Test
    void testNewsModelFromDto() {
        NewsModel testNewsModel = NewsMapper.INSTANCE.NewsModelFromDto(newsDto);
        assertEquals(testNewsModel.getId(), newsDto.getId());
        assertEquals(testNewsModel.getTitle(), newsDto.getTitle());
        assertEquals(testNewsModel.getContent(), newsDto.getContent());
        assertEquals(testNewsModel.getCreateDate(), newsDto.getCreateDate());
        assertEquals(testNewsModel.getLastUpdateDate(), newsDto.getLastUpdateDate());
        assertEquals(testNewsModel.getAuthorId(), newsDto.getAuthorId());
    }

    @Test
    void testNewsModelToDto() {
        NewsDto testNewsDto = NewsMapper.INSTANCE.NewsModelToDto(modelNews);
        assertEquals(testNewsDto.getId(), modelNews.getId());
        assertEquals(testNewsDto.getTitle(), modelNews.getTitle());
        assertEquals(testNewsDto.getContent(), modelNews.getContent());
        assertEquals(testNewsDto.getCreateDate(), modelNews.getCreateDate());
        assertEquals(testNewsDto.getLastUpdateDate(), modelNews.getLastUpdateDate());
        assertEquals(testNewsDto.getAuthorId(), modelNews.getAuthorId());

    }

    @Test
    void testGetAllNews() {
        List<NewsDto> newsDtoList = newsService.getAllNews();
        assertEquals(newsDtoList.size(), 20);
    }

    @Test
    void testGetNewsById(){
        NewsDto newsDto = newsService.getNewsById(5l);
        assertNotNull(newsDto);
        assertEquals(newsDto.getAuthorId(),5l);
        System.out.println(newsDto);
    }

    @Test
    void testUpdateNews(){
        Long expectedId = 2L;
        String expectedTitle = "Some new test title";
        String expectedContent = "Some new test content";
        Long expectedAuthorId = 7l;
        NewsDto updatedNewsDto = newsService.updateNews(newsDto);
        assertEquals(updatedNewsDto.getAuthorId(),expectedAuthorId);
        assertEquals(updatedNewsDto.getTitle(),expectedTitle);
        assertEquals(updatedNewsDto.getContent(),expectedContent);
        assertEquals(updatedNewsDto.getId(),expectedId);
        System.out.println(newsDto);
    }


    @Test
     void testDeleteNews(){
        int actualListSizeBeforeOperation = newsService.getAllNews().size();
        assertTrue(newsService.deleteNews(5l));
        int actualListSizeAfterOperation = newsService.getAllNews().size();
        assertEquals(actualListSizeBeforeOperation -1,actualListSizeAfterOperation);
    }

    @Test

    void testCreateNews(){
        int actualListSizeBeforeOperation = newsService.getAllNews().size();
        NewsDto newsDto1 = NewsDto.getBuilder()
                .setTitle("TitleTestFromDto")
                .setContent("ContentTestFromDto")
                .setAuthorId(12l)
                .build();
        NewsDto newDtoFromServer = newsService.createNews(newsDto1);
        int actualListSizeAfterOperation = newsService.getAllNews().size();
        assertEquals(actualListSizeBeforeOperation +1,actualListSizeAfterOperation);
        assertEquals(newDtoFromServer.getTitle(), newsDto1.getTitle());
        assertEquals(newDtoFromServer.getContent(), newsDto1.getContent());
        assertEquals(newDtoFromServer.getAuthorId(), newsDto1.getAuthorId());
    }
}


