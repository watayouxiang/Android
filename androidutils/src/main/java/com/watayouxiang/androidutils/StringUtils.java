package com.watayouxiang.androidutils;

import androidx.annotation.NonNull;

import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/11
 *     desc   : String 工具
 * </pre>
 */
public class StringUtils {
    /**
     * 反转
     */
    @NonNull
    public static String reverse(@NonNull String str) {
        char[] chars = str.toCharArray();
        for (int start = 0, end = chars.length - 1; start < end; start++, end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
        return new String(chars);
    }

    /**
     * 去除两端的空格
     */
    @NonNull
    public static String trim(@NonNull String str) {
        int start = 0, end = str.length() - 1;
        while (start < end && str.charAt(start) == ' ')
            start++;
        while (start < end && str.charAt(end) == ' ')
            end--;
        return str.substring(start, end + 1);
    }

    /**
     * 获取 sub 在 str 中出现的次数
     */
    public static int getSubCount(@NonNull String str, @NonNull String sub) {
        int count = 0;
        int fromIndex = 0;
        // string.indexOf(String sub, int fromIndex)
        // 返回指定子串的第一次出现的字符串中的索引
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            fromIndex = fromIndex + sub.length();
            count++;
        }
        return count;
    }

    /**
     * 获取两个字符串中最大相同子串
     * <p>
     * 思路：
     * 1、将 "短字符串" 按照长度递减的方式获取到。
     * 2、将获取到的字符串去 "长字符串" 中判断是否包含。
     */
    @NonNull
    private static String getMaxSubString(@NonNull String s1, @NonNull String s2) {
        String max = s1.length() > s2.length() ? s1 : s2;
        String min = max.equals(s1) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int start = 0, end = min.length() - i; end != min.length() + 1; start++, end++) {
                String temp = min.substring(start, end);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return "";
    }

    /**
     * 统计一个字符串中字母出现的次数。
     * 字母区分大小写。
     *
     * @return Map：key 是字母，value 是字母出现的次数
     */
    @NonNull
    public static Map<Character, Integer> countCharNum(@NonNull String str) {
        char[] chs = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char ch : chs) {
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) continue;
            // 统计字母出现次数
            Integer value = map.get(ch);
            if (value == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, ++value);
            }
        }
        return map;
    }
}
