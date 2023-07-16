package net.anonumas.reksontestmod.item;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.item.custom.ReksonFaceItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item UNREFINED_LOTION = registerItem("unrefined_lotion",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).statusEffect(
                            new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1),
                            1f).build())));
    public static final Item LOTION_INGOT = registerItem("lotion_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON)));
    public static final Item FISH_SAUCE = registerItem("fish_sauce",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).recipeRemainder(Item.byRawId(374))));

    public static final Item REKSON_FACE = registerItem("rekson_face",
            new ReksonFaceItem(new FabricItemSettings().group(ModItemGroup.REKSON).fireproof().maxCount(1)));
    public static final Item FRUIT_SNACKS = registerItem("fruit_snacks",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).statusEffect(
                            new StatusEffectInstance(StatusEffects.SPEED, 100, 2),
                            0.5f).build())));
    public static final Item FRUIT_SNACK_SEEDS = registerItem("fruit_snack_seeds",
            new AliasedBlockItem(ModBlocks.FRUIT_SNACKS_CROP,
                    new FabricItemSettings().group(ModItemGroup.REKSON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ReksonTestMod.MOD_ID, name), item);
    }



    public static void resisterModItems() {
        ReksonTestMod.LOGGER.debug("Registering Mod Items for " + ReksonTestMod.MOD_ID);
    }
}
