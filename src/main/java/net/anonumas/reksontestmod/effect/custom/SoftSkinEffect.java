package net.anonumas.reksontestmod.effect.custom;

import net.anonumas.reksontestmod.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;

public class SoftSkinEffect extends StatusEffect {
    public SoftSkinEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);

    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (this == ModEffects.SOFT_SKIN) {
            ((PlayerEntity) entity).increaseStat(Stats.DAMAGE_RESISTED, Math.round(amplifier * -10f));
        }




        }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    }
}

