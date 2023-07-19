package net.anonumas.reksontestmod.world.gen;

import net.anonumas.reksontestmod.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void  GenerateOres (){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.COAGULATED_LOTION_PLACED.getKey().get());
    }
}
