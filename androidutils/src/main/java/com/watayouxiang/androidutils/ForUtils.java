package com.watayouxiang.androidutils;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/14
 *     desc   :
 * </pre>
 */
public class ForUtils {
    /**
     * 循环
     *
     * @param count 循环总次数
     * @param task  执行代码
     */
    public static void loop(@IntRange(from = 1) int count, @NonNull Task task) {
        for (int i = 0; i < count; i++) {
            task.run(i + 1);
        }
    }

    public interface Task {
        /**
         * @param num 执行到第几次
         */
        void run(int num);
    }
}
