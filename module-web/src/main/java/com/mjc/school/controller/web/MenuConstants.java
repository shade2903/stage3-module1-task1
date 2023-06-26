package com.mjc.school.controller.web;

public class MenuConstants {
    private MenuConstants(){

    }
    public static final String START_MENU_TEXT =
            """
                    Enter the number of operation:
                    1 - Get all news.
                    2 - Get news by id.
                    3 - Create news.
                    4 - Update news.
                    5 - Remove news by id.
                    0 - Exit.
                    """;

    public static final String ENTER_ID = "Enter news id:";
    public static final String ENTER_TITLE = "Enter title:";
    public static final String ENTER_CONTENT = "Enter content:";
    public static final String ENTER_AUTHOR_ID = "Enter author id:";

    public static final String OPERATION_GET_ALL = "Operation: Get all news.";
    public static final String OPERATION_GET_BY_ID = "Operation: Get news by id.";
    public static final String OPERATION_CREATE = "Operation: Create news.";
    public static final String OPERATION_UPDATE = "Operation: Update news.";
    public static final String OPERATION_DELETE = "Operation: Delete news.";
    public static final String OPERATION_EXIT = "Bye!";
    public static final String OPERATION_ERROR = "Incorrect command!";

}
