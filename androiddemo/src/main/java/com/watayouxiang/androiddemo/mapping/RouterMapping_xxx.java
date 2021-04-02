package com.watayouxiang.androiddemo.mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/04/02
 *     desc   :
 * </pre>
 */
public class RouterMapping_xxx {

    public static Map<String, String> get() {
        Map<String, String> mapping = new HashMap<>();

        mapping.put("router://xxxA", "com.xxx.xxx.AActivity");
        mapping.put("router://xxxB", "com.xxx.xxx.BActivity");
        mapping.put("router://xxxC", "com.xxx.xxx.CActivity");

        return mapping;
    }

}
