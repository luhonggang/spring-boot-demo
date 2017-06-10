package com.shanlin.controller;

import com.shanlin.error.CodeMessagge;
import com.shanlin.model.Application;
import com.shanlin.model.UserInfo;
import com.shanlin.param.UserParam;
import com.shanlin.result.BaseResponse;
import com.shanlin.result.TokenParam;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

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

    @ApiOperation(value="登录接口信息", notes="第三方登录获取用户信息")
    @ApiImplicitParam(name = "UserParam", value = "用户详细实体user", required = true, dataType = "String")
    @RequestMapping(value = "/auth/checkforapplication", method = RequestMethod.POST)
    public BaseResponse loginForApplication(@RequestBody UserParam userParam) {
        // 1 用户名密码
        BaseResponse base = userService.checkLoginForUser(userParam);
        try{
            if("200".equals(base.getCode())){ // 一切正常
                if(StringUtils.isNotBlank(userParam.getAppId())){
                     /**
                     *  依据appId 获取 appSecrect 对比thickCode  对比规则暂时不处理
                     */
                        Application app = userService.selectAppSecrect(userParam.getAppId());
                        if(ConfirmThickCode.confirmThickCode(app.getAppSecrect())) {
                            UserInfo user = userService.selectUserByName(userParam.getUserName());
                            // 产生token  应用ID + 用户ID + UUID  UUIDUtils.getUniqueId()
                            List<String> list = new ArrayList<String>();
                            list.add(user.getUserId().toString());
                            list.add(userParam.getAppId());
                            String appToken = TokenManager.productToken(list);
                            // 将产生的token保存
                             if(StringUtils.isNotBlank(userService.insertIntoToken(list,appToken).getToken())){
                                 TokenParam param = new TokenParam();
                                         param.setToken(appToken);
                                base.setData(param);
                            }else{
                                base.setCode(CodeMessagge.FAILTOSAVE_TOKEN.getCode());
                                base.setMessages(CodeMessagge.FAILTOSAVE_TOKEN.getMessage());
                            }
                        }
                }else{ // 应用ID不可为空
                    base.setCode(CodeMessagge.NO_APPLICATIONID.getCode());
                    base.setMessages(CodeMessagge.NO_APPLICATIONID.getMessage());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("登录出现未知异常");
            base.setCode(CodeMessagge.UNKNOW_EXCEPTION.getCode());
            base.setMessages(CodeMessagge.UNKNOW_EXCEPTION.getMessage());
        }
        return  base;
    }

    @ApiOperation(value="用户信息", notes="查询用户信息")
    @ApiImplicitParam(name = "{userName}{appId}", value = "查询用户信息", required = true, dataType = "String")
    @RequestMapping(value = "/auth/getUserInfo/{userName}/{appId}", method = RequestMethod.GET)
    public BaseResponse getUserInfo(@PathVariable String userName,@PathVariable String appId) {
        return this.userService.selectUserAndAppMsg(userName,appId);
    }
}

