package com.nan.kotlinprimer.day7_class_basic.player

fun main() {
    val user = User(10, "huannan", PlayerViewType.VIP)
    PlayerManager.getInstance().show(user.type)
}