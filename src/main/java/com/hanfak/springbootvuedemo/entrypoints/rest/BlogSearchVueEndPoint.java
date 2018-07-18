package com.hanfak.springbootvuedemo.entrypoints.rest;

import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class BlogSearchVueEndPoint {

    public static final String VUE_API_PATH = "/";
    private final GetAllBlogPostsUsecase getAllBlogPostsUsecase;

    public BlogSearchVueEndPoint(GetAllBlogPostsUsecase getAllBlogPostsUsecase) {
        this.getAllBlogPostsUsecase = getAllBlogPostsUsecase;
    }

    @RequestMapping(value = VUE_API_PATH, method = GET)
    public String indexVue() {
        return "index";
    }
}
