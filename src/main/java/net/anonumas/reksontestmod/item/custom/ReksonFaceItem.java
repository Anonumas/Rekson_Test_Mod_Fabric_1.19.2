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
            case 0: sendMessagetoPlayer("That's right, I'll stroke you once before I kill you", player); break;
            case 1: sendMessagetoPlayer("Hydrate? Frick!", player); break;
            case 2: sendMessagetoPlayer("Oh, okay you just fisted me.  Okay, that's fine if you fist me.", player); break;
            case 3: sendMessagetoPlayer("If you can't coom on me what's the point", player); break;
            case 4: sendMessagetoPlayer("https://www.twitch.tv/reksongames", player); break;
            case 5: sendMessagetoPlayer("That's enough balls, alright?", player); break;
            case 6: sendMessagetoPlayer("I am inside myself.", player); break;
            case 7: sendMessagetoPlayer("It doesn't matter if he's sad, right? It matters that we fucked him.", player); break;
            case 8: sendMessagetoPlayer("I'm about to get fisted.", player); break;
            case 9: sendMessagetoPlayer("This stick is a little lopsided, that's okay!", player); break;
            case 10: sendMessagetoPlayer("I didn't eat any of his balls yet.", player); break;
        }
    }
    private static void sendMessagetoPlayer(String x, PlayerEntity player){
        player.sendMessage(Text.literal(x));
    }
    private int getRandomNumber(){
        return Random.createLocal().nextInt(11);
    }
}
