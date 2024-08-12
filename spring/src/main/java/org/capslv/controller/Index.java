package org.capslv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class Index {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
