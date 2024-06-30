package love.chihuyu.chihuyulobby

import love.chihuyu.chihuyulobby.listeners.HornListener
import love.chihuyu.chihuyulobby.listeners.LeafListener
import org.bukkit.GameRule
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin

class ChihuyuLobbyPlugin : JavaPlugin() {
    companion object {
        lateinit var ChihuyuLobbyPlugin: JavaPlugin
    }

    init {
        ChihuyuLobbyPlugin = this
    }

    override fun onEnable() {
        server.worlds.forEach {
            it.fixGamerule()
        }

        listOf(
            HornListener,
            LeafListener
        ).forEach {
            server.pluginManager.registerEvents(it, this)
        }
    }

    private fun World.fixGamerule() {
        listOf(
            GameRule.DO_MOB_SPAWNING,
            GameRule.DO_PATROL_SPAWNING,
            GameRule.DO_TRADER_SPAWNING,
            GameRule.DO_WARDEN_SPAWNING,
            GameRule.DO_WEATHER_CYCLE,
            GameRule.DO_DAYLIGHT_CYCLE,
            GameRule.DO_FIRE_TICK,
            GameRule.DO_VINES_SPREAD,
            GameRule.MOB_GRIEFING,
            GameRule.FREEZE_DAMAGE,
            GameRule.FIRE_DAMAGE,
            GameRule.DROWNING_DAMAGE,
            GameRule.FALL_DAMAGE,
            GameRule.DO_INSOMNIA,
            GameRule.ANNOUNCE_ADVANCEMENTS,
            GameRule.PROJECTILES_CAN_BREAK_BLOCKS,
            GameRule.DO_MOB_LOOT,
            GameRule.DO_ENTITY_DROPS,
            GameRule.NATURAL_REGENERATION,
        ).forEach { setGameRule(it, false) }
        listOf(
            GameRule.DO_IMMEDIATE_RESPAWN,
            GameRule.DO_TILE_DROPS,
            GameRule.COMMAND_BLOCK_OUTPUT,
            GameRule.DISABLE_RAIDS,
            GameRule.KEEP_INVENTORY,
            GameRule.LOG_ADMIN_COMMANDS,
            GameRule.SPECTATORS_GENERATE_CHUNKS,
            GameRule.SEND_COMMAND_FEEDBACK,
            GameRule.SHOW_DEATH_MESSAGES,
            GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK,
            GameRule.BLOCK_EXPLOSION_DROP_DECAY
        ).forEach { setGameRule(it, true) }
        setGameRule(GameRule.SPAWN_RADIUS, 0)
        setGameRule(GameRule.PLAYERS_NETHER_PORTAL_CREATIVE_DELAY, 0)
        setGameRule(GameRule.PLAYERS_NETHER_PORTAL_DEFAULT_DELAY, 0)
        setGameRule(GameRule.SPAWN_CHUNK_RADIUS, 0)
    }
}
