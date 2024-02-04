package com.mjc.school.repository.model.impl;

import com.mjc.school.repository.model.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsModel implements BaseEntity<Long> {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;
    private Long authorId;
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;

    }
}
