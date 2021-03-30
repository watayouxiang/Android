package com.watayouxiang.mykotlin._03_builtintypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/8
 *     desc   : 区间
 * </pre>
 */
@ExperimentalUnsignedTypes
fun main() {

    // ====================================================================================
    // 闭区间
    // ====================================================================================

    // 整形 闭区间
    val intRange = 1..10 // [1, 10]
    val charRange = 'a'..'z'
    val longRange = 1L..100L

    // 浮点型 闭区间
    val floatRange = 1f..2f // [1, 2]
    val doubleRange = 1.0..2.0

    println("整形 闭区间: ${intRange.joinToString()}")
    println("浮点型 闭区间: $floatRange")

    // 无符号整形 闭区间
    val uintRange = 1U..10U
    val ulongRange = 1UL..10UL

    // ====================================================================================
    // 开区间
    // ====================================================================================

    val intRangeExclusive = 1 until 10 // [1, 10)
    val charRangeExclusive = 'a' until 'z'
    val longRangeExclusive = 1L until 100L

    println("开区间: ${intRangeExclusive.joinToString()}")

    // ====================================================================================
    // 倒序闭区间
    // ====================================================================================

    val intRangeReverse = 10 downTo 1 // [10, 9, ... , 1]
    val charRangeReverse = 'z' downTo 'a'
    val longRangeReverse = 100L downTo 1L

    println("倒序闭区间: ${intRangeReverse.joinToString()}")

    // ====================================================================================
    // 步长
    // ====================================================================================

    val intRangeWithStep = 1..10 step 2
    val charRangeWithStep = 'a'..'z' step 2
    val longRangeWithStep = 1L..100L step 5

    println("步长: ${intRangeWithStep.joinToString()}")

    // ====================================================================================
    // 区间的包含关系
    // ====================================================================================

    if (3.0 !in doubleRange) {
        println("3 in range 'intRange'")
    }

    if (12 !in intRange) {
        println("12 not in range 'intRange'")
    }

    // ====================================================================================
    // 区间的遍历
    // ====================================================================================

    val array = intArrayOf(1, 3, 5, 7)

    for (element in array) {
        println(element)
    }

    array.forEach {
        println(it)
    }

    for (i in array.indices) {
        println(array[i])
    }
}