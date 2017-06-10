package com.shanlin.error;

public enum CodeMessagge {
    SUCCESS(CodeNumber.SUUCCESS,"成功"),
    NOT_TOKEN(CodeNumber.NOT_TOKEN,"无此token"),
    NOT_EXISTS_USER(CodeNumber.NOT_EXISTS_USER,"用户不存在"),
    NOT_LOGIN(CodeNumber.NOT_LOGIN,"用户未登录"),
    EXPIRED_TOKEN(CodeNumber.EXPIRED_TOKEN,"token已失效"),
    NO_USERPASSWORD(CodeNumber.NO_USERPASSWORD,"用户名或密码为空"),
    ERROR_PASSWORD(CodeNumber.ERROR_PASSWORD,"用户输入的密码有误"),
    NOT_EXISTS_APP(CodeNumber.NOT_EXISTS_APP,"应用程序不存在"),
    NO_APPLICATIONID(CodeNumber.NO_APPLICATIONID,"应用ID不能为空"),
    FAILTOSAVE_TOKEN(CodeNumber.FAILTOSAVE_TOKEN,"token保存失败"),
    UNKNOW_EXCEPTION(CodeNumber.UNKNOW_EXCEPTION,"未知异常");


    public String code;
    public String message;
    CodeMessagge(String code,String message){
        this.code = code;
        this.message = message;
    }
    public String getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

}
