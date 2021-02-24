package com.watayouxiang.mykotlin._04_types.classes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/9
 *     desc   : 抽象类
 * </pre>
 */
abstract class AbsClass {

    // 抽象方法可以被复写
    abstract fun absMethod()

    // 非抽象方法，需要添加 "open" 关键字才可以被复写
    open fun overridable() {}

    // 默认非抽象方法，是不可被复写的
    fun nonOverridable() {}

}