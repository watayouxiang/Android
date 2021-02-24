package com.watayouxiang.androidutils;

import androidx.annotation.Nullable;

import java.io.Closeable;
import java.io.IOException;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/08/13
 *     desc   :
 * </pre>
 */
public class IOUtils {
    /**
     * 关闭资源
     */
    public static void close(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
    }
}
