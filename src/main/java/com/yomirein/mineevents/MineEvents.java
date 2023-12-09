package com.yomirein.mineevents;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MineEvents extends JavaPlugin {
    public static boolean isOpen = true;
    public static FileConfiguration config;

    public static MineEvents instance;

    @Override
    public void onEnable() {

        System.out.println("Запускаем MineEvents plugin!");

        config = getConfig();
        isOpen = config.getBoolean("isOpen");

        for (Method method : Stuff.class.getMethods()) {
            try {
                ItemStack stack = (ItemStack) method.invoke(null);
                System.out.println(stack.getType() +" "+ stack.getItemMeta());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        instance = this;

        getServer().getPluginManager().registerEvents(new EventListener(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("До встречи(");
    }
}
