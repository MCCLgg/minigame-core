package com.podcrash.minigame.testgame

import com.podcrash.minigame.core.MinigameCore
import com.podcrash.minigame.testgame.states.LobbyState
import com.podcrash.minigame.testgame.states.MainGameState
import com.podcrash.minigame.testgame.states.PreGameState
import org.bukkit.plugin.java.JavaPlugin

/**
 * 1v1 duel game as a test plugin
 */
class TestGamePlugin: JavaPlugin() {

    lateinit var minigameCore: MinigameCore

    override fun onEnable() {
        minigameCore = MinigameCore(this)

        val stateManager = minigameCore.stateManager
        stateManager.add(LobbyState())
        stateManager.add(PreGameState())
        stateManager.add(MainGameState())
        stateManager.start()
    }
}