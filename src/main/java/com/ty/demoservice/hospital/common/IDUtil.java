package com.ty.demoservice.hospital.common;

import java.util.UUID;

/**
 * @author xch
 * @date 2022/2/24 19:19
 */
public final class IDUtil {
    public static String UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
