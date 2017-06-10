package com.shanlin.result;

/**
 * Created by dell on 2017/6/10.
 */
public class UserAndApplication {

    private String userName;
    private String appName;
    private String appKey;
    private String appSecrect;

    public UserAndApplication(){super();}
    public UserAndApplication(String userName, String appName, String appKey, String appSecrect) {
        this.userName = userName;
        this.appName = appName;
        this.appKey = appKey;
        this.appSecrect = appSecrect;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecrect() {
        return appSecrect;
    }

    public void setAppSecrect(String appSecrect) {
        this.appSecrect = appSecrect;
    }
}
