package net.anonumas.reksontestmod.fluid;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {

    public static FlowableFluid STILL_LOTION_FLUID;
    public static FlowableFluid FLOWING_LOTION_FLUID;
    public static Block LOTION_FLUID_BLOCK;
    public static Item LOTION_BUCKET;

    public static void register() {
        STILL_LOTION_FLUID = Registry.register(Registry.FLUID,
                new Identifier(ReksonTestMod.MOD_ID, "lotion"), new LotionFluid.Still());
        FLOWING_LOTION_FLUID = Registry.register(Registry.FLUID,
                new Identifier(ReksonTestMod.MOD_ID, "flowing_lotion"), new LotionFluid.Flowing());

        LOTION_FLUID_BLOCK = Registry.register(Registry.BLOCK, new Identifier(ReksonTestMod.MOD_ID, "lotion_fluid_block"),
                new FluidBlock(ModFluids.STILL_LOTION_FLUID, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        LOTION_BUCKET = Registry.register(Registry.ITEM, new Identifier(ReksonTestMod.MOD_ID, "lotion_bucket"),
                new BucketItem(ModFluids.STILL_LOTION_FLUID, new FabricItemSettings().group(ModItemGroup.REKSON).recipeRemainder(Items.BUCKET).maxCount(1)));
    }

}
