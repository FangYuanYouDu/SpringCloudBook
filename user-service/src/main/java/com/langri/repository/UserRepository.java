package com.langri.repository;

import com.langri.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author FangYuan
 * 2020/5/29 15:48
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
