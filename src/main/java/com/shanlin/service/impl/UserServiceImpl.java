package com.shanlin.service.impl;

import com.shanlin.mapper.UserRepository;
import com.shanlin.model.Application;
import com.shanlin.model.Token;
import com.shanlin.model.UserInfo;
import com.shanlin.param.UserParam;
import com.shanlin.result.BaseResponse;
import com.shanlin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类注释
 *
 * @author: luhonggang
 * @date: 2017/6/9
 * @time: 14:45
 * @see: 链接到其他资源
 * @since: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    /**
     *  用户是否存在判断
     */
    public BaseResponse checkLoginForUser(UserParam param) {
        boolean flag = true;
        String message = "";
        try {
            if(!"".equals(param.getUserName()) || !"".equals(param.getPassWord())){
                flag = false;
                message = "输入的用户名或密码不能为空!";
                System.out.println("用户名和密码不能为空");
            }else{
                UserInfo userEntity = userRepository.selectUserByUserName(param.getUserName());
                if(userEntity == null){
                    // 对比应用 请求中用户输入的密码是否正确
                    if(!userEntity.getPassword().equals(param.getPassWord())){
                        flag = false;
                        message="用户输入的密码有误!";
                    }
                }else{
                    message = "用户不存在";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("系统异常,请联系管理员!");
        }
        return  new BaseResponse(flag,null,message);
    }

    @Override
    public UserInfo selectUserByName(String userName) {
        return null;
    }

    @Override
    public Application selectAppSecrect(String appId) {
        return null;
    }

    @Override
    public Token insertIntoToken(UserParam userParam, String appToken) {
        return null;
    }

}
