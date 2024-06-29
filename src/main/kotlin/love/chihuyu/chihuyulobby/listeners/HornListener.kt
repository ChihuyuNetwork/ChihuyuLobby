package love.chihuyu.chihuyulobby.listeners

import com.destroystokyo.paper.profile.PlayerProfile
import io.papermc.paper.event.player.PlayerItemCooldownEvent
import org.bukkit.BanEntry
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.time.Instant

object HornListener: Listener {

    @EventHandler
    fun onHorn(e: PlayerItemCooldownEvent) {
        val player = e.player
        val item = e.type

        if (item == Material.GOAT_HORN) player.ban<BanEntry<PlayerProfile>>("笛を使うな", Instant.now().plusSeconds(60), "ChihuyuLobby", true)
    }
}