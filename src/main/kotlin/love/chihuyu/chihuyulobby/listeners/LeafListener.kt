package love.chihuyu.chihuyulobby.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.LeavesDecayEvent

object LeafListener: Listener {

    @EventHandler
    fun onDecay(e: LeavesDecayEvent) {
        e.isCancelled = true
    }
}