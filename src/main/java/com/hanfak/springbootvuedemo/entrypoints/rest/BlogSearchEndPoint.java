package com.hanfak.springbootvuedemo.entrypoints.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BlogSearchEndPoint {

    public static final String API_PATH = "/index";

    @RequestMapping(value = API_PATH, method = GET)
    public String index() {
        return "Index Page";
    }

}
