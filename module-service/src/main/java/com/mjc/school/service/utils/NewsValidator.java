package com.mjc.school.service.utils;

public class NewsValidator {
    private static int MIN_TITLE_LENGTH = 5;
    private static int MAX_TITLE_LENGTH = 30;
    private static int MIN_CONTENT_LENGTH = 5;
    private static int MAX_CONTENT_LENGTH = 255;

    private static Long MIN_AUTHOR_ID = 1L;
    private static Long MAX_AUTHOR_ID = 20L;

    private static String NOT_VALID_TITLE =  "News title can not be less than %d and more than %d symbols. News title is %s";

    private static String NOT_VALID_CONTENT =  "News content can not be less than %d and more than %d symbols. News title is %s";

    private static String NOT_FOUND_DATA = " %s with id %d does not exist.";

}
