package com.mjc.school.repository.data;

import com.mjc.school.repository.model.impl.AuthorModel;
import com.mjc.school.repository.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AuthorData {
    private static AuthorData authorData;
    private List<AuthorModel> authorList;
    private AuthorData(){
        initAuthors();
    }

    public static AuthorData getAuthorData(){
        if(authorData == null){
            authorData = new AuthorData();
        }
        return authorData;
    }

    private void initAuthors() {
        List<String> data = Utils.getRandomContentResourceFile(ConstData.AUTHORS_FILE_NAME);
        authorList = new ArrayList<>();
        for (int i = 1; i <= (data.size() >= ConstData.SIZE_CONTENT ? ConstData.SIZE_CONTENT : data.size()); i++) {
            authorList.add(new AuthorModel((long) i, data.get(i)));
        }
    }

    public List<AuthorModel> getAuthorList() {
        return authorList;
    }


}
