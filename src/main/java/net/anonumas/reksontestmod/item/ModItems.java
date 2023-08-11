package net.anonumas.reksontestmod.item;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.entity.ModEntities;
import net.anonumas.reksontestmod.item.custom.*;
import net.anonumas.reksontestmod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item UNREFINED_LOTION = registerItem("unrefined_lotion",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).statusEffect(
                            new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1),
                            1f).build())));
    public static final Item SHOE = registerItem("shoe",
            new ModShoeItem(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(8).saturationModifier(1f).build())));
    public static final Item CASHEW = registerItem("cashew",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item SWEET_AND_SALTY_FRUIT_SNACKS = registerItem("sweet_and_salty_fruit_snacks",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(6).saturationModifier(1.0f).statusEffect(
                            new StatusEffectInstance(StatusEffects.SPEED, 200, 2),
                            1f).statusEffect(
                                    new StatusEffectInstance(StatusEffects.HASTE,200,2),1).statusEffect(
                                            new StatusEffectInstance(StatusEffects.REGENERATION,200,1),1
                    ).build())));
    public static final Item LOTION_INGOT = registerItem("lotion_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON)));


    public static final Item FISH_SAUCE = registerItem("fish_sauce",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).recipeRemainder(
                    Items.GLASS_BOTTLE)));
    public static final Item CINNAMON_POWDER = registerItem("cinnamon_powder",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON)));

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
    public static final Item REKSON_ONION = registerItem("rekson_onion",
            new AliasedBlockItem(ModBlocks.REKSON_ONION_CROP,
                    new FabricItemSettings().group(ModItemGroup.REKSON).food(
                            new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).build())));

    public static final Item LOTION_SWORD = registerItem("lotion_sword",
            new LotionSwordItem(ToolMaterials.IRON,2,-2.4f,
                    new FabricItemSettings().group(ModItemGroup.REKSON)));
    public static final Item LOTION_AXE = registerItem("lotion_axe",
            new LotionAxeItem(ToolMaterials.IRON,4,-3.0f,
                    new FabricItemSettings().group(ModItemGroup.REKSON)));
    public static final Item LOTION_PICKAXE = registerItem("lotion_pickaxe",
            new PickaxeItem(ToolMaterials.IRON,1,-2.8f,
                    new FabricItemSettings().group(ModItemGroup.REKSON)));
    public static final Item LOTION_HOE = registerItem("lotion_hoe",
            new ModHoeItem(ToolMaterials.IRON,-1,-1.0f,
                    new FabricItemSettings().group(ModItemGroup.REKSON)));
    public static final Item LOTION_SHOVEL = registerItem("lotion_shovel",
            new ShovelItem(ToolMaterials.IRON,2,-3.0f,
                    new FabricItemSettings().group(ModItemGroup.REKSON)));


    public static final Item DRUDGE_DISC = registerItem("drudge_disc",
            new ModMusicDiscItem(16, ModSounds.DRUDGE,
                    new FabricItemSettings().group(ModItemGroup.REKSON).maxCount(1).rarity(Rarity.RARE),
                    218));
    public static final Item WET_BRICK_DRY_BRICK_DISC = registerItem("wet_brick_dry_brick_disc",
            new ModMusicDiscItem(4, ModSounds.WET_BRICK_DRY_BRICK,
                    new FabricItemSettings().group(ModItemGroup.REKSON).maxCount(1).rarity(Rarity.RARE),242));
    public static final Item UKULELE_APOLOGY_DISC = registerItem("ukulele_apology_disc",
            new ModMusicDiscItem(4, ModSounds.UKULELE_APOLOGY,
                    new FabricItemSettings().group(ModItemGroup.REKSON).maxCount(1).rarity(Rarity.RARE),273));
    public static final Item LOLA_LOADING_DISS_DISC = registerItem("lola_loading_diss_disc",
            new ModMusicDiscItem(8, ModSounds.LOLA_LOADING_DISS,
                    new FabricItemSettings().group(ModItemGroup.REKSON).maxCount(1).rarity(Rarity.RARE).fireproof(),
                    232));

    public static final Item REKSON_SPAWN_EGG = registerItem("rekson_spawn_egg",
            new SpawnEggItem(ModEntities.REKSON,0xfab043, 0xfdd396,
                    new FabricItemSettings().group(ModItemGroup.REKSON).fireproof()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ReksonTestMod.MOD_ID, name), item);
    }



    public static void resisterModItems() {
        ReksonTestMod.LOGGER.debug("Registering Mod Items for " + ReksonTestMod.MOD_ID);
    }
}
