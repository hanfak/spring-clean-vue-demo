package com.hanfak.springbootvuedemo.core.domain;

public class Blog {

    private final String title;
    private final String body;
    private final int id;

    public Blog(String title, String body, int id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public int getId() {
        return id;
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
