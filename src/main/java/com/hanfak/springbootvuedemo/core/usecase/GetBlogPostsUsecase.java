package com.hanfak.springbootvuedemo.core.usecase;

import com.hanfak.springbootvuedemo.core.domain.Blog;

public class GetBlogPostsUsecase {
    private final BlogRepository blogRepository;

    public GetBlogPostsUsecase(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog fetchBlogPostBy(int id) {
        Blog blogPost = null;
        try {
            blogPost = blogRepository.getBlogPost(id);
        } catch( Exception e) {
            e.printStackTrace();
        }
        return blogPost;


    }
}
