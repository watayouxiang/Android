package com.watayouxiang.mykotlin._03_builtintypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/8
 *     desc   : 基本数据类型
 * </pre>
 */
@ExperimentalUnsignedTypes
fun main() {

    // ====================================================================================
    // 基本数据类型
    // ====================================================================================

    // ctrl + shift + p 查看数据类型

    // String
    val b = "Hello Kotlin"
    // Int
    var a = 2
    // Long
    val c = 12345678910L
    // Double
    val d = 3.0
    // Float
    val f2 = 1f

    // ====================================================================================
    // 数据类型转换
    // ====================================================================================

    val e = 10
    // Int 转 Long
    val f = e.toLong()

    // ====================================================================================
    // 无符号数据类型
    // ====================================================================================

    // UInt
    val g = 10u
    // ULong
    val h = 100000000000000000u
    // UByte
    val i = 1u

    // ====================================================================================
    // 打印
    // ====================================================================================

    println("Range of Int: [${Int.MIN_VALUE}, ${Int.MAX_VALUE}]")
    println("Range of UInt: [${UInt.MIN_VALUE}, ${UInt.MAX_VALUE}]")

    val j = "I❤️China"
    println("Value of String 'j' is: $j") // no need brackets
    println("Length of String 'j' is: ${j.length}") // need brackets
    System.out.printf("Length of String 'j' is: %d\n", j.length)

    val n = """
                <!doctype html>
                <html>
                <head>
                    <meta charset="UTF-8"/>
                    <title>Hello World</title>
                </head>
                <body>
                    <div id="container">
                        <H1>Hello World</H1>
                        <p>This is a demo page.</p>
                    </div>
                </body>
                </html>
                """.trimIndent()
    println(n)

    // ====================================================================================
    // 比较
    // ====================================================================================

    val k = "Today is a sunny day."
    val m = String("Today is a sunny day.".toCharArray())
    println(k === m) // compare references.
    println(k == m) // compare values.

}