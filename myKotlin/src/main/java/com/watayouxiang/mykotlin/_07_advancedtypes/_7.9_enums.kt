package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     枚举类
 *
 * </pre>
 */

// 枚举
enum class State {
    Idle, Busy
}

// 枚举 - 定义构造器
enum class State2(val id: Int) {
    Idle(0), Busy(1)
}

// 枚举 - 实现接口 - 统一实现
enum class State3 : Runnable {
    Idle, Busy;

    override fun run() {

    }
}

// 枚举 - 实现接口 - 各自实现
enum class State4 : Runnable {
    Idle {
        override fun run() {

        }
    },
    Busy {
        override fun run() {

        }
    };
}

// 为枚举定义扩展
fun State.next(): State {
    return State.values().let {
        val nextOrdinal = (ordinal + 1) % it.size
        it[nextOrdinal]
    }
}

fun main() {
    State.Idle.name// Idle
    State.Idle.ordinal// 0

    val next = State.Idle.next()

    // 分支表达式
    val value = when (next) {
        State.Idle -> {
            0
        }
        State.Busy -> {
            1
        }
    }

    // 枚举的比较
    if (next <= State.Busy) {

    }

    // 枚举的区间
    val stateRange = State.Idle..State.Busy
    if (next in stateRange) {

    }

}