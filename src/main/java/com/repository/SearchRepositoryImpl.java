package com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.joblisting.JobListing.models.Post;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Override
    public List<Post> findByText(String text) {
        // TODO Auto-generated method stu
        List<Post> posts = new ArrayList<>();
        return posts;
    }

}
