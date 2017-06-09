package com.shanlin;

import com.shanlin.mapper.MongodbUserRepository;
import com.shanlin.model.MongodbUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hezuchao on 2017/6/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTest {
    @Autowired
    private MongodbUserRepository mongodbUserRepository;
    @Before
    public void setUp() {
        mongodbUserRepository.deleteAll();
    }
    @Test
    public void test() throws Exception {
        // 创建三个User，并验证User总数
        mongodbUserRepository.save(new MongodbUser(1L, "didi", 30));
        mongodbUserRepository.save(new MongodbUser(2L, "mama", 40));
        mongodbUserRepository.save(new MongodbUser(3L, "kaka", 50));
        Assert.assertEquals(3, mongodbUserRepository.findAll().size());
        // 删除一个User，再验证User总数
        MongodbUser u = mongodbUserRepository.findOne(1L);
        mongodbUserRepository.delete(u);
        Assert.assertEquals(2, mongodbUserRepository.findAll().size());
        // 删除一个User，再验证User总数
        u = mongodbUserRepository.findByUsername("mama");
        mongodbUserRepository.delete(u);
        Assert.assertEquals(1, mongodbUserRepository.findAll().size());
    }
}
