package com.hanfak.springbootvuedemo.entrypoints.rest;

import com.hanfak.springbootvuedemo.core.domain.Blog;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import com.hanfak.springbootvuedemo.core.usecase.GetBlogPostsUsecase;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class BlogSearchEndPointTest implements WithAssertions {

    private final GetBlogPostsUsecase getBlogPostsUsecase = Mockito.mock(GetBlogPostsUsecase.class);
    private final GetAllBlogPostsUsecase getAllBlogPostsUsecase = Mockito.mock(GetAllBlogPostsUsecase.class);
    private final BlogSearchEndPoint blogSearchEndPoint = new BlogSearchEndPoint(getAllBlogPostsUsecase, getBlogPostsUsecase);

    @Test
    public void shouldReturnAllBlogPosts() throws Exception {
        when(getAllBlogPostsUsecase.fetchAllBlogPosts())
                .thenReturn(Arrays.asList(new Blog("first post", "Blah blah Blah blah Blah blah Blah blah ", 1),
                        new Blog("second post", "boo booo boo boooo ", 2)));

        List<Blog> retrievedBlogPosts = blogSearchEndPoint.getAllBlogPosts();

        assertThat(retrievedBlogPosts).hasSize(2);
    }

}