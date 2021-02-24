package com.watayouxiang.mykotlin._03_builtintypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/8
 *     desc   : 数组
 * </pre>
 */
fun main() {

    // ====================================================================================
    // 数组
    // ====================================================================================

    //                   Kotlin            Java
    // 整形            IntArray            int[]
    // 整形装箱         Array<Int>          Integer[]
    // 字符           CharArray            char[]
    // 字符装箱         Array<Char>         Character[]
    // 字符串          Array<String>       String[]

    // int[]
    val a = IntArray(5)

    // 数组的长度
    println(a.size)

    // int 数组创建
    val c0 = intArrayOf(1, 2, 3, 4, 5)
    // Int 数组创建
    val c1 = IntArray(5) { 3 * (it + 1) } // y = 3 * (x + 1)
    println(c1.contentToString())

    // String 数组的创建
    val d = arrayOf("Hello", "World")
    d[1] = "Kotlin"
    println("${d[0]}, ${d[1]}")

    // float 数组创建
    val e = floatArrayOf(1f, 3f, 5f, 7f)

    // 数组的遍历
    for (element in e) {
        println(element)
    }
    e.forEach {
        println(it)
    }

    // 判断 "元素" 是否包含在 "数组" 中
    if (1f in e) {
        println("1f exists in variable 'e'")
    }
    if (1.2f !in e) {
        println("1.2f not exists in variable 'e'")
    }
}