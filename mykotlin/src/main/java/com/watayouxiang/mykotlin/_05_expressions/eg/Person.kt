package com.watayouxiang.mykotlin._05_expressions.eg

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/16
 *     desc   : 为 Person 实现 equal 和 hashCode
 * </pre>
 */
fun main() {
    val persons = HashSet<Person>()

    // [0...5]
    // 循环 6 次
    (0..5).forEach {
        persons += Person(20, "Benny")
    }

    // 加一个元素
    val person = Person(20, "Benny")
    persons += person
    println(persons.size)

    // 去除一个元素
    val person2 = Person(person.age + 1, person.name)
    persons -= person2
    println(persons.size)

}

class Person(val age: Int, val name: String) {
    override fun equals(other: Any?): Boolean {
        // 将 other 转换成 Person 类型
        // 如果转换失败则 return false
        val other = other as? Person ?: return false
        // 转换成功，说明 other 绝不为空
        return other.age == age && other.name == name
    }

    override fun hashCode(): Int {
        return 1 + 7 * age + 13 * name.hashCode()
    }
}