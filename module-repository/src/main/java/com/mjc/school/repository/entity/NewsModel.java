package com.mjc.school.repository.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsModel {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel() {
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
        if (!(o instanceof NewsModel newsModel)) return false;
        return Objects.equals(id, newsModel.id) && Objects.equals(title, newsModel.title)
                && Objects.equals(content, newsModel.content) && Objects.equals(createDate, newsModel.createDate)
                && Objects.equals(lastUpdateDate, newsModel.lastUpdateDate) && Objects.equals(authorId, newsModel.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId);
    }

    public static NewsModelBuilder getBuilder(){
        return new NewsModelBuilder();
    }

    public static class NewsModelBuilder{
        private final NewsModel newsModel;

        public NewsModelBuilder(){
            newsModel = new NewsModel();
        }

        public NewsModelBuilder setId(Long id){
            newsModel.id = id;
            return this;
        }

        public NewsModelBuilder setTitle(String title){
            newsModel.title = title;
            return this;
        }

        public NewsModelBuilder setContent(String content){
            newsModel.content = content;
            return this;
        }

        public NewsModelBuilder setCreateDate(LocalDateTime createDate){
            newsModel.createDate =createDate;
            return this;
        }
        public NewsModelBuilder setLastUpdateDate(LocalDateTime lastUpdateDate){
            newsModel.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public NewsModelBuilder setAuthorId(Long authorId){
            newsModel.authorId = authorId;
            return this;
        }

        public NewsModel build(){
            return newsModel;
        }
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", authorId=" + authorId +
                '}';
    }
}
