package com.watayouxiang.mykotlin._04_types.classes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/9
 *     desc   : 继承抽象类、实现接口
 * </pre>
 */
open class SimpleClass(var x: Int, val y: String) :
    AbsClass(),// 调用父类的无参构造方法
    SimpleInf// 实现接口
{

    // ====================================================================================
    // SimpleInf 接口的实现
    // ====================================================================================

    // 复写 property
    override val simpleProperty: Int
        get() {
            return 2
        }

    override fun simpleMethod() {}

    // ====================================================================================
    // AbsClass 抽象类的实现
    // ====================================================================================

    override fun absMethod() {}

    final override fun overridable() {

    }

    // ====================================================================================
    // 本类的方法和属性
    // ====================================================================================

    // 定义一个常量属性
    val z: Long
        get() {
            return simpleProperty * 2L
        }


    // 无参数无返回值
    fun y() {}

    // 参数为String，无返回值
    fun zzz(string: String) {

    }

}

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/9
 *     desc   : 继承 构造函数为有参 的 类
 * </pre>
 */
class SimpleClass2(x: Int, y: String) : SimpleClass(x, y) {

}