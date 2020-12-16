package com.nan.kotlinprimer.day7_class_basic.player

/**
 * 播放器显示样式
 * 密闭类
 */
sealed class PlayerViewType {
    object BLUE : PlayerViewType()
    object RED : PlayerViewType()
    object VIP : PlayerViewType(), IPlayer {
        override fun show() {
            println("vip")
        }
    }
}

fun getPlayerView(type: PlayerViewType) = when (type) {
    PlayerViewType.BLUE -> BluePlayer()
    PlayerViewType.RED -> RedPlayer()
    PlayerViewType.VIP -> PlayerViewType.VIP
}