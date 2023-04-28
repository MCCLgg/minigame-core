package com.podcrash.minigame.testgame.states

import com.podcrash.minigame.core.state.State
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.PlayerDeathEvent

class MainGameState: State() {

    lateinit var winner: Player

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onEnd() {
        TODO("Not yet implemented")
    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        // Player died so the duel is over
        end()
    }
}