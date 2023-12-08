package com.yomirein.mineevents;

import com.yomirein.mineevents.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public interface Stuff {
    ItemStack EVENT_CHESTPLATE = ItemBuilder.of(Material.IRON_CHESTPLATE)
            .unbreakable(true)
            .addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2)
            .build();
    ItemStack EVENT_SWORD = ItemBuilder.of(Material.IRON_SWORD, 0, (short) 32000)
            .unbreakable(true)
            .addEnchantment(Enchantment.DAMAGE_ALL, 3)
            .build();
    ItemStack EVENT_BOW = ItemBuilder.of(Material.BOW)
            .addEnchantment(Enchantment.ARROW_DAMAGE, 4)
            .unbreakable(true)
            .build();
}
