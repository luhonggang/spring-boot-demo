package com.shanlin.controller;

import com.shanlin.model.Application;
import com.shanlin.model.UserInfo;
import com.shanlin.param.UserParam;
import com.shanlin.result.BaseResponse;
import com.shanlin.service.UserService;
import com.shanlin.utils.ConfirmThickCode;
import com.shanlin.utils.TokenManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: luhonggang
 * @date: 2017/6/9
 * @time: 19:11
 * @see: 链接到其他资源
 * @since: 1.0
 */
@RestController
@Api(description = "用户")
public class UserRestController {
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
    @Autowired
    public UserService userService;

    @ApiOperation(value="用户登录信息", notes="第三方登录获取用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/auth/checkforapplication", method = RequestMethod.POST)
    public BaseResponse loginForApplication(@RequestBody UserParam userParam) {
        // 1 用户名密码
        BaseResponse base = userService.checkLoginForUser(userParam);
        String appToken = "";
        try{
            if(base.isSuccess()){ // 一切正常
                if(StringUtils.isBlank(userParam.getAppId())){
                     /**
                     *  依据appId 获取 appSecrect 对比thickCode  对比规则暂时不访问
                     */
                        Application app = userService.selectAppSecrect(userParam.getAppId());
                        if(ConfirmThickCode.confirmThickCode(app.getAppSecrect())) {
                            UserInfo user = userService.selectUserByName(userParam.getUserName());
                            // 产生token  应用ID + 用户ID + UUID  UUIDUtils.getUniqueId()
                            appToken = TokenManager.productToken(userParam.getAppId(), user.getUserId().toString());
                            // 将产生的token保存
                            if(StringUtils.isBlank(userService.insertIntoToken(userParam,appToken).getToken())){
                                base.setCode("200");
                                base.setMessages("处理成功");
                                base.setData(appToken);
                            }else{
                                base.setCode("205");
                                base.setMessages("token异常");
                            }

                        }
                }else{ // 应用ID不可为空
                    base.setCode("206");
                    base.setMessages("应用ID不可为空");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("");
        }
        return  base;
    }
}

