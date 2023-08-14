package net.anonumas.reksontestmod.block.custom;

import net.anonumas.reksontestmod.fluid.ModFluids;
import net.anonumas.reksontestmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LotionBottleBlock extends HorizontalFacingBlock {
    public LotionBottleBlock(Settings settings) {
        super(settings);
    }


    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;



    private static final VoxelShape SHAPEN = Block.createCuboidShape(5,0,5,11,15,10);
    private static final VoxelShape SHAPEW = Block.createCuboidShape(5,0,5,10,15,11);
    private static final VoxelShape SHAPES = Block.createCuboidShape(5,0,6,11,15,11);
    private static final VoxelShape SHAPEE = Block.createCuboidShape(6,0,5,11,15,11);



    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> SHAPEN;
            case EAST -> SHAPEE;
            case WEST -> SHAPEW;
            case SOUTH -> SHAPES;
            default -> SHAPEN;
        };
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient && hand == Hand.MAIN_HAND){
            ItemStack itemStack = player.getStackInHand(hand);

            if(itemStack.isOf(Items.BUCKET)){
                ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModFluids.LOTION_BUCKET.getDefaultStack());
                player.setStackInHand(hand, itemStack2);
                return ActionResult.SUCCESS;
            }

            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }



}
