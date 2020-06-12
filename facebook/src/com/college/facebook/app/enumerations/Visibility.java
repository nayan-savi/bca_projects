package com.college.facebook.app.enumerations;

import java.util.HashMap;
import java.util.Map;

public enum Visibility {

    PRIVATE(1),
    FRIEND(2),
    PUBLIC(3);

    private int value;
    private static Map map = new HashMap();

    private Visibility(int value) {
        this.value = value;
    }

    static {
        for (Visibility visibility : Visibility.values()) {
            map.put(visibility.value, visibility);
        }
    }

    public static Visibility valueOf(int level) {
        return (Visibility) map.get(level);
    }

    public int getValue() {
        return value;
    }
}
