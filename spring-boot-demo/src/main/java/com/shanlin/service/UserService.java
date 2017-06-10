package com.shanlin.service;
import com.shanlin.model.Application;
import com.shanlin.model.Token;
import com.shanlin.model.UserInfo;
import com.shanlin.param.UserParam;
import com.shanlin.result.BaseResponse;

import java.util.List;

public interface UserService {
	BaseResponse checkLoginForUser(UserParam user);

	UserInfo selectUserByName(String userName);

	Application selectAppSecrect(String appId);

	Token insertIntoToken(List<String> list, String appToken);

	BaseResponse selectUserAndAppMsg(String userName, String appId);
}
