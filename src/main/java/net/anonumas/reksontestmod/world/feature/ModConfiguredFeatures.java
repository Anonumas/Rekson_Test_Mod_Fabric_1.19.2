package net.anonumas.reksontestmod.world.feature;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_COAGULATED_LOTION = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.COAGULATED_LOTION.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.COAGULATED_LOTION.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> COAGULATED_LOTION =
            ConfiguredFeatures.register("coagulated_lotion", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_COAGULATED_LOTION, 6));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CASHEW_TREE =
            ConfiguredFeatures.register("cashew_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.OAK_LOG),
                    new StraightTrunkPlacer(4, 3, 2),
                    new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                            .add(ModBlocks.CASHEW_LEAVES.getDefaultState(), 1)
                            .add(ModBlocks.CASHEWLESS_LEAVES.getDefaultState(), 3).build()),

                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final RegistryEntry<PlacedFeature> CASHEW_CHECKED = PlacedFeatures.register("dogwood_checked",
            ModConfiguredFeatures.CASHEW_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.CASHEW_TREE_SAPLING)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CASHEW_SPAWN =
            ConfiguredFeatures.register("cashew_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CASHEW_CHECKED, 0.5f)),
                            CASHEW_CHECKED));






    public static void  registerConfiguredFeatures(){
        ReksonTestMod.LOGGER.debug("Registering the Config Features for " + ReksonTestMod.MOD_ID);
    }
}
