package com.repository;

import java.util.List;

import com.joblisting.JobListing.models.Post;

public interface  SearchRepository {
    
    List<Post> findByText(String text);

}
