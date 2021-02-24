package com.watayouxiang.mykotlin._07_advancedtypes

import kotlin.properties.Delegates

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     代理：       "我" 代替 "你" 处理 "它"
 *     接口代理：    "对象X" 代替 "类A" 实现 "接口B" 的方法
 *     属性代理：    "对象X" 代替 "属性A" 实现 "getter/setter方法"
 *
 *
 * </pre>
 */

// 接口代理
interface Api {
    fun a()
    fun b()
    fun c()
}

class ApiWrapper(val api: Api) : Api by api {
    override fun c() {
        println("c is called.")
        api.c()
    }
}

// 属性代理
class Person5(val name: String) {
    // "接口lazy的实例" 代理了 "对象Person的实例属性firstName" 实现了 "getter"
    val firstName by lazy { name.split("")[0] }

    // "ObservableProperty的实例" 代理了 "属性state" 实现了 "getter/setter"
    var state: Int by Delegates.observable(0) { property, oldValue, newValue ->
        println("State changed from $oldValue -> $newValue")
    }
}

fun main() {
    val person = Person5("wata")
    person.state = 3
    person.state = 4
}