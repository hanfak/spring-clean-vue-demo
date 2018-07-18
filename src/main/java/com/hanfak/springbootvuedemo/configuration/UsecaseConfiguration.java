package com.hanfak.springbootvuedemo.configuration;

import com.hanfak.springbootvuedemo.core.usecase.BlogRepository;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfiguration {

    @Bean
    public GetAllBlogPostsUsecase getAllBlogPostsUsecase(BlogRepository blogRepository) {
        return new GetAllBlogPostsUsecase(blogRepository);
    }

}
