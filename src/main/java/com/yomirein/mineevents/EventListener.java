package com.yomirein.mineevents;

import com.yomirein.mineevents.utils.ItemBuilder;
import com.yomirein.mineevents.utils.Potions;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Map;

import static com.yomirein.mineevents.MineEvents.config;
import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class EventListener implements Listener {

    @EventHandler
    public void StopDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void giveArmor(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        double playerZ = player.getLocation().getZ();

        if (playerZ >= -26.5 && playerZ <= -26.0) {
            // [-26.5;-26.0]

            player.getInventory().clear();
            player.getInventory().addItem(Stuff.EVENT_SWORD, Stuff.EVENT_BOW);
            player.getInventory().setChestplate(Stuff.EVENT_CHESTPLATE);
            player.addPotionEffect(Potions.of(PotionEffectType.REGENERATION, PotionEffect.INFINITE_DURATION, 2));
        }
        if (playerZ >= -26.0 && playerZ <= -25.5
            && !player.hasPotionEffect(PotionEffectType.REGENERATION)) {

            player.getInventory().clear();
            player.getActivePotionEffects().forEach(potionEffect -> player.removePotionEffect(potionEffect.getType()));
        }
    }
}
