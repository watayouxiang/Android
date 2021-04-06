package com.imooc.gradle.sample.biz.reading

import android.app.Activity
import com.imooc.router.annotations.Destination

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/04/06
 *     desc   :
 * </pre>
 */

// 验证是否生成了：查看 build/generated/source/kapt/debug/xxx 是否有生成文件
@Destination(url = "router://reading", description = "阅读页")
class ReadingActivity : Activity() {

}