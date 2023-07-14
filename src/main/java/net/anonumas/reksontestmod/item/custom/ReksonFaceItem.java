package net.anonumas.reksontestmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReksonFaceItem extends Item {

    public ReksonFaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && hand == Hand.MAIN_HAND){
            //outputs a random message
            outputRandomNumber(user);
            //makes it so this can't be spammed
            user.getItemCooldownManager().set(this, 20);

        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.literal("This is the head of Rekson").formatted(Formatting.DARK_RED, Formatting.BOLD));
        }else{
            tooltip.add(Text.literal("Hold Shift For More Info!").formatted(Formatting.GOLD));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputRandomNumber(PlayerEntity player){

        switch(getRandomNumber()){
            case 0: player.sendMessage(Text.literal("That's right, I'll stroke you once before I kill you")); break;
            case 1: player.sendMessage(Text.literal("Hydrate? Frick!")); break;
            case 2: player.sendMessage(Text.literal("Oh, okay you just fisted me.  Okay, that's fine if you fist me.")); break;
            case 3: player.sendMessage(Text.literal("If you can't coom on me what's the point")); break;
            case 4: player.sendMessage(Text.literal("https://www.twitch.tv/reksongames")); break;
            case 5: player.sendMessage(Text.literal("That's enough balls, alright?")); break;
            case 6: player.sendMessage(Text.literal("I am inside myself.")); break;
            case 7: player.sendMessage(Text.literal("It doesn't matter if he's sad, right? It matters that we fucked him.")); break;
            case 8: player.sendMessage(Text.literal("I'm about to get fisted.")); break;
            case 9: player.sendMessage(Text.literal("This stick is a little lopsided, that's okay!")); break;
            case 10: player.sendMessage(Text.literal("I didn't eat any of his balls yet.")); break;
        }
    }
    private int getRandomNumber(){
        return Random.createLocal().nextInt(11);
    }
}