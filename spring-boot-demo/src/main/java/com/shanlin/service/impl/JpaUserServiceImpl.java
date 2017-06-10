package com.shanlin.service.impl;

import com.shanlin.mapper.JpaUserRepository;
import com.shanlin.model.JpaUser;
import com.shanlin.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hezuchao、 on 2017/6/8.
 */
@Service
public class JpaUserServiceImpl implements JpaUserService {
    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Override
    public JpaUser findById(Long id) {
        return jpaUserRepository.findById(id);
    }
}
