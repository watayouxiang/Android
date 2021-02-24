package com.watayouxiang.mykotlin._05_expressions

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/16
 *     desc   : 运算符重载和中缀表达式
 *
 *     运算符重载，官方文档:
 *     https://kotlinlang.org/docs/reference/operator-overloading.html
 * </pre>
 */
fun main() {

    // ====================================================================================
    // 运算符重载
    // ====================================================================================

    // 相等判断
    "Hello" == "World"
    "Hello".equals("World")


    // 相加判断
    2 + 3
    2.plus(3)


    // list 的 contains 方法
    val list = listOf(1, 2, 3, 4)
    2 in list
    list.contains(2)


    // map 的 get 方法
    val map = mutableMapOf(
        "Hello" to 2,
        "World" to 3
    )
    val value = map["Hello"]
    val value2 = map.get("Hello")

    // map 的 set 方法
    map["World"] = 4
    map.set("World", 4)


    // 比较方法
    2 > 3
    2.compareTo(3) > 0


    // 函数调用
    val func = fun() {
        println("Hello")
    }
    func.invoke()
    func()

    // ====================================================================================
    // 中缀表达式
    // ====================================================================================

    2 to 3
    2.to(3)

    println("HelloWorld" rotate 5)

    val book = Book()
    val desk = Desk()
    book on desk

}

/**
 * 中缀表达式：
 * 给 String 拓展方法 rotate
 *
 * infix 告诉编译器
 * "HelloWorld".rotate(5)
 * 可以简化为
 * "HelloWorld" rotate 5
 */
infix fun String.rotate(count: Int): String {
    val index = count % length
    return this.substring(index) + this.substring(0, index)
}

class Book
class Desk

/**
 * 中缀表达式：
 * 给 Book 拓展方法 on
 *
 * infix 告诉编译器
 * book.on(desk)
 * 可以简化为
 * book on desk
 */
infix fun Book.on(desk: Desk) {

}
