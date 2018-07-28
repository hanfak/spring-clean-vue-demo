package com.hanfak.springbootvuedemo.entrypoints.rest;

import com.hanfak.springbootvuedemo.core.domain.Blog;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BlogSearchEndPoint {

    public static final String API_PATH = "/index";
    private final GetAllBlogPostsUsecase getAllBlogPostsUsecase;

    public BlogSearchEndPoint(GetAllBlogPostsUsecase getAllBlogPostsUsecase) {
        this.getAllBlogPostsUsecase = getAllBlogPostsUsecase;
    }


    @RequestMapping(value = API_PATH, method = GET)
    public List<Blog> index() {
        return getAllBlogPostsUsecase.fetchAllBlogPosts();
    }
}
