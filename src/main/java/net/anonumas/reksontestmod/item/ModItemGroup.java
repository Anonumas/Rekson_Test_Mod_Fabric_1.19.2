package net.anonumas.reksontestmod.item;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup REKSON = FabricItemGroupBuilder.build(
            new Identifier(ReksonTestMod.MOD_ID, "rekson"), () -> new ItemStack(ModItems.UNREFINED_LOTION));
}
