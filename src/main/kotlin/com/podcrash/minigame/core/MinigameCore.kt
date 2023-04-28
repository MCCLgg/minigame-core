package com.podcrash.minigame.core

import com.podcrash.minigame.core.kit.KitManager
import com.podcrash.minigame.core.map.MapManager
import com.podcrash.minigame.core.state.StateManager
import com.podcrash.minigame.core.team.TeamManager
import org.bukkit.plugin.java.JavaPlugin

class MinigameCore(val plugin: JavaPlugin) {

    val stateManager = StateManager(plugin)
    val kitManager = KitManager(plugin)
    val teamManager = TeamManager(plugin)
    val mapManager = MapManager(plugin)
}