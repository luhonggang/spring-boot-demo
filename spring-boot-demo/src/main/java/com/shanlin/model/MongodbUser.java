package com.shanlin.model;

import javax.persistence.Id;

/**
 * Created by hezuchao on 2017/6/9.
 */
public class MongodbUser {
    @Id
    private Long id;
    private String username;
    private Integer age;
    public MongodbUser(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
    // 省略getter和setter
}
