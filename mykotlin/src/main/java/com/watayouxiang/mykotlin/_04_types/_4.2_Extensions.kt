package com.watayouxiang.mykotlin._04_types

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/9
 *     desc   : 拓展方法
 * </pre>
 */

// ====================================================================================
// 扩展方法、扩展成员
// ====================================================================================

class PoorGuy {
    var pocket: Double = 0.0
}

// 扩展方法
fun PoorGuy.noMoney() {

}

// 扩展成员：没有口袋，不能存储，但是可以访问父类的属性
// property = backing field + getter + setter
var PoorGuy.moneyLeft: Double
    get() {
        return this.pocket
    }
    set(value) {
        pocket = value
    }

// ====================================================================================
// 接口定义行为、不能存储状态
// ====================================================================================

interface Guy {
    var moneyLeft: Double
        get() {
            return 0.0
        }
        set(value) {

        }

    fun noMoney() {
        println("no money called.")
    }
}

// ====================================================================================
// 示例
// ====================================================================================

// 给 String 扩展方法 padding
// (Int, Char) -> (String)
fun String.padding(count: Int, char: Char = ' '): String {
    /*
    相当于：

    arrayOf(1, 2, 3).forEach {
        println(it)
    }
    */
    val padding = (1..count).joinToString("") { char.toString() }
    return "${padding}${this}${padding}"
}

// 给 String 扩展方法 isEmail
// (Void) -> (Boolean)
fun String.isEmail(): Boolean {
    return matches(Regex("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
}

// 给 String 扩展方法 times
// (Int) -> (String)
fun String.times(count: Int): String {
    /*
    相当于：

    arrayOf(1, 2, 3).forEach {
        println(it)
    }
    */
    return (1..count).joinToString("") { this }
}

fun main() {

    println("admin@bennyhuo.com".isEmail())
    println("Hello".padding(2))
    println("*".times(10))

    // 类的拓展引用
    val stringTimes = String::times
    stringTimes("*", 10)

    // 对象的拓展引用
    val stringTimesBound = "*"::times
    stringTimesBound(10)

}