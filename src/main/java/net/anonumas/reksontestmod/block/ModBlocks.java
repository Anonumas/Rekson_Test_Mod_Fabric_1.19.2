package net.anonumas.reksontestmod.block;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block COAGULATED_LOTION = registerBlock("coagulated_lotion",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.REKSON);
    public static final Block BLOCK_OF_LOTION = registerBlock("block_of_lotion",
            new Block(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.REKSON);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
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
