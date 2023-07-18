package net.anonumas.reksontestmod;

import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.item.ModItems;
import net.anonumas.reksontestmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReksonTestMod implements ModInitializer {

	public static final String MOD_ID = "reksontestmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.resisterModItems();
		ModBlocks.resisterModBlocks();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

	}
}
