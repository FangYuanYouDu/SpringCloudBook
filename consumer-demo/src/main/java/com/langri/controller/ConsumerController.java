package com.langri.controller;

import com.langri.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
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

    //添加负载均衡配置
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance instance = instances.get(0);

        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+userId;*/

        String url = "http://user-service/user/"+userId;
        return restTemplate.getForObject(url, User.class);
    }
}
