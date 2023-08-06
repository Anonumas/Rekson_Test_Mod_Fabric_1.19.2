package net.anonumas.reksontestmod.mixin;

import net.anonumas.reksontestmod.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {


    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow
    @Nullable
    public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);

    // Got Code from LadySnake and Doctorat's Pick Your Poison mod
    // I couldn't find any other way and still needed to change the code to make it work for this

    @ModifyVariable(method = "damage", at = @At("HEAD"))
    private float multiplyDamageForSoftSkin(float amount) {
        if (this.hasStatusEffect(ModEffects.SOFT_SKIN)) {
            return amount + (amount * (0.125f * (this.getStatusEffect(ModEffects.SOFT_SKIN).getAmplifier() + 1)));
        }
        return amount;
    }

}
