package com.example.steel.util;

/**
 * Desc: 公共常量类
 */
public class CommonConstants {

    private CommonConstants(){
        throw new IllegalStateException("Utility class allow not to create object !");
    }

    //业务重试次数
    public static final int RETRY_TIME = 3;

    public static final int SUCCESS = 1;
    public static final int FAILE = 0;
    public static final int HISTORY_15_MIN = 1;
    public static final int HISTORY_24_HOUR = 2;

    //返回码
    public static final int SUCCESS_CODE = 200;
    public static final int PARAM_ERROR_CODE = 250;
    public static final int FAILE_CODE = 500;

    //批量增改的批量数
    public static final int BATCH_SIZE_UPSERT = 500;
    //批量删除的批量数(包括逻辑删除)
    public static final int BATCH_SIZE_DELETE = 1000;

    //日期格式化
    public static final String TIME_TYPE_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_TYPE_MILLSECOND = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String TIME_TYPE_TOGETHER = "yyyyMMddHHmmss";

}
