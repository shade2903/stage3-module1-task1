package com.mjc.school.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDtoRequest {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
}
