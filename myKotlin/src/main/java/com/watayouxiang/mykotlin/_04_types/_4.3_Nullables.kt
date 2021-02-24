package com.watayouxiang.mykotlin._04_types

import com.watayouxiang.mykotlin._04_types.nullables.Person

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/10
 *     desc   : 空类型安全
 * </pre>
 */
fun main() {

    // ====================================================================================
    // 默认不能为空
    // ====================================================================================

    var nonNull: String = "Hello"
//     nonNull = null
    val length = nonNull.length

    // ====================================================================================
    // (?) 表示可以为空
    // (?:) 如果为空的话，则...
    // (!!) 强转不可空类型
    // ====================================================================================

    var nullable: String? = "Hello"
    try {
        // 表示可以为空 (?)
        val length1 = nullable?.length
        println("length1 = $length1")
    } catch (e: Exception) {
        println("length1 = $e")
    }
    // 如果为空的话，返回0 (?:)
    val length2 = nullable?.length ?: 0
    println("length2 = $length2")
    // 强转为不为空类型 (!!)
    val length3 = nullable!!.length
    println("length3 = $length3")


    // ====================================================================================
    // (String?) 是 (String) 的父类
    // ====================================================================================

    var x: String = "Hello"
    var y: String? = "World"

//    x = y // Type mismatch
    y = x // OK

    var a: Int = 2
    var b: Number = 10.0

//    a = b // Type mismatch
    b = a // OK

    // ====================================================================================
    // (String!) 表示可以为空的 String 类型
    // (String!) 平台类型只可客观存在，不可主观定义
    // ====================================================================================

    val person = Person()
    val title = person.title
    val titleLength = title?.length

//    val file = File("abc")
//    val files = file.listFiles()
//    println(files.size)


}

