package com.yomirein.mineevents.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
    ItemStack item;

    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment, int level) {
            item.addUnsafeEnchantment(enchantment, level);
        return this;
    }
    public ItemBuilder unbreakable(boolean value) {
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(value);
        item.setItemMeta(meta);
        return this;
    }
    public ItemStack build() {
        return item;
    }

    // fabric methods
    public static ItemBuilder of(Material material, int amount, short damage, Byte data) {
        return new ItemBuilder(material, amount, damage, data);
    }
    public static ItemBuilder of(Material material, int amount, short damage) {
        return new ItemBuilder(material, amount, damage, null);
    }
    public static ItemBuilder of(Material material, int amount) {
        return new ItemBuilder(material, amount, (short) 0);
    }
    public static ItemBuilder of(Material material) {
        return new ItemBuilder(material, 0);
    }

    private ItemBuilder(Material material) {
        this(material, 1);
    }
    private ItemBuilder(Material material, int amount) {
        this(material, amount, (short) 0);
    }
    private ItemBuilder(Material material, int amount, short damage) {
        this(material, amount, damage, null);
    }
    private ItemBuilder(Material material, int amount, short damage, Byte data) {
        this.item = new ItemStack(material, amount, damage, data);
    }
}
