package com.watayouxiang.mykotlin._07_advancedtypes.delegates

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *    接口代理 示例：
 *
 *    超级数组（实现 List 和 Map 混用）
 *
 *
 *
 * </pre>
 */

class SuperArray<E>(
    private val list: MutableList<E?> = ArrayList(),
    private val map: MutableMap<Any, E> = HashMap()
) : MutableList<E?> by list, MutableMap<Any, E> by map {

    override fun isEmpty() = list.isEmpty() && map.isEmpty()

    override val size: Int
        get() = list.size + map.size

    override fun clear() {
        list.clear()
        map.clear()
    }

    override operator fun set(index: Int, element: E?): E? {
        if (list.size <= index) {
            repeat(index - list.size + 1) {
                list.add(null)
            }
        }
        return list.set(index, element)
    }

    override fun toString(): String {
        return """List: [$list]; Map: [$map]"""
    }
}

fun main() {
    val superArray = SuperArray<String>()
    val superArray2 = SuperArray<String>()
    superArray += "Hello"
    superArray["Hello"] = "World"
    superArray2[superArray] = "World"

    superArray[1] = "world"
    superArray[4] = "!!!"

    println(superArray)
    println(superArray2)
}
