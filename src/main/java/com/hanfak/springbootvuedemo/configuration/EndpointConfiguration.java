package com.hanfak.springbootvuedemo.configuration;

import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import com.hanfak.springbootvuedemo.core.usecase.GetBlogPostsUsecase;
import com.hanfak.springbootvuedemo.entrypoints.rest.BlogSearchEndPoint;
import com.hanfak.springbootvuedemo.entrypoints.rest.BlogSearchVueEndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public BlogSearchEndPoint blogSearchEndPoint(GetAllBlogPostsUsecase getAllBlogPostsUsecase, GetBlogPostsUsecase getBlogPostsUsecase) {
        return new BlogSearchEndPoint(getAllBlogPostsUsecase, getBlogPostsUsecase);
    }

    @Bean
    public BlogSearchVueEndPoint blogSearchVueEndPoint() {
        return new BlogSearchVueEndPoint();
    }
}
