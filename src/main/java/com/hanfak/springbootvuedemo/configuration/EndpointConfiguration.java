package com.hanfak.springbootvuedemo.configuration;

import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import com.hanfak.springbootvuedemo.entrypoints.rest.BlogSearchEndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public BlogSearchEndPoint blogSearchEndPoint(GetAllBlogPostsUsecase getAllBlogPostsUsecase) {
        return new BlogSearchEndPoint(getAllBlogPostsUsecase);
    }
}
