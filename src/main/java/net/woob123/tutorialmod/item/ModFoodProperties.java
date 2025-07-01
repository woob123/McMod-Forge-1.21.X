package net.woob123.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties KOHLRABI =  new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 400), 0.2f)
            .usingConvertsTo(Items.DIAMOND) /// just transforms it into a diamond after eaten lmao
            .build();


    public static final FoodProperties BRANDY = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 1f)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();
}
