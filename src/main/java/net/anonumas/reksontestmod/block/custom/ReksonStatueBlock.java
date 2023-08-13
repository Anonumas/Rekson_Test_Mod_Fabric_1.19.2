package net.anonumas.reksontestmod.block.custom;

import net.anonumas.reksontestmod.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
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

public class ReksonStatueBlock extends HorizontalFacingBlock {
    public ReksonStatueBlock(Settings settings) {
        super(settings); setDefaultState(getDefaultState().with(soundNumber,0));
    }
    public static IntProperty soundNumber = IntProperty.of("soundnumber",0,9);

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;



    private static final VoxelShape SHAPEN = Block.createCuboidShape(6,0,3,10,12,14);
    private static final VoxelShape SHAPEW = Block.createCuboidShape(3,0,6,14,12,10);
    private static final VoxelShape SHAPES = Block.createCuboidShape(6,0,2,10,12,13);
    private static final VoxelShape SHAPEE = Block.createCuboidShape(2,0,6,13,12,10);



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
        builder.add(FACING, soundNumber);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient && hand == Hand.MAIN_HAND){
            outputRandomSound(player, world.getBlockState(pos), world, pos);
            return ActionResult.SUCCESS;
        }
        state = (BlockState)state.cycle(soundNumber);
        world.setBlockState(pos, state, Block.NOTIFY_ALL);

        return super.onUse(state, world, pos, player, hand, hit);
    }


//Needs Blockstate state to function
    private void outputRandomSound(PlayerEntity player, BlockState state, World world, BlockPos pos){

        switch (world.getBlockState(pos).get(soundNumber)) {
            case 0 -> playSoundandSetState(player,0);
            case 1 -> playSoundandSetState(player,1);
            case 2 -> playSoundandSetState(player,2);
            case 3 -> playSoundandSetState(player,3);
            case 4 -> playSoundandSetState(player,4);
            case 5 -> playSoundandSetState(player,5);
            case 6 -> playSoundandSetState(player,6);
            case 7 -> playSoundandSetState(player,7);
            case 8 -> playSoundandSetState(player,8);
            case 9 -> playSoundandSetState(player,9);
        }
    }
    public static void playSoundandSetState(PlayerEntity player, int x){
        if (x == 0){
            player.playSound(ModSounds.REKGASM, 1f, 1f);
        } else if (x == 1) {
            player.playSound(ModSounds.EREKSON_DYSFUNCTION, 1f, 1f);
        } else if (x == 2) {
            player.playSound(ModSounds.REKSON_ALWAYS_LICK, 1f, 1f);
        } else if (x == 3) {
            player.playSound(ModSounds.REKSON_APPRECIATES_TIPS, 1f, 1f);
        } else if (x == 4) {
            player.playSound(ModSounds.REKSON_HUMPS, 1f, 1f);
        } else if (x == 5) {
            player.playSound(ModSounds.REKSON_UNFAIR, 1f, 1f);
        } else if (x == 6) {
            player.playSound(ModSounds.REKSON_VIBRATING_SWORD, 1f, 1f);
        } else if (x == 7) {
            player.playSound(ModSounds.REKSON_HAGGLES_FOR_HEAD, 1f, 1f);
        } else if (x == 8) {
            player.playSound(ModSounds.REKSON_CANT_GET_IT_OUT, 1f, 1f);
        } else if (x == 9) {
            player.playSound(ModSounds.REKSON_SHOVE_IT, 1f, 1f);
            }

    }
    //Random functionality for outputRandomSound Import Minecraft's Random to Use
    /*
    private void outputRandomSound(PlayerEntity player){

        switch (getRandomNumber()) {
            case 0 -> player.playSound(ModSounds.REKGASM, 1f, 1f);
            case 1 -> player.playSound(ModSounds.EREKSON_DYSFUNCTION, 1f, 1f);
            case 2 -> player.playSound(ModSounds.REKSON_ALWAYS_LICK, 1f, 1f);
            case 3 -> player.playSound(ModSounds.REKSON_APPRECIATES_TIPS, 1f, 1f);
            case 4 -> player.playSound(ModSounds.REKSON_HUMPS, 1f, 1f);
            case 5 -> player.playSound(ModSounds.REKSON_UNFAIR, 1f, 1f);
            case 6 -> player.playSound(ModSounds.REKSON_SHOVE_IT, 1f, 1f);
            case 7 -> player.playSound(ModSounds.REKSON_VIBRATING_SWORD, 1f, 1f);
            case 8 -> player.playSound(ModSounds.REKSON_HAGGLES_FOR_HEAD, 1f, 1f);
            case 9 -> player.playSound(ModSounds.REKSON_CANT_GET_IT_OUT, 1f, 1f);
        }
    }


    private int getRandomNumber(){
        return Random.createLocal().nextInt(10);
    }
*/
}
