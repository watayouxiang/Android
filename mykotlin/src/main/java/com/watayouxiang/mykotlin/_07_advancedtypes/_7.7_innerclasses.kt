package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     内部类
 *
 * </pre>
 */

class Outer {
    // 非静态内部类
    inner class Inner

    // 静态内部类
    class StaticInner
}


fun main() {
    val inner = Outer().Inner()
    val staticInner = Outer.StaticInner()

    // 匿名内部类
    // 匿名内部类可以实现多个接口
    object : Runnable, Cloneable {
        override fun run() {

        }
    }

    // 本地类
    class LocalClass : Cloneable, Runnable {
        override fun run() {

        }
    }

    // 本地函数
    fun localFunction() {
        println("hello")
    }
}