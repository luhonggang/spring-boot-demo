package com.shanlin.utils;

import java.util.UUID;

public final class UUIDUtils {

    private static UUIDUtils INSTANCE = new UUIDUtils();

    public static UUIDUtils getInstance() {
        return INSTANCE;
    }

    public static String getUniqueId() {

        return UUID.randomUUID().toString().replace("-", "");

    }
}
