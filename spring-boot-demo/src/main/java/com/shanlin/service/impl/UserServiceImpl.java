package com.shanlin.service.impl;

import com.shanlin.error.CodeMessagge;
import com.shanlin.mapper.ApplicationRepository;
import com.shanlin.mapper.TokenRepository;
import com.shanlin.mapper.UserRepository;
import com.shanlin.model.Application;
import com.shanlin.model.Token;
import com.shanlin.model.UserInfo;
import com.shanlin.param.UserParam;
import com.shanlin.result.BaseResponse;
import com.shanlin.result.UserAndApplication;
import com.shanlin.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 类注释
 * @author: luhonggang
 * @date: 2017/6/9
 * @time: 14:45
 * @see: 链接到其他资源
 * @since: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private TokenRepository tokenRepository;
    /**
     *  用户是否存在判断
     */
    public BaseResponse checkLoginForUser(UserParam param) {
              BaseResponse baseResponse = new BaseResponse(CodeMessagge.SUCCESS.getCode(),CodeMessagge.SUCCESS.getMessage());
        try {
            if("".equals(param.getUserName()) || "".equals(param.getPassWord())){
                baseResponse = new BaseResponse(CodeMessagge.NO_USERPASSWORD.getCode(),CodeMessagge.NO_USERPASSWORD.getMessage());
            }else{
                UserInfo userEntity = userRepository.selectUserByUserName(param.getUserName());
                if(userEntity != null){
                    // 对比应用 请求中用户输入的密码是否正确
                    if(!userEntity.getPassword().equals(param.getPassWord())){
                        baseResponse  = new BaseResponse(CodeMessagge.ERROR_PASSWORD.getCode(),CodeMessagge.ERROR_PASSWORD.getMessage());
                    }
                }else{
                    baseResponse = new BaseResponse(CodeMessagge.NOT_EXISTS_USER.getCode(),CodeMessagge.NOT_EXISTS_USER.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("系统异常,请联系管理员!");
            baseResponse = new BaseResponse(CodeMessagge.UNKNOW_EXCEPTION.getCode(),CodeMessagge.UNKNOW_EXCEPTION.getMessage());
        }
        return  baseResponse;
    }

    @Override
    public UserInfo selectUserByName(String userName) {
        UserInfo user = null;
        try {
             user = userRepository.selectUserByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询用户的用户不存在");
        }
        return user;
    }

    @Override
    public Application selectAppSecrect(String appId) {
        return applicationRepository.selectAppSecrect(Long.parseLong(appId));
    }

    @Override
    public Token insertIntoToken(List<String> list, String appToken) {
        Token token =  new Token();
        token.setToken(appToken);
        token.setUserId(Long.parseLong(list.get(0)));
        token.setAppId(Long.parseLong(list.get(1)));
        return tokenRepository.save(token);
    }

    @Override
    public BaseResponse selectUserAndAppMsg(String userName, String appId) {
        UserAndApplication uap = new UserAndApplication();
        BaseResponse baseResponse = new BaseResponse(CodeMessagge.SUCCESS.getCode(),CodeMessagge.SUCCESS.getMessage());
        try{
            UserInfo user  = userRepository.selectUserByUserName(userName);
            if(StringUtils.isBlank(user.getUserId().toString())) {
                baseResponse = new BaseResponse(CodeMessagge.NOT_EXISTS_USER.getCode(), CodeMessagge.NOT_EXISTS_USER.getMessage());
            }else{
                if(StringUtils.isBlank(appId)) {
                    baseResponse = new BaseResponse(CodeMessagge.NO_APPLICATIONID.getCode(), CodeMessagge.NO_APPLICATIONID.getMessage());
                }else{
                    Application app = applicationRepository.selectAppSecrect(Long.parseLong(appId));
                    uap.setUserName(userName);
                    uap.setAppName(app.getAppName());
                    uap.setAppKey(app.getAppKey().toString());
                    uap.setAppSecrect(app.getAppSecrect());
                    baseResponse.setData(uap);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.info("查询用户信息异常");
            baseResponse = new BaseResponse(CodeMessagge.UNKNOW_EXCEPTION.getCode(),CodeMessagge.UNKNOW_EXCEPTION.getMessage());
        }
        return baseResponse;
    }

}
