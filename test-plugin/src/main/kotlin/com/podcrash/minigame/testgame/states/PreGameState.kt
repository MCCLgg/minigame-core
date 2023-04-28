package com.podcrash.minigame.testgame.states

import com.podcrash.minigame.core.state.State
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.ItemStack

class PreGameState: State() {

    override fun onStart() {
        for (player in Bukkit.getOnlinePlayers()) {
            val inventory = player.inventory
            inventory.helmet = ItemStack(Material.DIAMOND_HELMET)
            inventory.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
            inventory.leggings = ItemStack(Material.DIAMOND_LEGGINGS)
            inventory.boots = ItemStack(Material.DIAMOND_BOOTS)
            inventory.addItem(ItemStack(Material.DIAMOND_SWORD))
            inventory.addItem(ItemStack(Material.FISHING_ROD))
            inventory.addItem(ItemStack(Material.BOW))
            inventory.addItem(ItemStack(Material.ARROW, 64))
            inventory.addItem(ItemStack(Material.GOLDEN_CARROT, 64))
        }
    }

    override fun onEnd() {
        TODO("Not yet implemented")
    }

    @EventHandler
    fun onMove(event: PlayerMoveEvent) {
        if (event.from.x != event.to?.x ||
            event.from.y != event.to?.y ||
            event.from.z != event.to?.z) {
            event.isCancelled = true
        }
    }
}