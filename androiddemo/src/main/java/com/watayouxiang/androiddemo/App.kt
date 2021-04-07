package com.watayouxiang.androiddemo

import androidx.multidex.MultiDexApplication
import com.blankj.utilcode.util.CrashUtils
import com.blankj.utilcode.util.ProcessUtils
import com.imooc.gradle.router.runtime.Router

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/04/07
 *     desc   :
 * </pre>
 */
class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        if (ProcessUtils.isMainProcess()) {
            initInternal()
        }
    }

    private fun initInternal() {
        CrashUtils.init()
        Router.init()
    }
}