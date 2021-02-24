package com.watayouxiang.androidutils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/06/12
 *     desc   : Array 工具类
 *
 *     八种排序算法原理及Java实现: https://juejin.im/post/5b95da8a5188255c775d8124
 *     时间复杂度、空间复杂度: https://zhuanlan.zhihu.com/p/50479555
 *
 * </pre>
 */
public class ArrayUtils {
    /**
     * 控制台打印
     */
    public static <T> void println(@Nullable T[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        } else if (arr.length == 0) {
            System.out.println("empty");
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (T t : arr) {
            builder.append(t.toString()).append("\n");
        }
        System.out.println(builder.toString());
    }

    /**
     * 复制：
     * 将 srcArr 数组的元素，复制到 destArr 数组中
     *
     * @param srcArr  源数组
     * @param destArr 目标数组
     */
    public static <T> void copy(@NonNull T[] srcArr, @NonNull T[] destArr) {
        // System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        // 将指定源数组中的数组从指定位置复制到目标数组的指定位置。
        System.arraycopy(srcArr, 0, destArr, 0, srcArr.length);
    }

    /**
     * 转字符串
     *
     * @param split 两元素之间的分隔符
     */
    @NonNull
    public static <T> String toString(@NonNull T[] arr, @NonNull String split) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = arr.length; i < len; i++) {
            builder.append(arr[i]);
            if (i < len - 1) {
                builder.append(split);
            }
        }
        return builder.toString();
    }

    /**
     * 反转
     */
    public static void reverse(@NonNull int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            swap(arr, start, end);
        }
    }

    /**
     * 折半查找
     *
     * @param arr 有序数组
     * @param key 关键字
     * @return 关键字位置，无则返回-1。
     */
    public static int halfSearch(@NonNull int[] arr, int key) {
        int low = 0, high = arr.length - 1, middle;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (key < arr[middle]) {
                // 关键字可能在左侧
                high = middle - 1;
            } else if (key > arr[middle]) {
                // 关键字可能在右侧
                low = middle + 1;
            } else {
                // 找到关键字
                return middle;
            }
        }
        return -1;
    }

    /**
     * 选择排序
     * <p>
     * 实现步骤:
     * 1、第一个分别与 "第二个、第三个，...，第length个" 比较大小，第一个大则交换位置。（比较 length-1 次，第一个为最小值）
     * 2、第一个固定，从下一个开始，重复第一步骤。（第一步需要执行 length-1 次）
     */
    public static void selectSort(@NonNull int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {// 循环 arr.length-1 次
            for (int j = 1 + i; j < arr.length; j++) {// 比较 arr.length-1-i 次
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 冒泡排序（优化版）
     * <p>
     * 实现步骤:
     * 1、隔壁两两比较，如果前比后大，则交换位置。（比较次数 length-1 次，最大值在最后一位）
     * 2、最后一位固定，重复第一步流程。（第一步需要进行 length-1 次）
     * <p>
     * 算法特点：
     * - 当输入的数量依线性成长时，所花的时间将会以指数成长。
     * - 在数据量足够小时，该算法性能是最优的。
     * - 冒泡排序是蛮力法的一种，蛮力法（brute force method，也称为穷举法或枚举法）
     */
    public static void bubbleSort(@NonNull int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {// 循环 arr.length-1 次
            boolean isSwap = false;
            for (int j = 0; j < i; j++) {// 比较 i 次
                if (arr[j] > arr[j + 1]) {// 从小到大排序
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
            // 如果遍历下来不需要交互顺序的话，
            // 说明该数组已经是有序的了，则跳过剩下的循环。
            if (!isSwap) {
                break;
            }
        }
    }

    /**
     * 数据交换（性能最优）
     */
    public static void swap(@NonNull int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
