package com.yomirein.mineevents;

import com.yomirein.mineevents.utils.Potions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventListener implements Listener {

    @EventHandler
    public void StopDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void giveArmor(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location portal = new Location(player.getWorld(), 0, -39, 10);
        Location pvpzone = new Location(player.getWorld(), 0, -35, 37);



        if (portal.getNearbyPlayers(4, 1, 4).contains(player)) {
            player.setHealth(20);
            player.setFoodLevel(20);

            player.getInventory().addItem(
                    Stuff.eventSword(), Stuff.eventBow(), Stuff.eventArrow()
            );
            player.getInventory().setChestplate(Stuff.eventChestplate());


            player.addPotionEffect(Potions.of(PotionEffectType.REGENERATION, PotionEffect.INFINITE_DURATION, 2));
            player.addPotionEffect(Potions.of(PotionEffectType.SATURATION, PotionEffect.INFINITE_DURATION, 1));

            player.teleport(pvpzone);
        }
    }
    @EventHandler
    public void resetItems(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
    }

    @EventHandler
    public void IfExit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        Location pvpzone2 = new Location(player.getWorld(), 0, -35, 44);
        Location spawn = new Location(player.getWorld(), 0, -38, 0);

        if(pvpzone2.getNearbyPlayers(34, 15, 12).contains(player)){
            player.getInventory().clear();
            player.getActivePotionEffects().clear();
            player.teleport(spawn);
            player.setHealth(20);
            player.setFoodLevel(20);
        }

    }
}
