package com.hanfak.springbootvuedemo.dataprovider.database;

import com.hanfak.springbootvuedemo.core.domain.Blog;
import com.hanfak.springbootvuedemo.core.usecase.BlogRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
// This can use spring jdbc template to access a database via sql
public class BlogPostsDatabaseDataProvider implements BlogRepository {
    private final Blog firstBlog = new Blog("first post", "Blah blah Blah blah Blah blah Blah blah ", 1);
    private final Blog secondBlog = new Blog("second post", "boo booo boo boooo ", 2);
    private final List<Blog> blogPosts = Arrays.asList(firstBlog, secondBlog);

    @Override
    public List<Blog> getAllBlogPosts() {
        return blogPosts;
    }

    @Override
    public Blog getBlogPost(int id) throws IllegalStateException {
        Optional<Blog> first = blogPosts.stream().filter(post -> post.getId() == id).findFirst();
        if (first.isPresent()) {
            return first.get();
        } else {
            throw new IllegalStateException("No blog post exist");
        }
    }
}
