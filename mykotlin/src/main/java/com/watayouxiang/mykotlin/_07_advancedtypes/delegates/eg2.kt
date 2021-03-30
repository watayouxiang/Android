package com.watayouxiang.mykotlin._07_advancedtypes.delegates

import kotlin.reflect.KProperty

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *    属性代理 示例：
 *
 *
 * </pre>
 */

class Foo {
    val x: Int by X(::x)
}

class X(val property: KProperty<*>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return 2
    }
}

fun main() {
    println(Foo().x)
}
