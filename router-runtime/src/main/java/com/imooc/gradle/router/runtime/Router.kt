package com.imooc.gradle.router.runtime

import android.util.Log

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/04/07
 *     desc   :
 * </pre>
 */
object Router {

    private const val TAG = "RouterTAG"

    // 编译期间生成的总映射表
    private const val GENERATED_MAPPING = "com.watayouxiang.androiddemo.mapping.RouterMapping"

    // 存储所有映射表信息
    private val mapping: HashMap<String, String> = HashMap()

    fun init() {
        try {
            val clazz = Class.forName(GENERATED_MAPPING)
            val method = clazz.getMethod("get")
            val allMapping = method.invoke(null) as Map<String, String>

            if (allMapping?.size > 0) {
                Log.i(TAG, "init: get all mapping:")
                allMapping.onEach {
                    Log.i(TAG, "        ${it.key} -> ${it.value}")
                }
                mapping.putAll(allMapping)
            }
        } catch (e: Throwable) {
            Log.i(TAG, "init: error while init router: $e")
        }
    }

}