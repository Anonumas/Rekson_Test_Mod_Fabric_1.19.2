package net.anonumas.reksontestmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModShoeItem extends Item {
    public ModShoeItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.literal("Eating This Shoe Doesn't Fulfill Promises Made to Eat a Shoe").formatted(Formatting.AQUA));
        }else{
            tooltip.add(Text.literal("Hold Shift For Disclaimer!").formatted(Formatting.GOLD));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
