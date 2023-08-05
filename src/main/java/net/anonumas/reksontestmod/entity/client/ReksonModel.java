package net.anonumas.reksontestmod.entity.client;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.entity.custom.ReksonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ReksonModel extends AnimatedGeoModel<ReksonEntity> {

    @Override
    public Identifier getModelResource(ReksonEntity object) {
        return new Identifier(ReksonTestMod.MOD_ID, "geo/rekson.geo.json");
    }

    @Override
    public Identifier getTextureResource(ReksonEntity object) {
        return new Identifier(ReksonTestMod.MOD_ID, "textures/entity/rekson_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ReksonEntity animatable) {
        return new Identifier(ReksonTestMod.MOD_ID, "animations/rekson.animation.json");
    }
}
