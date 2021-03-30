package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     单例
 *
 *
 * </pre>
 */

// object标记的类，是单例类（饿汉式单例）
object Singleton {
    @JvmField
    var x: Int = 2

    @JvmStatic
    fun y() {
    }
}

// 普通类实现静态成员、静态方法
class Foo {
    companion object {
        @JvmField
        var x: Int = 2

        @JvmStatic
        fun y() {
        }
    }
}

fun main() {
    Singleton.x
    Singleton.y()

    Foo.x
    Foo.y()
}