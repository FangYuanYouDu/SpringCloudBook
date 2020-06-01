package com.langri.controller;

import com.langri.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author FangYuan
 * 2020/6/1 11:02
 * @version 1.0.0
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8091/user/"+userId;
        return restTemplate.getForObject(url, User.class);
    }
}
