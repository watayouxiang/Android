package com.watayouxiang.mykotlin._03_builtintypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/8
 *     desc   : 函数
 * </pre>
 */
fun main(vararg args: String) {

    println(args.contentToString())

    // ====================================================================================
    // 方法变量
    // ====================================================================================

    // 方法可以认为是函数的一种特殊类型
    // 从形式上，有 receiver 的函数即为方法

    // 以下等价关系
    // (Foo, String, Long) -> Any
    // Foo.(String, Long) -> Any
    // Function3<Foo, String, Long, Any>

    val x: (Foo, String, Long) -> Any = Foo::bar
    val y: Function3<Foo, String, Long, Any> = Foo::bar
    val z: Function3<Foo, String, Long, Any> = x

    yy(x)

    // ====================================================================================
    // 函数变量
    // ====================================================================================

    // 无参数无返回
    val f: () -> Unit = ::foo
    // 有参数(Int)，有返回值(String)
    val g: (Int) -> String = ::foo
    // 有参数(Foo, String, Long)，有返回值(Any)
    val h: (Foo, String, Long) -> Any = Foo::bar

    // 可变参数函数
    multiParameters(1, 2, 3, 4)

    // 参数有默认值的函数
    defaultParameter(y = "Hello")

    // 多返回值函数
    val (a, b, c) = multiReturnValues()
    val r = a + b
    val r1 = a + c

}

// ====================================================================================
// 方法
// ====================================================================================

class Foo {
    // receiver 是 Foo
    fun bar(p0: String, p1: Long): Any {
        TODO()
    }

    fun bar(p0: String): Any {
        TODO()
    }
}

// ====================================================================================
// 函数
// ====================================================================================

// 无参数：无返回值
fun foo() {}

// 单参数：单返回值
fun foo(p0: Int): String {
    TODO()
}

// 多参数（不同类型参数）：无返回值
fun defaultParameter(x: Int = 5, y: String, z: Long = 0L) {
    TODO()
}

// 多参数（同类型参数）：无返回值
fun multiParameters(vararg ints: Int) {
    println(ints.contentToString())
}

// 无参数：多返回值（Triple实现）
fun multiReturnValues(): Triple<Int, Long, Double> {
    return Triple(1, 3L, 4.0)
}

// 参数是函数：无返回值
fun yy(p: (Foo, String, Long) -> Any) {
    //p(Foo(), "Hello", 3L)
}

