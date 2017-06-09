package com.shanlin.utils;
public class TokenManager {
    public static String productToken(String appId,String userId){
        return  appId+userId+UUIDUtils.getUniqueId();
    }
}
