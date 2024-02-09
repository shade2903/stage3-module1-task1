package com.mjc.school.service.utils;

import com.mjc.school.repository.data.ConstData;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.exception.InvalidDataException;
import com.mjc.school.service.exception.NotFoundException;

public class NewsValidator {
    private static int MIN_TITLE_LENGTH = 5;
    private static int MAX_TITLE_LENGTH = 30;
    private static int MIN_CONTENT_LENGTH = 5;
    private static int MAX_CONTENT_LENGTH = 255;
    private static Long MIN_AUTHOR_ID = 1L;
    private static Long MAX_AUTHOR_ID = ConstData.SIZE_CONTENT.longValue();
    private static String NOT_VALID_TITLE =  "News title can not be less than %d and more than %d symbols. News title is %s";
    private static String NOT_VALID_CONTENT =  "News content can not be less than %d and more than %d symbols. News title is %s";
    private static String NOT_FOUND_DATA = " %s with id %d does not exist.";
    private static String NOT_VALID_NUMBER = "Id can not be null or less than 1. is: %d.";

    private static  NewsValidator newsValidator;

    public static NewsValidator getNewsValidator(){
        if(newsValidator == null){
            newsValidator = new NewsValidator();
        }
        return newsValidator;
    }

    public  void validateDTO(NewsDtoRequest request){
        validateNewsId(request.getId());
        validateTitle(request.getTitle());
        validateContent(request.getContent());
        validateAuthorId(request.getAuthorId());
    }

    private   void validateContent(String content){
        if(content == null || content.length() < MIN_CONTENT_LENGTH || content.length() > MAX_CONTENT_LENGTH)
            throw new InvalidDataException(String.format(NOT_VALID_CONTENT, MIN_CONTENT_LENGTH, MAX_CONTENT_LENGTH, content.length()));
    }

    private  void validateTitle(String title){
        if(title == null || title.length() < MIN_TITLE_LENGTH || title.length() > MAX_TITLE_LENGTH)
            throw new InvalidDataException(String.format(NOT_VALID_TITLE, MIN_TITLE_LENGTH, MAX_TITLE_LENGTH, title.length()));
    }

    private void validateAuthorId(Long id){
        validateNumber(id);
        if(id > MAX_AUTHOR_ID)
            throw new NotFoundException(String.format(NOT_FOUND_DATA, "Author", id));
    }

    private void validateNumber(Long id){
        if(id == null || id < 1){
            throw new InvalidDataException(String.format(NOT_VALID_NUMBER,id));
        }
    }

    public void validateNewsId(Long id){
        validateNumber(id);
    }


}
