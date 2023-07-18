package net.anonumas.reksontestmod.villager;

import com.google.common.collect.ImmutableSet;
import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public  static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(ReksonTestMod.MOD_ID, name),1,1,
                ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,1),
                    new ItemStack(ModItems.CINNAMON_POWDER,16),
                    6,2,0.02f
            ));
                });
    }

    public static void registerVillagers(){
        ReksonTestMod.LOGGER.debug("Registering Villagers for " + ReksonTestMod.MOD_ID);
    }
}
