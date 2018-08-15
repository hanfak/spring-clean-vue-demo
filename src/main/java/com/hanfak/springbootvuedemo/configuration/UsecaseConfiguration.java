package com.hanfak.springbootvuedemo.configuration;

import com.hanfak.springbootvuedemo.core.usecase.BlogRepository;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import com.hanfak.springbootvuedemo.core.usecase.GetBlogPostsUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfiguration {

    @Bean
    public GetAllBlogPostsUsecase getAllBlogPostsUsecase(BlogRepository blogRepository) {
        return new GetAllBlogPostsUsecase(blogRepository);
    }

    @Bean
    public GetBlogPostsUsecase getBlogPostsUsecase(BlogRepository blogRepository) {
        return new GetBlogPostsUsecase(blogRepository);
    }
}
