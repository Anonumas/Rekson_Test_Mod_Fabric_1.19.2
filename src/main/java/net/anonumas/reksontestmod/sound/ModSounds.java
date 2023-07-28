package net.anonumas.reksontestmod.sound;

import net.anonumas.reksontestmod.ReksonTestMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    public static SoundEvent DRUDGE = registerSoundEvent("drudge");
    public static SoundEvent WET_BRICK_DRY_BRICK = registerSoundEvent("wet_brick_dry_brick");
    public static SoundEvent UKULELE_APOLOGY = registerSoundEvent("ukulele_apology");
    public static SoundEvent LOLA_LOADING_DISS = registerSoundEvent("lola_loading_diss");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(ReksonTestMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
