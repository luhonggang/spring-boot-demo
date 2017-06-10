package com.shanlin;

import com.shanlin.mapper.ApplicationRepository;
import com.shanlin.mapper.TokenRepository;
import com.shanlin.mapper.UserRepository;
import com.shanlin.model.Application;
import com.shanlin.model.Token;
import com.shanlin.model.UserInfo;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by dell on 2017/6/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserQueryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Test
    public void test() throws Exception{
        UserInfo info = userRepository.selectUserByUserName("张三");
        System.out.println(info.getUsername());
    }

    @Test
    public void testAppQuery(){
        Application app = applicationRepository.selectAppSecrect(1l);
        System.out.println("输出的应用ID的名称是:"+app.getAppId());
    }

   @Test
    public void testTokenInsert(){
        Token t = new Token();
       // t.setTokenId(null);
        t.setAppId(1l);
        t.setUserId(1l);
        t.setToken("123456789111");
//        t.setCreateTime(System.currentTimeMillis());
//        t.setExpireTime(System.currentTimeMillis()+11111l);
//        t.setFlag(1);// 长期有效
        Token token = tokenRepository.save(t);
       System.out.println("输出的tokenid"+token.getTokenId()+" "+token.getToken());
    }

}
