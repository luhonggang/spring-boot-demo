package com.shanlin.utils;

import java.util.List;

public class TokenManager {
    public static String productToken(List<String> list){
        return  list.get(0)+list.get(1)+UUIDUtils.getUniqueId();
    }
}
