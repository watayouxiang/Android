package com.watayouxiang.mykotlin._06_advancedfunctions

import com.watayouxiang.mykotlin._06_advancedfunctions.sam.EventManager
import java.util.concurrent.Executors

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/10/12
 *     desc   :
 *
 *     1、SAM: Single Abstract Method
 *
 *     2、Java和Kotlin的SAM区别：
 *          java 的 lambda 是假的，本质就是 SAM。
 *          Kotlin 的 lambda 是真的，支持 SAM 转换。
 *
 *     3、SAM 转换
 *          java：一个参数类型为 "只有一个方法的接口" 的方法。
 *              调用时可用 Lambda 表达式做转换作为参数。
 *          Kotlin：一个参数类型为 "只有一个方法的Java接口" 的Java方法。
 *              调用时可用 Lambda 表达式作转换作为参数。
 *
 * </pre>
 */
fun main() {

    // ====================================================================================
    // kotlin 的 SAM
    // ====================================================================================

    val executor = Executors.newSingleThreadExecutor()

    // Kotlin 的 SAM 本质是：新建一个 "Runnable匿名内部类"，
    // 再把类型为 "()->Unit的Lambda" 内联到 "Runnable匿名内部类" 中执行
    //
    // Kotlin 的 SAM 本质总结：实际上是创建了一个 Runnable 包装了一下 Lambda，并非直接转换
    executor.submit {
        println("run in executor")
    }
    // 与上面代码完全等价
    executor.submit(object : Runnable {
        override fun run() {
            { println("run in executor") }()
        }
    })
    // 与上面代码完全等价
    executor.submit(object : Runnable {
        override fun run() {
            println("run in executor")
        }
    })

    // ====================================================================================
    // 匿名内部类的简写
    // ====================================================================================

    // "匿名内部类" 简写前
    object : java.lang.Runnable {
        override fun run() {

        }
    }

    // "匿名内部类" 简写后
    java.lang.Runnable {

    }

}

// ====================================================================================
// kotlin 原生是不支持 SAM
// 之所以支持 java 的 SAM 代码，完全是为了兼容 java。
// ====================================================================================

fun test() {
    // 会报错，因为需要的是 Invokable 类型，但是传的却是 Lambda
//    submitInvokable {
//
//    }
}

fun submitInvokable(invokable: Invokable) {
    invokable.invoke()
}

interface Invokable {
    fun invoke()
}

// ====================================================================================
// kotlin 不支持 SAM，那怎么写类似与 java SAM 的代码呢？
// ====================================================================================

fun test2() {
    // 这样就达到了类似与 java SAM 的效果
    submitMyFunction {

    }
}

// typealias 的使用
typealias MyFunction = () -> Unit

fun submitMyFunction(lambda: MyFunction) {

}

// ====================================================================================
// SAM 转换的坑
// ====================================================================================

fun error_example() {
    val eventManager = EventManager()

    // 添加监听
    eventManager.addOnEventListener {
        println("onEvent $it")
    }
    eventManager.addOnEventListener(object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    })

    // 移除监听
    eventManager.removeOnEventListener {

    }
    eventManager.removeOnEventListener(object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    })
}

fun correct_example() {
    val eventManager = EventManager()

    // 匿名内部类
    val onEvent = object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    }

    // 添加监听
    eventManager.addOnEventListener(onEvent)

    // 移除监听
    eventManager.removeOnEventListener(onEvent)
}