package net.anonumas.reksontestmod;

import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.effect.ModEffects;
import net.anonumas.reksontestmod.entity.ModEntities;
import net.anonumas.reksontestmod.entity.custom.ReksonEntity;
import net.anonumas.reksontestmod.item.ModItems;
import net.anonumas.reksontestmod.util.ModLootTableModifiers;
import net.anonumas.reksontestmod.villager.ModVillagers;
import net.anonumas.reksontestmod.world.feature.ModConfiguredFeatures;
import net.anonumas.reksontestmod.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class ReksonTestMod implements ModInitializer {

	public static final String MOD_ID = "reksontestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.resisterModItems();
		ModBlocks.resisterModBlocks();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();
		ModOreGeneration.GenerateOres();
		ModLootTableModifiers.modifyLootTables();
		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.REKSON, ReksonEntity.setAttributes());
		ModEffects.registerEffects();

	}
}
