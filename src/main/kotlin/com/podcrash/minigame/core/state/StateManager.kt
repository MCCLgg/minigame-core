package com.podcrash.minigame.core.state

import com.podcrash.minigame.core.event.UpdateEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import java.lang.RuntimeException

class StateManager(val plugin: JavaPlugin): Listener {

    val states = mutableListOf<State>()
    var current = 0

    fun start() {
        if (states.isEmpty())
            throw RuntimeException("No states registered")

        Bukkit.getServer().pluginManager.registerEvents(states[0], plugin)
        states[0].onStart()
    }

    fun add(state: State) {
        states += state
    }

    fun next() {
        val currentState = states[current]
        // If current is out of bounds, restart state loop (ie. Lobby -> Game -> End -> Lobby)
        if (states.size <= ++current) current = 0
        val nextState = states[current]

        currentState.onEnd()
        HandlerList.unregisterAll(currentState)

        Bukkit.getServer().pluginManager.registerEvents(nextState, plugin)
        nextState.ended = false
        nextState.onStart()
    }

    @EventHandler
    fun onUpdate(event: UpdateEvent) {
        if (states[current].ended)
            next()
    }
}