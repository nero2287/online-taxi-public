package com.taxi.common.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    /**
     * 除法 保留两位小数
     * @param divisor 除数
     * @param dividend 被除数
     * @return
     */
    public static double divide(double divisor,double dividend){
        BigDecimal v1 = BigDecimal.valueOf(divisor);
        BigDecimal v2 = BigDecimal.valueOf(dividend);
        return v1.divide(v2,BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 乘法 保留两位小数
     * @param multiplier 乘数
     * @param multiplicand 被乘数
     * @return
     */
    public static double multiplication(double multiplier,double multiplicand){
        BigDecimal v1 = BigDecimal.valueOf(multiplier);
        BigDecimal v2 = BigDecimal.valueOf(multiplicand);
        return v1.multiply(v2).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 加法
     * @param n1
     * @param n2
     * @return
     */
    public static double add(double n1,double n2){
        BigDecimal v1 = BigDecimal.valueOf(n1);
        BigDecimal v2 = BigDecimal.valueOf(n2);
        return v1.add(v2).doubleValue();
    }
}
