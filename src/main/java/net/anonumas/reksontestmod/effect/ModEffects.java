package net.anonumas.reksontestmod.effect;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.effect.custom.SoftSkinEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {

    public static StatusEffect SOFT_SKIN;

    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(ReksonTestMod.MOD_ID, name),
                new SoftSkinEffect(StatusEffectCategory.HARMFUL,0xffd899));
    }
    public static void registerEffects(){
        SOFT_SKIN = registerStatusEffect("soft_skin");
    }
}
