package com.watayouxiang.androidutils;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/11
 *     desc   :
 * </pre>
 */
public class MapUtils {
    /**
     * 排序
     * <p>
     * 1、可以按 value 排序
     * 2、可以对 "无序HashMap" 进行排序
     */
    public static <K, V> HashMap<K, V> sort(@NonNull HashMap<K, V> map, @NonNull Comparator<Map.Entry<K, V>> comparator) {
        // map 转 list
        Set<Map.Entry<K, V>> set = map.entrySet();
        ArrayList<Map.Entry<K, V>> list = new ArrayList<>(set);
        // 排序
        Collections.sort(list, comparator);
        // 创建一个有序的 HashMap 子类集合 LinkedHashMap
        // 因为是 "链表数据结构"，所以是按顺序放置元素的
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
