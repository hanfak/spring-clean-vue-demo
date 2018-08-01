package com.hanfak.springbootvuedemo.entrypoints.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class BlogSearchVueEndPoint {

    private static final String VUE_API_PATH = "/blogs";
    private static final String VUE_SEARCH_API_PATH = "/search";


    @RequestMapping(value = VUE_API_PATH, method = GET)
    public String indexVue() {
        return "index1";
    }

    @RequestMapping(value = VUE_SEARCH_API_PATH, method = GET)
    public String searchVue() {
        return "search";
    }
}
