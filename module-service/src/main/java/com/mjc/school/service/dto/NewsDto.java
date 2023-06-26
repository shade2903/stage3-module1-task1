package com.mjc.school.service.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class NewsDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsDto newsDto)) return false;
        return Objects.equals(id, newsDto.id) && Objects.equals(title, newsDto.title) && Objects.equals(content, newsDto.content) && Objects.equals(createDate, newsDto.createDate) && Objects.equals(lastUpdateDate, newsDto.lastUpdateDate) && Objects.equals(authorId, newsDto.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return "NewsDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + formatter.format(createDate) +
                ", lastUpdateDate=" + formatter.format(lastUpdateDate) +
                ", authorId=" + authorId +
                '}';
    }

    public static NewsDtoBuilder getBuilder() {
        return new NewsDtoBuilder();
    }

    public static class NewsDtoBuilder {
        private final NewsDto newsDto;

        public NewsDtoBuilder() {
            newsDto = new NewsDto();
        }

        public NewsDtoBuilder setId(Long id) {
            newsDto.id = id;
            return this;
        }

        public NewsDtoBuilder setTitle(String title) {
            newsDto.title = title;
            return this;
        }

        public NewsDtoBuilder setContent(String content) {
            newsDto.content = content;
            return this;
        }

        public NewsDtoBuilder setCreateDate(LocalDateTime createDate) {
            newsDto.createDate = createDate;
            return this;
        }

        public NewsDtoBuilder setLastUpdateDate(LocalDateTime lastUpdateDate) {
            newsDto.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public NewsDtoBuilder setAuthorId(Long authorId) {
            newsDto.authorId = authorId;
            return this;
        }

        public NewsDto build() {
            return newsDto;
        }
    }
}
