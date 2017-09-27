package com.dilu.common;

import java.math.BigDecimal;

/**
 * @author guonima
 * @create 2017-09-27 10:29
 */
public class Constant {

    // 消费金额超过该值之后免快递费
    public static final BigDecimal EXPRESS_COST_LIMIT = new BigDecimal(99);

    // 快递费
    public static final BigDecimal EXPRESS_COST = new BigDecimal(10);
}
