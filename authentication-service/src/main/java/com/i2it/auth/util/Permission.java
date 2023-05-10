package com.i2it.auth.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    READ("read"),
    UPDATE("update"),
    CREATE("create"),
    DELETE("delete");

    @Getter
    private final String permission;
}
