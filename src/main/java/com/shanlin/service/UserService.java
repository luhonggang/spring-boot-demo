package com.shanlin.service;
import com.shanlin.model.Application;
import com.shanlin.model.Token;
import com.shanlin.model.UserInfo;
import com.shanlin.param.UserParam;
import com.shanlin.result.BaseResponse;

public interface UserService {
	BaseResponse checkLoginForUser(UserParam user);

	UserInfo selectUserByName(String userName);

	Application selectAppSecrect(String appId);

	Token insertIntoToken(UserParam userParam, String appToken);

}
