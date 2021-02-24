package com.watayouxiang.mykotlin._04_types

import com.watayouxiang.mykotlin._04_types.smartcasts.Kotliner
import com.watayouxiang.mykotlin._04_types.smartcasts.Person

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/7/10
 *     desc   : 智能类型转换
 * </pre>
 */
fun main() {

    val kotliner: Kotliner = Person("benny", 20)

    // 判断 kotliner 是否为 Person 类型
    if (kotliner is Person) {

        // (as?) 安全转换，失败返回 null
        val person = kotliner as? Person
        // person 为 Person? 类型，可能为空
        // 所以需要 ?. 访问
        val name = person?.name

        println((kotliner as? Person)?.name)
    }

}

