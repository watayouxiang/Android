package com.watayouxiang.mykotlin._06_advancedfunctions

import java.io.File

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/10/12
 *     desc   :
 *
 *     统计字符个数：随便给出一个文件，输出除空白字符外的所有字符的个数
 *
 * </pre>
 */
fun main() {
    // 读取文件，将字符串转成字符数组
    File("build.gradle").readText().toCharArray()
        // 过滤掉空白字符
        .filterNot(Char::isWhitespace)
        // 根据字符进行分组
        .groupBy {
            it
        }
        // map 映射
        .map {
            it.key to it.value.size
        }
        .let {
            println(it)
        }
}