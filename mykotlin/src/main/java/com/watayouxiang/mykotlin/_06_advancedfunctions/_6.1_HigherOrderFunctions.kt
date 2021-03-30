package com.watayouxiang.mykotlin._06_advancedfunctions

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/07/24
 *     desc   : 高阶函数
 *              定义：参数类型为函数，或者返回值类型为函数的函数为高阶函数
 * </pre>
 */
fun main() {
    cost {
        var fibonacciNext = fibonacci()
        for (i in 0..10) {
            println(fibonacciNext())
        }
    }

    // region + forEach 高阶函数
    val intArray = IntArray(5) { it + 1 }

    intArray.forEach {
        println(it)
    }

    intArray.forEach(::println)

    intArray.forEach { println("Hello $it") }
    // endregion

}

// region + 高阶函数示例
/**
 * 参数是函数的 "高阶函数"
 */
fun needsFunction(block: () -> Unit) {
    block()
}

/**
 * 返回值是函数的 "高阶函数"
 */
fun returnFunction(): () -> Long {
    return { System.currentTimeMillis() }
}
// endregion

/**
 * 计算代码的运行时间
 *
 * 参数是函数
 */
fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("${System.currentTimeMillis() - start}ms")
}

/**
 * 斐波那契数列：这个数列从第3项开始，每一项都等于前两项之和。
 *
 * 返回值是函数
 */
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}