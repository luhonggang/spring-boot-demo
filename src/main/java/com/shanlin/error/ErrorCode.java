package com.shanlin.error;

/**
 * 类注释
 *
 * @author: luhonggang
 * @date: 2017/6/9
 * @time: 21:19
 * @see: 链接到其他资源
 * @since: 1.0
 */
public interface  ErrorCode {
    public String SUUCCESS = "000000";         // 表示成功
    public String NOT_LOGIN = "010000";        // 用户未登录
    public String NOT_PWASSWOR = "010001";     // 用户密码不正确
    public String UNKNOW_EXCEPTION = "999999"; // 未知异常
    public String OutTimeTokenException = "010002";  //
}
