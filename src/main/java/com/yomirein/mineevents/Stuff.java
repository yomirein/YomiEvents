package com.yomirein.mineevents;

import com.yomirein.mineevents.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public interface Stuff {
    ItemStack EVENT_CHESTPLATE = (ItemBuilder.of(Material.IRON_CHESTPLATE)
            .unbreakable(true)
            .addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
            .addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1)
            .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
            .build());
    ItemStack EVENT_SWORD = (ItemBuilder.of(Material.IRON_SWORD, 0, (short) 32000)
            .unbreakable(true)
            .addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3)
            .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
            .build());
    ItemStack EVENT_BOW = (ItemBuilder.of(Material.BOW)
            .addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4)
            .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
            .addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1)
            .unbreakable(true)
            .build());
    ItemStack EVENT_ARROW = (ItemBuilder.of(Material.ARROW)
            .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
            .build());
}
