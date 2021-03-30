package com.watayouxiang.mykotlin._03_builtintypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/8
 *     desc   : 集合框架
 * </pre>
 */
fun main() {

    // ====================================================================================
    // 集合框架
    // ====================================================================================

    //                              Kotlin                      Java
    // 不可变 List                 List<T>                     List<T>
    // 可变 List                  MutableList<T>              List<T>
    // 不可变 Map                  Map<K, V>                   Map<K, V>
    // 可变 Map                   MutableMap<K, V>            Map<K, V>
    // 不可变 Set                  Set<T>                      Set<T>
    // 可变 Set                   MutableSet<T>               Set<T>

    // ====================================================================================
    // List的创建
    // ====================================================================================

    // List 的创建
    val intList: List<Int> = listOf(1, 2, 3, 4)
    val intList2: MutableList<Int> = mutableListOf(1, 2, 3, 4)

    // Map 的创建
    val map: Map<String, Any> = mapOf("name" to "benny", "age" to 20)
    val map2: MutableMap<String, Any> = mutableMapOf("name" to "benny", "age" to 20)

    // ====================================================================================
    // List的增删
    // ====================================================================================

    val stringList = ArrayList<String>()

    for (i in 0..5) {
        stringList.add("num: $i")
    }
    println(stringList.joinToString(", "))

    for (i in 6..10) {
        stringList += "num: $i"
    }
    println(stringList.joinToString(", "))

    for (i in 0..5) {
        stringList -= "num: $i"
    }
    println(stringList.joinToString(", "))

    stringList[0] = "HelloWorld"
    println(stringList.joinToString(", "))

    // ====================================================================================
    // Map的增删改查
    // ====================================================================================

    val hashMap = HashMap<String, Int>()
    hashMap["Hello"] = 10
    println(hashMap["Hello"])

    // ====================================================================================
    // Pair
    // ====================================================================================

    val pair = "Hello" to "Kotlin"
    val pair1 = Pair("Hello", "Kotlin")

    val first = pair.first
    val second = pair.second
    val (x, y) = pair

    println(pair)

    // ====================================================================================
    // Triple
    // ====================================================================================

    val triple = Triple("x", 2, 3.0)
    val first1 = triple.first
    val second1 = triple.second
    val third1 = triple.third
    val (x1, y1, z1) = triple

    println(triple)

}