package com.podcrash.minigame.core.state

import org.bukkit.Bukkit
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin
import java.lang.RuntimeException

class StateManager(val plugin: JavaPlugin) {

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
        nextState.onStart()
    }
}