package com.hanfak.springbootvuedemo.entrypoints.rest;

import com.hanfak.springbootvuedemo.core.domain.Blog;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import com.hanfak.springbootvuedemo.core.usecase.GetBlogPostsUsecase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BlogSearchEndPoint {

    private static final String API_PATH = "/api";
    private final GetAllBlogPostsUsecase getAllBlogPostsUsecase;
    private final GetBlogPostsUsecase getBlogPostsUsecase;

    public BlogSearchEndPoint(GetAllBlogPostsUsecase getAllBlogPostsUsecase, GetBlogPostsUsecase getBlogPostsUsecase) {
        this.getAllBlogPostsUsecase = getAllBlogPostsUsecase;
        this.getBlogPostsUsecase = getBlogPostsUsecase;
    }

    @RequestMapping(value = API_PATH, method = GET)
    public List<Blog> index() {
        return getAllBlogPostsUsecase.fetchAllBlogPosts();
    }

    @RequestMapping(value = "/api/{id}", method = GET)
    public Blog show(@PathVariable String id) {
        return getBlogPostsUsecase.fetchBlogPostBy(parseInt(id));
    }
}
