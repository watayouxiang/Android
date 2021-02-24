package com.watayouxiang.mykotlin._07_advancedtypes

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     密封类
 *
 *     - 密封类是一种特殊的抽象类
 *     - 密封类的子类定义在与自身相同的文件中
 *
 * </pre>
 */

data class Song(val name: String, val url: String, var position: Int)
data class ErrorInfo(val code: Int, val message: String)

// 首先是个抽象类
// 其次是个密封类
sealed class PlayerState {
    // 构造器私有
    constructor()
    constructor(int: Int)
}

// 密封类的子类，继承密封类，调用了密封类的构造函数
object Idle : PlayerState()

class Playing(val song: Song) : PlayerState() {
    fun start() {}
    fun stop() {}
}

class Error(val errorInfo: ErrorInfo) : PlayerState() {
    fun recover() {}
}


class Player {
    var state: PlayerState = Idle

    fun play(song: Song) {
        this.state = when (val state = this.state) {
            Idle -> {
                Playing(song).also(Playing::start)
            }
            is Playing -> {
                state.stop()
                Playing(song).also(Playing::start)
            }
            is Error -> {
                state.recover()
                Playing(song).also(Playing::start)
            }
        }
    }
}

object Songs {
    val StarSky = Song(
        "Star Sky",
        "https://fakeurl.com/321144.mp3",
        0
    )
}

fun main() {
    val player = Player()
    player.play(Songs.StarSky)
}

