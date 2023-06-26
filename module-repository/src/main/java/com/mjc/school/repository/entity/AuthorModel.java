package com.mjc.school.repository.entity;

public class AuthorModel {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static AuthorModelBuilder getBuilder(){
        return  new AuthorModelBuilder();
    }
    public static class AuthorModelBuilder{
        private final AuthorModel authorModel;

        public AuthorModelBuilder(){
            authorModel = new AuthorModel();
        }

        public AuthorModelBuilder setId(Long id){
            authorModel.id = id;
            return this;
        }

        public AuthorModelBuilder setName (String name){
            authorModel.name = name;
            return this;
        }

        public AuthorModel build(){
            return authorModel;
        }
    }
}
