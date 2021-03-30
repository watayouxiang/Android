package com.watayouxiang.mykotlin._05_expressions

const val b = 3

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/16
 *     desc   : 常量和变量
 *
 *     常量：程序使用之前预先设定，并在整个运行过程中没有变化。
 *     变量：有些数据在程序运行中可以变化，这称为变量。
 *     字面量：固定值
 *
 *     // b 是常量，3 是字面量
 *     const val b = 3
 *
 *     // a 是变量，2 是字面量
 *     var a = 2
 *
 *     // c 是常量，1 是字面量
 *     val c = 1
 *
 * </pre>
 */
class KotlinVars {
    companion object {
        const val b = 3
    }
}

object KotlinVars2 {
    // 常量
    // 只能定义在全局范围
    // 只能修饰基本类型
    // 必须立即使用字面量初始化
    // b 是常量，3 是字面量
    const val b = 3
}

class X {
    // 只读变量
    val b: Int
        get() {
            return (Math.random() * 100).toInt()
        }
}

fun main() {
    // 变量
    // a 是变量，2 是字面量
    var a = 2
    a = 3

    // 只读变量（已经使用字面量初始化）
    // b 是只读变量，3 是字面量
    val b = 3

    // 只读变量（未初始化）
    val c: Int

    if (a == 3) {
        c = 4
    } else {
        c = 5
    }
}