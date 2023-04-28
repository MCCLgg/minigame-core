package com.podcrash.minigame.core.state

import org.bukkit.event.Listener

abstract class State: Listener {

    fun end() {
        // find a way to call the next function from state manager
        onEnd()
    }

    abstract fun onStart()

    abstract fun onEnd()
}