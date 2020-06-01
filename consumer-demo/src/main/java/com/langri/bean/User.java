package com.langri.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author FangYuan
 * 2020/5/29 14:01
 * @version 1.0.0
 */
@Data
public class User {

    private Integer id;

    private String userId;

    private String userName;

    private String phone;

    private Integer lanId;

    private Integer regionId;

    private Timestamp createTime;
}
