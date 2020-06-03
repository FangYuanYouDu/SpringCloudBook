package com.langri.controller;

import com.langri.bean.User;
import com.langri.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author FangYuan
 * 2020/6/3 17:14
 * @version 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void queryByDatetime() {
        List<User> usersByCreateTimeBetween = userRepository.findUsersByCreateTimeBetweenOrderByCreateTimeDesc(new Timestamp(Long.parseLong("1591148905")), new Timestamp(Long.parseLong("1591148910")));
        System.out.println(usersByCreateTimeBetween.toString());
    }
}