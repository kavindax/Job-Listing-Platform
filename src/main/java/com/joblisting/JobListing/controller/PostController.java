package com.joblisting.JobListing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joblisting.JobListing.models.Post;
import com.repository.PostRepository;
import com.repository.SearchRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws Exception{
        response.sendRedirect("/posts");
    }

    @GetMapping("/posts")
    public List<Post>  getAllPosts(){
        
        return postRepository.findAll();
    }
    
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);

    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text)
    {
        return searchRepository.findByText(text);
    }
}