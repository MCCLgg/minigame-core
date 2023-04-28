package com.podcrash.minigame.core.event

import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Fires on every server-tick
 */
class UpdateEvent: Event() {

    override fun getHandlers() = HANDLERS

    companion object {

        @JvmStatic
        val HANDLERS = HandlerList()

        @JvmStatic
        fun getHandlerList() = HANDLERS
    }
}