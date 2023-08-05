package net.anonumas.reksontestmod.entity;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.anonumas.reksontestmod.entity.custom.ReksonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<ReksonEntity> REKSON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(ReksonTestMod.MOD_ID,"rekson"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, ReksonEntity::new).fireImmune()
                    .dimensions(EntityDimensions.fixed(1.1f,1.0f)).build()
    );
}
