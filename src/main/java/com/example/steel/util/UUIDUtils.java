package com.example.steel.util;


import java.util.UUID;

/**
 * 工具类
 */
public class UUIDUtils {
    /**
     *UUID工具类;
     * @return
     */

    public static String getUUid() {

        String uuid="";
        synchronized (uuid) {
            uuid = (UUID.randomUUID().toString()).replace("-", "");
        }
        return uuid;
    }
}