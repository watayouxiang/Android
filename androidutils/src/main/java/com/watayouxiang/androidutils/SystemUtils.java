package com.watayouxiang.androidutils;

import androidx.annotation.NonNull;

import java.util.Map;
import java.util.Properties;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/13
 *     desc   :
 * </pre>
 */
public class SystemUtils {
    /**
     * 打印 "系统属性信息"
     */
    public void printProperties() {
        System.out.println(getProperties("="));
    }

    /**
     * 获取 "系统属性信息"
     *
     * @param split 键值对分隔符
     */
    public static String getProperties(@NonNull String split) {
        StringBuilder builder = new StringBuilder();
        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            builder.append(entry.getKey())
                    .append(split)
                    .append(entry.getValue())
                    .append("\n");
        }
        return builder.toString();
    }

    /**
     * 获取 "用户目录"
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }
}
