package com.watayouxiang.mykotlin._06_advancedfunctions

import java.io.File

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/07/27
 *     desc   : 几个有用的高阶函数
 * </pre>
 */
fun main() {
    val person = Person("benny", 20)

    /**
     * ------------------------------------------
     * let:
     *      val r = X.let { x -> R }
     *      x: 参数是X
     *      r: 返回值是lambda表达式的最后一个参数
     * ------------------------------------------
     */

    person.let {
        it.name = "hhh"
    }
    person.let(::println)

    /**
     * ------------------------------------------
     * run:
     *      val r = X.run { this: X -> R }
     *      x: X作为一个 receiver 传递（this）
     *      r: 返回值是lambda表达式的最后一个参数
     * ------------------------------------------
     */
    person.run {
        name = "xxx"
    }
    person.run(::println)

    /**
     * ------------------------------------------
     * also：
     *      val x = X.also { x -> Unit }
     *      x: X作为一个参数传递
     *      r: 返回值是Unit
     * ------------------------------------------
     */

    val person1 = person.also {
        it.name = "theShy"
        it.age = 20
    }

    /**
     * ------------------------------------------
     * apply：
     *      val x = X.apply { this:X -> Unit }
     *      x: X作为一个 receiver 传递（this）
     *      r: 返回值是Unit
     * ------------------------------------------
     */

    val person2 = person.apply {
        name = "jackLove"
        age = 19
    }

    /**
     * ------------------------------------------
     * use:
     *      val r = Closeable.use { c -> R }
     *      离开代码块，资源会被自动释放，避免资源泄露
     * ------------------------------------------
     */

    File("build.gradle").inputStream().reader().buffered().use {
        println(it.readLines())
    }

}

class Person(var name: String, var age: Int)