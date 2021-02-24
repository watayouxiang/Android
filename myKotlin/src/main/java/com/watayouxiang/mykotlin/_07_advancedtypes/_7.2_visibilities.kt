package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *
 *     可见性对比             java                     kotlin
 *     --------------------------------------------------------------
 *     public               公开                   与java相同（默认）
 *     internal             x                       模块内可见
 *     default              包内可见（默认）            x
 *     protected            包内及子类可见             类内及子类可见
 *     private              类内可见                 类内及文件内可见
 *
 *
 * </pre>
 */

// 构造器私有化
class Person3 private constructor(var age: Int, var name: String)

// 属性的可见性
class Person4(private var age: Int, var name: String)