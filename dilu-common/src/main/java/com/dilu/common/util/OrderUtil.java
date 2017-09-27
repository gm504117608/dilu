package com.dilu.common.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author guonima
 * @create 2017-09-27 9:50
 */
public class OrderUtil {

    private OrderUtil(){}

    /**
     * 生成订单号
     * <p>
     * 规则 ： 日期（年月日时分秒） +
     * System.currentTimeMillis()中的5位 +
     * System.nanoTime()时间纳秒中5位
     *
     * @return 订单号
     */
    public static String createOrderNo() {
        StringBuilder orderNo = new StringBuilder();
        // jdk1.8的时间类是线程安全的
        orderNo.append(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        orderNo.append((System.currentTimeMillis() / 1000 + "").substring(5));
        orderNo.append((System.nanoTime() + "").substring(8).substring(1, 5));

        return orderNo.toString();
    }
}
