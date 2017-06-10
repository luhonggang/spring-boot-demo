package com.shanlin.error;

/**
 * 返回的code定义
 */
public interface CodeNumber {
    public String SUUCCESS = "200";                 // 返回成功，用户已登录，验证token成功等
    public String NOT_TOKEN = "201 ";               // 无此token
    public String NOT_EXISTS_USER = "202";          // 用户不存在
    public String NOT_LOGIN = "203";                // 用户未登录
    public String EXPIRED_TOKEN = "204";            // token已失效
    public String NO_USERPASSWORD = "205";          // 用户名或密码为空
    public String ERROR_PASSWORD = "206";           // 用户输入的密码有误
    public String NOT_EXISTS_APP = "207";           // 应用程序不存在
    public String NO_APPLICATIONID = "208";         // 应用ID不能为空
    public String FAILTOSAVE_TOKEN = "209";         // token保存失败
    public String UNKNOW_EXCEPTION = "999";         // 未知异常
}
