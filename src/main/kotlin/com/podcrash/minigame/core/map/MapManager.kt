package com.podcrash.minigame.core.map

import org.bukkit.plugin.java.JavaPlugin

class MapManager(val plugin: JavaPlugin) {

    val maps = mutableListOf<Map>()

    fun randomMap() = maps.random()
}