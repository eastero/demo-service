package com.ty.demoservice.hospital.common;

/**
 * @author xch
 * @date 2022-02-24 14:06
 * @since v1.0
 */

public class RequestHeaders {

    private RequestHeaders() {
        throw new IllegalStateException("RequestHeaders class");
    }

    /**
     * 版本
     */
    public static final String WIN_VERSION = "Win-Version";

    /**
     * 消息唯一 id
     */
    public static final String WIN_MESSAGE_ID = "Win-Message-Id";

    /**
     * 院内操作员
     */
    public static final String WIN_ADMIN_ID = "Win-Admin-Id";

    /**
     * 时间戳
     */
    public static final String WIN_TIMESTAMP = "Win-Timestamp";

    /**
     * 接口服务代码
     */
    public static final String WIN_BIZ_CODE = "Win-Biz-Code";

}
