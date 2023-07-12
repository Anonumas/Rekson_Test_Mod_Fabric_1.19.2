package net.anonumas.reksontestmod.item;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item UNREFINED_LOTION = registerItem("unrefined_lotion",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON).food(
                    new FoodComponent.Builder().hunger(1).saturationModifier(4f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1), 1f).build())));
    public static final Item LOTION_INGOT = registerItem("lotion_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.REKSON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ReksonTestMod.MOD_ID, name), item);
    }



    public static void resisterModItems() {
        ReksonTestMod.LOGGER.debug("Registering Mod Items for " + ReksonTestMod.MOD_ID);
    }
}
