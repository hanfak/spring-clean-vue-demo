package com.hanfak.springbootvuedemo.core.domain;

public class Blog {

    private final String title;
    private final String body;

    public Blog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
