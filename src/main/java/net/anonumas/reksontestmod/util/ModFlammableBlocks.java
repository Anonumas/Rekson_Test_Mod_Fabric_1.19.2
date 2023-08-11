package net.anonumas.reksontestmod.util;

import net.anonumas.reksontestmod.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.CASHEWLESS_LEAVES, 30, 60);
        registry.add(ModBlocks.CASHEW_LEAVES, 30, 60);

    }
}
