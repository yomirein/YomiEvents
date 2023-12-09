package com.yomirein.mineevents;

import com.yomirein.mineevents.utils.Potions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
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
        double playerZ = player.getLocation().getZ();

        if (playerZ >= -26.5 && playerZ <= -26.0) {
            player.getInventory().clear();


            player.getInventory().addItem(Stuff.eventSword());
            player.getInventory().addItem(Stuff.eventBow());
            player.getInventory().addItem(Stuff.eventArrow());

            player.getInventory().setChestplate(Stuff.eventChestplate());


            player.addPotionEffect(Potions.of(PotionEffectType.REGENERATION, PotionEffect.INFINITE_DURATION, 2));
            player.addPotionEffect(Potions.of(PotionEffectType.SATURATION, PotionEffect.INFINITE_DURATION, 1));
        }

        if (playerZ >= -26.0 && playerZ <= -25.5
            && !player.hasPotionEffect(PotionEffectType.REGENERATION)) {

            player.getInventory().clear();
            player.getActivePotionEffects().forEach(potionEffect -> player.removePotionEffect(potionEffect.getType()));
        }
    }
}
