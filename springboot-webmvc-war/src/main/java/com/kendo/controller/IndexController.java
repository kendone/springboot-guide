package com.kendo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kendone
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "Hello Spring Boot";
    }

}
