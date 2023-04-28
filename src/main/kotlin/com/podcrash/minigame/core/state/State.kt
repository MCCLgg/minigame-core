package com.podcrash.minigame.core.state

import org.bukkit.event.Listener

abstract class State: Listener {

    var ended = false

    fun end() {
        ended = true
    }

    abstract fun onStart()

    abstract fun onEnd()
}