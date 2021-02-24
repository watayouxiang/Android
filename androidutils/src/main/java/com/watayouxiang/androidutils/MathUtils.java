package com.watayouxiang.androidutils;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/14
 *     desc   :
 * </pre>
 */
public class MathUtils {
    /**
     * 四舍五入
     * <p>
     * 12.54 --> 13
     */
    public static int round(float value) {
        return Math.round(value);
    }

    /**
     * 四舍五入
     * <p>
     * 12.54 --> 13
     */
    public static long round(double value) {
        return Math.round(value);
    }

    /**
     * 地板数：小于value的最大整数
     * <p>
     * 16.34 --> 16.0
     */
    public static double floor(double value) {
        return Math.floor(value);
    }

    /**
     * 天花板数：大于value的最小整数
     * <p>
     * 16.34 --> 17.0
     */
    public static double ceil(double value) {
        return Math.ceil(value);
    }
}
