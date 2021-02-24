package com.watayouxiang.mykotlin._04_types

import com.watayouxiang.mykotlin._04_types.classes.SimpleClass

fun main() {
    val simpleClass = SimpleClass(9, "Hello")
    println(simpleClass.simpleProperty)
    println(simpleClass.x)
    println(simpleClass.y)
    println(simpleClass.z)
    simpleClass.y()
    simpleClass.zzz("Sleeping ZZZ!")
}

