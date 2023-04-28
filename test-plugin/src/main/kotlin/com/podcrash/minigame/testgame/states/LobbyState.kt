package com.podcrash.minigame.testgame.states

import com.podcrash.minigame.core.state.State
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent

class LobbyState: State() {

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onEnd() {
        TODO("Not yet implemented")
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        // directly do events
    }

    fun countdown() {
        // 5
        // 4
        // 3
        // 2
        // 1

        // End lobby state and starts pre-game state
        end()
    }
}