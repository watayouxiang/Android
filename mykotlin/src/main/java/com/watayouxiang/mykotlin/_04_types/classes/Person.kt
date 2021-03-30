package com.watayouxiang.mykotlin._04_types.classes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/9
 *     desc   : 数据模型
 * </pre>
 */
class Person(age: Int, name: String) {

    // property = backing field + getter + setter
    var age: Int = age //property
        get() {
            return field
        }
        set(value) {
            println("setAge: $value")
            field = value
        }

    var name: String = name
        get() {
            return field // backing field
        }
        set(value) {
            field = value
        }
}

fun main() {
    val person = Person(18, "Bennyhuo")

    // 对象的 property 引用
    val nameRef = person::name
    nameRef.set("Andyhuo")

    // 类的 property 引用
    val ageRef = Person::age
    ageRef.set(person, 20)

}