package com.podcrash.minigame.core

import com.podcrash.minigame.core.event.UpdateEvent
import com.podcrash.minigame.core.kit.KitManager
import com.podcrash.minigame.core.map.MapManager
import com.podcrash.minigame.core.state.StateManager
import com.podcrash.minigame.core.team.TeamManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

class MinigameCore(val plugin: JavaPlugin) {

    val stateManager = StateManager(plugin)
    val kitManager = KitManager(plugin)
    val teamManager = TeamManager(plugin)
    val mapManager = MapManager(plugin)

    init {
        Bukkit.getServer().pluginManager.registerEvents(stateManager, plugin)

        Bukkit.getServer().scheduler.runTaskTimer(plugin,
            Runnable { Bukkit.getServer().pluginManager.callEvent(UpdateEvent()) }, 0, 1)
    }
}