package com.nan.kotlinprimer.day7_class_basic.player

interface IPlayer {
    fun show()
}

class BluePlayer : IPlayer {
    override fun show() {
        println("blue")
    }
}

class RedPlayer : IPlayer {
    override fun show() {
        println("red")
    }
}

/**
 * 代理类
 */
class Player(player: IPlayer) : IPlayer by player