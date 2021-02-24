package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/12
 *     desc   :
 *
 *     内联类
 *
 *     - 内联类是对某一类型的包装
 *     - 内联类是类似于 Java 装箱类型的一种类型
 *     - 编译器会尽可能使用被包装的类型进行优化
 *     - 内联类在 Kotlin 1.3 中处于公测阶段，谨慎使用
 *
 *     内联类的限制
 *
 *     - 主构造器必须有且仅有一个只读属性
 *     - 不能定义有 backing-field 的其他属性
 *     - 被包装的类型必须不能是泛型类型
 *     - 不能继承父类也不能被继承
 *     - 内联类不能定义其他类的内部类
 *
 *
 * </pre>
 */

// 内联类：包装 Int 类型
inline class BoxInt(val value: Int) : Comparable<Int> {

    // 内联类的方法
    operator fun inc(): BoxInt {
        return BoxInt(value + 1)
    }

    // 内联类可以实现接口，但不能继承父类也不能被继承
    override fun compareTo(other: Int): Int = value.compareTo(other)
}

fun main() {
    // BoxInt 跟 Int 比较大小
    val boxInt = BoxInt(5)
    if (boxInt < 10) {
        println("value is less than 10")
    }

    // 内联类实现无符号类型
    val uint: UInt = 10u

    // inline 应用举例
    setRouteType(RouteType.WALK)
}

// ====================================================================================
// inline 应用举例
// ====================================================================================

inline class RouteTypeInline(val value: Int)

object RouteType {
    val WALK = RouteTypeInline(0)
    val BUS = RouteTypeInline(1)
    val CAR = RouteTypeInline(2)
}

fun setRouteType(type: RouteTypeInline) {

}


