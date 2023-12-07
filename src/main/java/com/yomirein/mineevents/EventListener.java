package com.yomirein.mineevents;

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

public class EventListener implements Listener {

    @EventHandler
    public void StopDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void GiveArmor(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        ItemStack IronSword = new ItemStack(Material.IRON_SWORD);
        IronSword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        IronSword.setDurability((short) 32000);

        ItemStack IronChest = new ItemStack(Material.IRON_CHESTPLATE);
        IronChest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);

        double z = player.getLocation().getZ();

        Boolean reg = player.getActivePotionEffects().contains(PotionEffectType.REGENERATION);

        if (z >= -26.5 && z <= -26.0) {
            //-26.5 -- -26.0


            player.getInventory().clear();
            player.getInventory().addItem(IronSword, new ItemStack(Material.BOW));
            player.getInventory().setChestplate(IronChest);
            player.addPotionEffect(new PotionEffect (PotionEffectType.REGENERATION, 10000, 2));
        }
        if (z >= -26.0 && z <= -25.5
            && !reg) {


            player.getInventory().clear();
            player.getActivePotionEffects().clear();
        }
    }
}
