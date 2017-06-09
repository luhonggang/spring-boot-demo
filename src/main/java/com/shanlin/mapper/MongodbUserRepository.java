package com.shanlin.mapper;


import com.shanlin.model.MongodbUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by hezuchao on 2017/6/9.
 */
public interface MongodbUserRepository extends MongoRepository<MongodbUser, Long> {
    MongodbUser findByUsername(String username);
}
