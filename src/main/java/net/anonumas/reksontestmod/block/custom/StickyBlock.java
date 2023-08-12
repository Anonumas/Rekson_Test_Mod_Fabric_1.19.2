package net.anonumas.reksontestmod.block.custom;

import net.anonumas.reksontestmod.block.ModBlocks;
import net.anonumas.reksontestmod.entity.ModEntities;
import net.anonumas.reksontestmod.entity.custom.ReksonEntity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.MaterialPredicate;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class StickyBlock extends Block {
    public StickyBlock(Settings settings) {
        super(settings);
    }
    @Nullable
    private BlockPattern reksonPattern;
    private static final Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE = state -> state != null && (state.isOf(ModBlocks.COAGULATED_LOTION));
//code from CarvedPumpkinBlock.java


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && hand == Hand.MAIN_HAND){
            player.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.MINING_FATIGUE,100,2,true,false)
            );

        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.SLOWNESS, 4, 3,true,false));

        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.isOf(state.getBlock())) {
            return;
        }
        this.trySpawnEntity(world, pos);
    }

    private void trySpawnEntity(World world, BlockPos pos) {
        block9:
        {
            BlockPattern.Result result;
            block8:
            {
                result = this.getReksonPattern().searchAround(world, pos);
                if (result == null) break block8;
                for (int i = 0; i < this.getReksonPattern().getWidth(); ++i) {
                    for (int k = 0; k < this.getReksonPattern().getHeight(); ++k) {
                        CachedBlockPosition cachedBlockPosition3 = result.translate(i, k, 0);
                        world.setBlockState(cachedBlockPosition3.getBlockPos(), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                        world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, cachedBlockPosition3.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition3.getBlockState()));
                    }
                }
                ReksonEntity reksonEntity = ModEntities.REKSON.create(world);
                BlockPos blockPos = result.translate(0, 2, 0).getBlockPos();
                reksonEntity.refreshPositionAndAngles((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.05, (double) blockPos.getZ() + 0.5, 0.0f, 0.0f);
                world.spawnEntity(reksonEntity);
                for (ServerPlayerEntity serverPlayerEntity : world.getNonSpectatingEntities(ServerPlayerEntity.class, reksonEntity.getBoundingBox().expand(5.0))) {
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, reksonEntity);
                }
                for (int j = 0; j < this.getReksonPattern().getHeight(); ++j) {
                    CachedBlockPosition cachedBlockPosition2 = result.translate(0, j, 0);
                    world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
                }
                break block9;
            }


        }
    }


    private BlockPattern getReksonPattern() {
        if (this.reksonPattern == null) {
            this.reksonPattern = BlockPatternBuilder.start().aisle("^^^", "###", "#~#").where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.COPPER_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }
        return this.reksonPattern;
    }

}
