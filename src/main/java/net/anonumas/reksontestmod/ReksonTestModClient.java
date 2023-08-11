package net.anonumas.reksontestmod;

import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.entity.ModEntities;
import net.anonumas.reksontestmod.entity.client.ReksonRenderer;
import net.anonumas.reksontestmod.event.KeyInputHandler;
import net.anonumas.reksontestmod.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class ReksonTestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRUIT_SNACKS_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REKSON_ONION_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CASHEW_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CASHEWLESS_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CASHEW_TREE_SAPLING, RenderLayer.getCutout());
        KeyInputHandler.register();

        EntityRendererRegistry.register(ModEntities.REKSON, ReksonRenderer::new);
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LOTION_FLUID, ModFluids.FLOWING_LOTION_FLUID,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA0f4e7d6
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_LOTION_FLUID, ModFluids.FLOWING_LOTION_FLUID);


    }
}
