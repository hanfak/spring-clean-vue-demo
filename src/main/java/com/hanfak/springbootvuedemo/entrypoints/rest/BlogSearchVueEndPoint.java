package com.hanfak.springbootvuedemo.entrypoints.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class BlogSearchVueEndPoint {

    private static final String FRONT_END = "/";

    @RequestMapping(value = FRONT_END, method = GET)
    public String index() {
        return "index";
    }
}
