package net.sam.mccourse.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sam.mccourse.MCCourseMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCCourseMod.MOD_ID);


    public static RegistryObject<SoundEvent> VAR_BLOCK_BREAK = registerSoundEvents("var_block_break");
    public static RegistryObject<SoundEvent> VAR_BLOCK_STEP = registerSoundEvents("var_block_step");
    public static RegistryObject<SoundEvent> VAR_BLOCK_PLACE = registerSoundEvents("var_block_place");
    public static RegistryObject<SoundEvent> VAR_BLOCK_HIT = registerSoundEvents("var_block_hit");
    public static RegistryObject<SoundEvent> VAR_BLOCK_FALL = registerSoundEvents("var_block_fall");


    public static final ForgeSoundType VAR_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.VAR_BLOCK_BREAK, ModSounds.VAR_BLOCK_STEP, ModSounds.VAR_BLOCK_PLACE,
            ModSounds.VAR_BLOCK_HIT, ModSounds.VAR_BLOCK_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(MCCourseMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
