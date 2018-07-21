package net.lapismc.homespawnnofall;

import net.lapismc.homespawn.api.events.HomeTeleportEvent;
import net.lapismc.homespawn.api.events.SpawnTeleportEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class HomeSpawnNoFall extends JavaPlugin implements Listener {

    private Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        logger.info("HomeSpawnNoFall v." + getDescription().getVersion() + " has been enabled!");
    }

    @EventHandler
    public void onHomeTeleport(HomeTeleportEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("homespawnnofall.exclude")) {
            if (!p.isFlying() && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                e.setCancelled(true, ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message")));
            }
        }
    }

    @EventHandler
    public void onSpawnTeleport(SpawnTeleportEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("homespawnnofall.exclude")) {
            if (!p.isFlying() && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                e.setCancelled(true, ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message")));
            }
        }
    }

}
