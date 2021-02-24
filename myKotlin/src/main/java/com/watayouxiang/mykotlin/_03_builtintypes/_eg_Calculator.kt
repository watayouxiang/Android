package com.watayouxiang.mykotlin._03_builtintypes


/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/8
 *     desc   : 小练习
 * </pre>
 */
fun main(vararg args: String) {
    if (args.size < 3) {
        return showHelp()
    }

    val operators = mapOf(
            "+" to ::plus,
            "-" to ::minus,
            "*" to ::times,
            "/" to ::div
    )

    val op = args[1]
    // 避免角标越界异常
    val opFunc = operators[op] ?: return showHelp()

    try {
        println("Input: ${args.joinToString(" ")}")
        println("Output: ${opFunc(args[0].toInt(), args[2].toInt())}")
    } catch (e: Exception) {
        println("Invalid Arguments.")

        showHelp()
    }
}

fun plus(arg0: Int, arg1: Int): Int {
    return arg0 + arg1
}

fun minus(arg0: Int, arg1: Int): Int {
    return arg0 - arg1
}

fun times(arg0: Int, arg1: Int): Int {
    return arg0 * arg1
}

fun div(arg0: Int, arg1: Int): Int {
    return arg0 / arg1
}

fun showHelp() {
    println("""
        Simple Calculator:
            Input: 3 * 4
            Output: 12
    """.trimIndent())
}