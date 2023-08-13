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
    public static SoundEvent FILIAN_DISS = registerSoundEvent("filian_diss");
    public static SoundEvent TALENT_SHOW_DISS = registerSoundEvent("talent_show_diss");

    public static SoundEvent EREKSON_DYSFUNCTION = registerSoundEvent("erekson_dysfunction");
    public static SoundEvent REKGASM = registerSoundEvent("rekgasm");
    public static SoundEvent REKSON_ALWAYS_LICK = registerSoundEvent("rekson_always_lick");
    public static SoundEvent REKSON_APPRECIATES_TIPS = registerSoundEvent("rekson_appreciates_tips");
    public static SoundEvent REKSON_CANT_GET_IT_OUT = registerSoundEvent("rekson_cant_get_it_out");
    public static SoundEvent REKSON_HAGGLES_FOR_HEAD = registerSoundEvent("rekson_haggles_for_head");
    public static SoundEvent REKSON_HUMPS = registerSoundEvent("rekson_humps");
    public static SoundEvent REKSON_SHOVE_IT = registerSoundEvent("rekson_shove_it");
    public static SoundEvent REKSON_UNFAIR = registerSoundEvent("rekson_unfair");
    public static SoundEvent REKSON_VIBRATING_SWORD = registerSoundEvent("rekson_vibrating_sword");
    public static SoundEvent REKSON_DEATH = registerSoundEvent("rekson_death");
    public static SoundEvent REKSON_HURT = registerSoundEvent("rekson_hurt");


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(ReksonTestMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
