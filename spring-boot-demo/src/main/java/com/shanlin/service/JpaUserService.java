package com.shanlin.service;


import com.shanlin.model.JpaUser;

/**
 * Created by hezuchao on 2017/6/8.
 */
public interface JpaUserService {
    JpaUser findById(Long id);
}
