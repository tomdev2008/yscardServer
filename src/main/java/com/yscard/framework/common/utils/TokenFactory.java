package com.yscard.framework.common.utils;

public class TokenFactory {
    public static String getUserToken() {
        return java.util.UUID.randomUUID().toString();
    }
}
