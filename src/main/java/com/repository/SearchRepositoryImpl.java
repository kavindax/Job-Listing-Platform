package com.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joblisting.JobListing.models.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;


    @Override
    public List<Post> findByText(String text) {
        // TODO Auto-generated method stu
        List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("JobListing");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result;
        result = collection.aggregate(Arrays.asList(new Document("$search", 
                new Document("text",
                        new Document("query", text)
                                .append("path", "techs"))),
                new Document("$sort",
                        new Document("exp", -1L)),
                new Document("$limit", 5L)));
        
        result.forEach(doc -> {
            Post post = new Post();
            post.setProfile(doc.getString("profile"));
            post.setDesc(doc.getString("desc"));
            post.setExp(doc.getInteger("exp"));
            post.setTechs((String[]) doc.get("techs"));
            posts.add(post);
        });

        return posts;
    }

} 

