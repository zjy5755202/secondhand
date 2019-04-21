package com.util;

import java.util.UUID;

public class UUIDGenerrator {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
