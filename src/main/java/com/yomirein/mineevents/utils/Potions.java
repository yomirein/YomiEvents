package com.yomirein.mineevents.utils;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public interface Potions {
    static PotionEffect of(PotionEffectType effectType, int duration, int level) {
        return new PotionEffect(effectType, duration, level);
    }
    static PotionEffect of(PotionEffectType effectType, int duration) {
        return of(effectType, duration, 0);
    }
}
