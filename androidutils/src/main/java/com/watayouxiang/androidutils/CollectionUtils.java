package com.watayouxiang.androidutils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/8/11
 *     desc   : List、Set 工具类
 * </pre>
 */
public class CollectionUtils {
    /**
     * c1 是否包含 c2
     */
    public static boolean containsAll(@NonNull Collection<?> c1, @NonNull Collection<?> c2) {
        Iterator<?> it = c2.iterator();
        Object obj;
        do {
            if (!it.hasNext()) {
                return true;
            }
            obj = it.next();
        } while (c1.contains(obj));
        return false;
    }

    /**
     * 从 c1 中删除所有不包含在 c2 中的元素
     * <p>
     * 等同于：取 c1 和 c2 的交集
     *
     * @return c1是否被修改
     */
    public static boolean retainAll(@NonNull Collection<?> c1, @NonNull Collection<?> c2) {
        boolean modified = false;
        Iterator<?> it = c1.iterator();
        while (it.hasNext()) {
            if (!c2.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * 空判断
     */
    public static boolean isEmpty(@Nullable Collection<?> c) {
        return c == null || c.size() == 0;
    }

    /**
     * 取两个集合中的 "相同元素集合"
     */
    public static <T> Collection<T> getCommon(@NonNull Collection<T> c1, @NonNull Collection<T> c2) {
        return getCollection(c1, c2, true);
    }

    /**
     * 取两个集合中的 "不同元素集合"
     */
    public static <T> Collection<T> getDiffer(@NonNull Collection<T> c1, @NonNull Collection<T> c2) {
        return getCollection(c1, c2, false);
    }

    private static <T> Collection<T> getCollection(@NonNull Collection<T> c1, @NonNull Collection<T> c2, boolean isCommon) {
        // 去重复，value代表是否重复
        HashMap<T, Boolean> map = new HashMap<>(c2.size());
        for (T t : c2) {
            map.put(t, false);
        }
        // 分别 "相同/不同" 元素
        for (T t : c1) {
            if (map.get(t) != null) {
                map.put(t, true);
            } else {
                map.put(t, false);
            }
        }
        // 取出 "相同/不同" 元素
        List<T> list = new ArrayList<>();
        for (Map.Entry<T, Boolean> entry : map.entrySet()) {
            if (isCommon) {
                if (entry.getValue()) list.add(entry.getKey());
            } else {
                if (!entry.getValue()) list.add(entry.getKey());
            }
        }
        return list;
    }

    /**
     * 控制台打印
     */
    public static <T> void println(@Nullable Collection<T> collection) {
        if (collection == null) {
            System.out.println("null");
            return;
        } else if (collection.size() == 0) {
            System.out.println("empty");
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (T t : collection) {
            builder.append(t.toString()).append("\n");
        }
        System.out.println(builder.toString());
    }

}
