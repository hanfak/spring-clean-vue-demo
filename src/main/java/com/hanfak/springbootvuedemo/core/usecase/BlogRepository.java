package com.hanfak.springbootvuedemo.core.usecase;

import com.hanfak.springbootvuedemo.core.domain.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> getAllBlogPosts();
    Blog getBlogPost(int id) throws IllegalStateException;
}
