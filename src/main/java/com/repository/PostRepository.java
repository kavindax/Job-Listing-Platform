package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joblisting.JobListing.models.Post;

public interface PostRepository extends MongoRepository<Post, String>
{


}
 