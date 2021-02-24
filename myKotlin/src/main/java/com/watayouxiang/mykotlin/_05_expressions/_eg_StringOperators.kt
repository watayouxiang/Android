package com.watayouxiang.mykotlin._05_expressions

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/16
 *     desc   : 为 String 实现四则运算
 * </pre>
 */
fun main() {
    val value = "HelloWorld World"

    println(value)
    println(value - "World")
    println(value * 2)
    println("*" * 20)

    // 没有 3，所以返回 0
    println(value / 3)
    // 存在 4 个 l
    println(value / "l")
    // 存在 2 个 ld
    println(value / "ld")
}

// 减法
operator fun String.minus(right: Any?) = this.replaceFirst(right.toString(), "")

// 乘法
operator fun String.times(right: Int): String {
    return (1..right).joinToString("") {
        this
    }
}

// 除法
operator fun String.div(right: Any?): Int {
    val right = right.toString()

    // 高级函数 windowed(窗口)
    //
    // CharSequence.windowed(
    //          size: Int, // 窗口的大小
    //          step: Int = 1,// 步长
    //          partialWindows: Boolean = false,
    //          // 如果 "lambda表达式" 返回的值就是 R
    //          // 那么 windowed 返回的值则是 List<R>
    //          transform: (CharSequence) -> R
    //      )
    //      : List<R>
    //
    // 在 CharSequence 上滑动
    //
    // 窗的大小是
    return this.windowed(right.length, 1, false,
        transform = {
            it == right
        }) // [false, false, false, false ... false, true, ..., true]
        .count {
            // 如果 it 为true，则计数+1
            it
        }
}