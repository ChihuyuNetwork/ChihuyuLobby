package love.chihuyu.chihuyulobby.listeners

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityInteractEvent


object FarmProtectionListener: Listener {

    @EventHandler
    fun onEntityInteract(event: EntityInteractEvent) {
        val block = event.block
        event.isCancelled = block.type == Material.FARMLAND
    }
}