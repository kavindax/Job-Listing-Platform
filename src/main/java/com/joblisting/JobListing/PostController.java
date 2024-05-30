package com.joblisting.JobListing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PostController {

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws Exception{
        response.sendRedirect("/posts");
    }
    
}
