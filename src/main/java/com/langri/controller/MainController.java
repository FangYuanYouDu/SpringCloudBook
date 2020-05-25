package com.langri.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LangRi
 * 2020/5/24 10:32
 * @version 1.0.0
 */
@RestController
@RequestMapping("/hello")
public class MainController {

    @Value("${test.name}")
    private String aaa;

    @GetMapping
    public String callBack(){
        System.out.println("------------------"+aaa);
        return "hello";
    }
}
