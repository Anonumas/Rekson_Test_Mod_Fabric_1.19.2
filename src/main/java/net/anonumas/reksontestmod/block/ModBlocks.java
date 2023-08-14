package net.anonumas.reksontestmod.block;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.block.custom.*;
import net.anonumas.reksontestmod.item.ModItemGroup;
import net.anonumas.reksontestmod.world.feature.tree.CashewTreeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block COAGULATED_LOTION = registerBlock("coagulated_lotion",
            new StickyBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.REKSON);
    public static final Block CASHEW_LEAVES = registerBlock("cashew_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroup.REKSON);
    public static final Block CASHEWLESS_LEAVES = registerBlock("cashewless_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroup.REKSON);
    public static final Block CASHEW_TREE_SAPLING = registerBlock("cashew_tree_sapling",
            new SaplingBlock(new CashewTreeSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroup.REKSON);
    public static final Block BLOCK_OF_LOTION = registerBlock("block_of_lotion",
            new Block(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.REKSON);
    public static final Block REKSON_STATUE = registerBlock("rekson_statue",
            new ReksonStatueBlock(FabricBlockSettings.of(Material.METAL).strength(1f)
                    .nonOpaque().luminance(state -> 3)),
            ModItemGroup.REKSON);
    public static final Block LOTION_BOTTLE = registerBlock("lotion_bottle",
            new LotionBottleBlock(FabricBlockSettings.of(Material.METAL).strength(1f)
                    .nonOpaque().luminance(state -> 3)),
            ModItemGroup.REKSON);
    public static final Block FRUIT_SNACKS_CROP = registerBlockWithoutItem("fruit_snacks_crop",
            new FruitSnacksCrop(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block REKSON_ONION_CROP = registerBlockWithoutItem("rekson_onion_crop",
            new ReksonOnionCrop(FabricBlockSettings.copy(Blocks.POTATOES)));

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(ReksonTestMod.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(ReksonTestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(ReksonTestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }





    public static void resisterModBlocks() {
        ReksonTestMod.LOGGER.debug("Registering Mod Blocks for " + ReksonTestMod.MOD_ID);
    }
}
