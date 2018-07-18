package com.hanfak.springbootvuedemo.configuration;

import com.hanfak.springbootvuedemo.dataprovider.database.BlogPostsDatabaseDataProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseDataProviderConfiguration {
    @Bean
    public BlogPostsDatabaseDataProvider blogPostsDatabaseDataProvider() {
        return new BlogPostsDatabaseDataProvider();
    }



}
