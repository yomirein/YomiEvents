package com.yomirein.mineevents;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class MineEvents extends JavaPlugin {
    public static boolean isOpen = true;
    public static FileConfiguration config;

    public static MineEvents instance;

    @Override
    public void onEnable() {

        System.out.println("Запускаем MineEvents plugin!");

        config = getConfig();
        isOpen = config.getBoolean("isOpen");

        instance = this;

        getServer().getPluginManager().registerEvents(new EventListener(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("До встречи(");
    }
}
