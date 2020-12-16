package com.nan.kotlinprimer.day7_class_basic.player

/**
 * 单例
 */
class PlayerManager private constructor() {

    companion object {
        fun getInstance() = Holder.INSTANCE
    }

    object Holder {
        val INSTANCE = PlayerManager()
    }

    fun show(type: PlayerViewType) {
        // 代理
        Player(getPlayerView(type)).show()
    }

}