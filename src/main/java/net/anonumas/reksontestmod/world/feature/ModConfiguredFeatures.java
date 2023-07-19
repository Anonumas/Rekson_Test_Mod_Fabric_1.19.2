package net.anonumas.reksontestmod.world.feature;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_COAGULATED_LOTION = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.COAGULATED_LOTION.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.COAGULATED_LOTION.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> COAGULATED_LOTION =
            ConfiguredFeatures.register("coagulated_lotion", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_COAGULATED_LOTION, 6));


    public static void  registerConfiguredFeatures(){
        ReksonTestMod.LOGGER.debug("Registering the Config Features for " + ReksonTestMod.MOD_ID);
    }
}
