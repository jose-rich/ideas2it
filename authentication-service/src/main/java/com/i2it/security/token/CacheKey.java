package com.i2it.security.token;

import lombok.Getter;

@Getter
public class CacheKey {
    public static final String USER = "user";
    public static final int DEFAULT_EXPIRE_SEC = 60;
}
