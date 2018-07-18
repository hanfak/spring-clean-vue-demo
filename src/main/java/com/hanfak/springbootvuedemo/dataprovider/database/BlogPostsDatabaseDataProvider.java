package com.hanfak.springbootvuedemo.dataprovider.database;

import com.hanfak.springbootvuedemo.core.domain.Blog;
import com.hanfak.springbootvuedemo.core.usecase.BlogRepository;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

public class BlogPostsDatabaseDataProvider implements BlogRepository {
    private final Blog firstBlog = new Blog("first post", "Blah blah Blah blah Blah blah Blah blah ");
    private final Blog secondBlog = new Blog("second post", "boo booo boo boooo ");
    private final List<Blog> blogPosts = Arrays.asList(firstBlog, secondBlog);

    @Override
    public List<Blog> getAllBlogPosts() {
        return blogPosts;
    }
}
