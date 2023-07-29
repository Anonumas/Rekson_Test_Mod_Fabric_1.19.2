package net.anonumas.reksontestmod.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    //Creates Key Category
    public static final String KEY_CATEGORY_REKSON = "key.category.reksontestmod.rekson";

    public static final String KEY_PAY_RESPECTS = "key.reksontestmod.pay_respects";
    public static KeyBinding payRespectKey;
    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (payRespectKey.wasPressed()){
                client.player.sendChatMessage("f", null);


            }
        });
    }
    public static void register(){
        payRespectKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_PAY_RESPECTS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F,
                KEY_CATEGORY_REKSON
        ));
        registerKeyInputs();
    }


}
