package com.watayouxiang.mykotlin._05_expressions

fun main() {

    // ====================================================================================
    // 普通函数
    // ====================================================================================

    // 普通函数
    // 参数为空，返回值是 Unit
    // 之所以返回值是 Unit 是因为最后一行语句的返回值是 Unit
    val func: () -> Unit = fun() {
        println("Hello")
    }

    // 普通函数
    // 参数为 Int，返回值是 Unit
    // 之所以返回值是 Unit 是因为最后一行语句的返回值是 Unit
    val func2: (it: Int) -> Unit = fun(it: Int) {
        println(it)
        println("Hello")
    }

    // ====================================================================================
    // 匿名函数
    // ====================================================================================

    // 匿名函数1
    // 参数为空，返回值 Unit
    // 之所以返回值是 Unit 是因为最后一行语句的返回值是 Unit
    val noNameFunc1: () -> Unit = {
        println("Hello")
    }

    // 等价于 "匿名函数1"
    val equalNoNameFunc1 = {
        println("Hello")
    }

    // 匿名函数2
    // 参数 Int，返回值是 Unit
    // 之所以返回值是 Unit 是因为最后一行语句的返回值是 Unit
    val noNameFunc2: (p: Int) -> Unit = {
        println(it)
        println("Hello")
    }

    // 等价于 "匿名函数2"
    val equalNoNameFunc2: Function1<Int, Unit> = {
        println(it)
        println("Hello")
    }

    // 匿名函数3
    // 参数 Int，返回值是 String
    // 之所以返回值是 String 是因为最后一行语句是 String
    val noNameFunc3: (p: Int) -> String = {
        println(it)
        println("Hello")
        "Hello"
    }

    // 等价于 "匿名函数3"
    val equalNoNameFunc3: Function1<Int, String> = {
        println(it)
        println("Hello")
        "Hello"
    }

    // ====================================================================================
    // lambda 表达式
    // ====================================================================================

    // lambda 表达式
    // 参数是 空 , 返回值是 Unit
    // 返回值是 Unit 是因为最后一行语句的返回值是 Unit
    //
    // 本质上就是 "匿名函数"
    // 由 "自动类型推导" 得出参数和返回值
    val lambda1 = {
        println("Hello")
    }

    // lambda 表达式
    // 参数是 Int , 返回值是 Unit
    // 返回值是 Unit 是因为最后一行语句的返回值是 Unit
    //
    // 本质上就是 "匿名函数"
    // 由 "自动类型推导" 得出参数和返回值
    val lambda2 = { it: Int ->
        println(it)
        println("Hello")
    }

    // lambda 表达式
    // 参数是 Int , 返回值是 String
    // 返回值是 String 是因为最后一行语句是 String
    //
    // 本质上就是 "匿名函数"
    // 由 "自动类型推导" 得出参数和返回值
    val lambda3 = { it: Int ->
        println(it)
        println("Hello")
        "Hello"
    }

    println(lambda3(1))

    // ====================================================================================
    // 系统api，默认的 lambda 表达式
    // ====================================================================================

    IntArray(5) {
        it + 1
    }
}