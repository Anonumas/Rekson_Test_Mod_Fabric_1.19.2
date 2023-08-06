package net.anonumas.reksontestmod.potion;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.effect.ModEffects;
import net.anonumas.reksontestmod.item.ModItems;
import net.anonumas.reksontestmod.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion SOFT_SKIN_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(ReksonTestMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.SOFT_SKIN, 200, 0)));
    }

    public static void registerPotions(){
        SOFT_SKIN_POTION = registerPotion("soft_skin_potion");

        registerPotionRecipes();
    }
    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.LOTION_INGOT,
                ModPotions.SOFT_SKIN_POTION);
    }

}
