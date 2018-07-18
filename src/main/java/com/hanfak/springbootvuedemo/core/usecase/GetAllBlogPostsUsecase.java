package com.hanfak.springbootvuedemo.core.usecase;

import com.hanfak.springbootvuedemo.core.domain.Blog;

import java.util.List;

public class GetAllBlogPostsUsecase {
    private final BlogRepository blogRepository;

    public GetAllBlogPostsUsecase(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> fetchAllBlogPosts() {
        return blogRepository.getAllBlogPosts();
    }
}
