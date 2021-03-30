package com.watayouxiang.mykotlin._05_expressions

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/16
 *     desc   : 分支表达式
 *
 *     if ... else
 *     when ...
 *     try ... catch
 * </pre>
 */
fun main() {

    // ====================================================================================
    // if ... else
    // ====================================================================================

    var a = 2
    var c: Int

    if (a == 3) {
        c = 4
    } else {
        c = 5
    }

    c = if (a == 3) 4 else 5

    // ====================================================================================
    // when ...
    // ====================================================================================

    c = when (a) {
        0 -> 5
        1 -> 100
        else -> 20
    }

    var x: Any = Any()
    c = when {
        x is String -> x.length
        x == 1 -> 100
        else -> 20
    }

    c = when (val input = readLine()) {
        null -> 0
        else -> input.length
    }

    // ====================================================================================
    // try ... catch
    // ====================================================================================

    val b = 0

    try {
        c = a / b
    } catch (e: Exception) {
        e.printStackTrace()
        c = 0
    }

    c = try {
        a / b
    } catch (e: ArithmeticException) {
        2
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }

    c = try {
        a / b
    } catch (e: ArithmeticException) {
        2
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }


}