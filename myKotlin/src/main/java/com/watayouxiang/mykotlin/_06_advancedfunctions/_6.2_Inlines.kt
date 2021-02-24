package com.watayouxiang.mykotlin._06_advancedfunctions

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/07/24
 *     desc   :
 *     内联函数
 *          定义：关键字inline修饰的函数，就是内联函数
 *
 *     IDE 查看字节码：
 *          双击shift，输入 show kotlin bytecode，点击 Decompile
 *
 * </pre>
 */
fun main() {

    // ====================================================================================
    // 1、local return
    // ====================================================================================

    // region local return
    val ints = intArrayOf(1, 2, 3, 4)
    ints.forEach {
        if (it == 3) return@forEach// 跳出一次循环
        println("Hello $it")
    }
    // endregion

    // ====================================================================================
    // 2、non-local return
    // ====================================================================================

    // region non-local return
    println("before nonLocalReturn")
    nonLocalReturn {
        // 从外部返回
        // 也就是从main函数返回
        return
    }
    println("after nonLocalReturn")
    // endregion

    // ====================================================================================
    // 3、禁止 non-local return
    // ====================================================================================

    Runnable {
        println("xxx")
    }

}

// ====================================================================================
// 4、内联属性
// 没有 backing-field 的属性的 getter/setter 可以被内联
// ====================================================================================

var pocket: Double = 0.0
var money: Double
    inline get() = pocket
    inline set(value) {
        pocket = value
    }

// ====================================================================================
// 5、内联函数的限制
// public/protected 的内联方法只能访问对应类的public成员
// 内联函数的内联函数参数不能被存储（赋值给变量）
// 内联函数的内联函数参数只能传递给其他内联函数参数
// ====================================================================================

// 关键字inline修饰的函数，就是内联函数
inline fun nonLocalReturn(block: () -> Unit) {
    block()
}

// crossinline: 禁止 non-local return
// noinline：禁止函数参数被内联
inline fun Runnable(crossinline block: () -> Unit): Runnable {
    return object : Runnable {
        override fun run() {
            // 错误写法
            // 有可能存在不合法的 non-local return，
            // 因为 block 调用处与定义处不在同一个上下文
            block()
        }
    }
}

