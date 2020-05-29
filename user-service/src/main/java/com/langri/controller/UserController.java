package com.langri.controller;

import com.langri.bean.User;
import com.langri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author FangYuan
 * 2020/5/29 14:00
 * @version 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        Optional<User> byId = userRepository.findById(userId);
        return byId.orElse(new User());
    }

    @GetMapping("/list")
    public Page<User> getListUsers(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){

        return userRepository.findAll(PageRequest.of(pageNum-1, pageSize));
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId,@RequestBody User user){
        user.setId(userId);
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Integer userId){
        userRepository.deleteById(userId);
    }
}
