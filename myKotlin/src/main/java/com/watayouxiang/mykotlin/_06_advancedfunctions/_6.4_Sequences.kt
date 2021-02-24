package com.watayouxiang.mykotlin._06_advancedfunctions

import java.lang.StringBuilder

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/9/24
 *     desc   : 集合变换和序列
 * </pre>
 */
fun main() {
    // 集合映射
    testFilter()
    testMap()
    testFlatMap()

    // 懒序列的机制
    testSequence01()
    testSequence02()

    // 集合的聚合
    testFold()
    testZip()
}

fun testZip() {
    val list = listOf(1, 2, 3)
    /**
     * ------------------------------------------
     * zip变换（拉链）
     *
     * [1, 2, 3]
     * [x, y]
     *
     * 第一步
     * 1 --> [1x, 1y]
     * 2 --> [2x, 2y]
     * 3 --> [3x, 3y]
     *
     * 第二步
     * [1x, 1y, 2x, 2y, 3x, 3y]
     * ------------------------------------------
     */
}

fun testFold() {
    /**
     * ------------------------------------------
     * 给定初始化值，将元素按规则聚合，结果与给定初始化值类型一致
     *
     * [1, 2, 3] 给定初始化值为 ""
     *
     * 1 --> "1"           (1 + "" = "1")
     * 2 --> "12"          ("1" + 2 = "12")
     * 3 --> "123"         ("12" + 3 = "123")
     * ------------------------------------------
     */
    val list = listOf(1, 2, 3)
    val sb = list.fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
    println(sb)
}

fun testSequence02() {
    val list = listOf(1, 2, 3, 4)

    /**
     * ------------------------------------------
     * 懒汉式
     *
     * filter: 1
     * filter: 2
     * filter: 3
     * filter: 4
     * map: 2
     * map: 4
     * forEach: 5
     * forEach: 9
     * ------------------------------------------
     */
    list
        .filter {
            println("filter: $it")
            it % 2 == 0
        }
        .map {
            println("map: $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach: $it")
        }
}

fun testSequence01() {
    val list = listOf(1, 2, 3, 4)

    /**
     * ------------------------------------------
     * 饿汉式
     *
     * filter: 1
     * filter: 2
     * map: 2
     * forEach: 5
     * filter: 3
     * filter: 4
     * map: 4
     * forEach: 9
     * ------------------------------------------
     */
    list.asSequence()
        .filter {
            println("filter: $it")
            it % 2 == 0
        }
        .map {
            println("map: $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach: $it")
        }
}

fun testFlatMap() {
    val list = listOf(1, 2, 3)

    /**
     * ------------------------------------------
     * 第一步:
     * 1 --> 0
     * 2 --> 0 1
     * 3 --> 0 1 2
     *
     * 第二步：
     * 0 0 1 0 1 2
     * ------------------------------------------
     */
    list.asSequence()
        .flatMap {
            (0 until it).asSequence()
        }
        .joinToString().let(::println)
}

fun testMap() {
    val list = listOf(1, 2, 3, 4)

    /**
     * ------------------------------------------
     * 1 --> 1
     * 2 --> 5
     * 3 --> 7
     * 4 --> 9
     * ------------------------------------------
     */
    list.asSequence()
        .map {
            it * 2 + 1
        }
        .joinToString().let(::println)
}

fun testFilter() {
    val list = listOf(1, 2, 3, 4)

    /**
     * ------------------------------------------
     * 1 -->
     * 2 --> 2
     * 3 -->
     * 4 --> 4
     * ------------------------------------------
     */
    list.asSequence()
        .filter {
            it % 2 == 0
        }
        .joinToString().let(::println)
}
