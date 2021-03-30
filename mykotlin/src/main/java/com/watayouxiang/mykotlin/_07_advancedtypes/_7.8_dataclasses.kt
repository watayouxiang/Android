package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     数据类
 *
 * </pre>
 */

// 数据类
// 数据类不允许被继承，违反对称性 和 传递性
data class Book(val id: Long, val name: String, val author: Person)

fun main() {
    val person = Person(20, "lily")
    val book = Book(10001, "小红帽的故事", person)

    // 数据类的解构
    // 定义在主构造器中的属性又称为 component
    val id = book.component1()
    val name = book.component2()
    val author = book.component3()

}