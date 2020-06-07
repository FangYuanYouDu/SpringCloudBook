package com.langri.repository;

import com.langri.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author FangYuan
 * 2020/5/29 15:48
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findUsersByCreateTimeBetweenOrderByCreateTimeDesc(Timestamp createTime, Timestamp createTime2);
}
