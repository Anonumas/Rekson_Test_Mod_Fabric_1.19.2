package net.anonumas.reksontestmod;

import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.entity.ModEntities;
import net.anonumas.reksontestmod.entity.client.ReksonRenderer;
import net.anonumas.reksontestmod.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class ReksonTestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRUIT_SNACKS_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REKSON_ONION_CROP, RenderLayer.getCutout());
        KeyInputHandler.register();

        EntityRendererRegistry.register(ModEntities.REKSON, ReksonRenderer::new);

    }
}
