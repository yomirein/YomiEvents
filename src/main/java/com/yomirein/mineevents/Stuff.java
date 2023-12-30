package com.yomirein.mineevents;

import com.yomirein.mineevents.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public interface Stuff {
    static ItemStack eventChestplate() {
        return ItemBuilder.of(Material.IRON_CHESTPLATE)
                .unbreakable(true)
                .addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
                .addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1)
                .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
                .build();
    }
    static ItemStack eventSword() {
        return ItemBuilder.of(Material.IRON_SWORD)
            .addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3)
            .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
                .unbreakable(true)
            .build();
    }
    static ItemStack eventBow() {
        return ItemBuilder.of(Material.BOW)
                .addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4)
                .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
                .addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1)
                .unbreakable(true)
                .build();
    }
    static ItemStack eventArrow()  {
        return ItemBuilder.of(Material.ARROW)
                .addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1)
                .build();
    }
}
