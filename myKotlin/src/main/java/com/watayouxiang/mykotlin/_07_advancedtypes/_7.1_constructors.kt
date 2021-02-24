package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     构造函数
 *
 * </pre>
 */

// 构造函数
class Person constructor(var age: Int, var name: String) {
    init {

    }
}

// 继承
abstract class Animal
class Cat constructor(var name: String) : Animal()

// 副构造器
class Person2 constructor(var age: Int, var name: String) {
    constructor(age: Int) : this(age, "unknown")
}

// "工厂函数" 构造对象
// 和类同名的函数，叫"工厂函数"
val persons = HashMap<String, Person>()
fun Person(name: String): Person {
    return persons[name] ?: Person(1, name).also { persons[name] = it }
}