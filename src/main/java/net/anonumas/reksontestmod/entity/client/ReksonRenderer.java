package net.anonumas.reksontestmod.entity.client;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.entity.custom.ReksonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ReksonRenderer extends GeoEntityRenderer<ReksonEntity> {
    public ReksonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ReksonModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureResource(ReksonEntity animatable) {
        return new Identifier(ReksonTestMod.MOD_ID, "textures/entity/rekson_texture.png");
    }

    @Override
    public RenderLayer getRenderType(ReksonEntity animatable, float partialTick, MatrixStack poseStack,
                                     VertexConsumerProvider bufferSource, VertexConsumer buffer, int packedLight,
                                     Identifier texture) {

        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
