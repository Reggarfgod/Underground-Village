package com.reggarf.mods.underground_village.register;

//? if neoforge {
import com.reggarf.mods.underground_village.structure.UndergroundStructure;
import com.reggarf.mods.underground_village.structure.UnderwaterStructures;
import com.reggarf.mods.underground_village.structure.processor.BiomePaletteProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
//?}
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.reggarf.mods.underground_village.Constants.MODID;

public final class USStructuresNeoForge {

    public static final DeferredRegister<StructureType<?>> STRUCTURES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, MODID);

    //? if <26.3 {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, MODID);
    //?} else {
    /*public static final DeferredRegister<com.mojang.serialization.MapCodec<? extends net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor>> PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, MODID);
    *///?}

    public static final DeferredHolder<StructureType<?>, StructureType<UndergroundStructure>>
            UNDERGROUND_STRUCTURE =
            STRUCTURES.register(
                    "underground_structures",
                    () -> USStructuresCommon.underground()
            );

    public static final DeferredHolder<StructureType<?>, StructureType<UnderwaterStructures>>
            UNDERWATER_STRUCTURE =
            STRUCTURES.register(
                    "underwater_structures",
                    () -> USStructuresCommon.underwater()
            );

    //? if <26.3 {
    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<BiomePaletteProcessor>>
            BIOME_PALETTE =
            PROCESSORS.register(
                    "biome_palette",
                    () -> USStructuresCommon.biomePalette()
            );
    //?} else {
    /*public static final DeferredHolder<com.mojang.serialization.MapCodec<? extends net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor>, com.mojang.serialization.MapCodec<BiomePaletteProcessor>>
            BIOME_PALETTE =
            PROCESSORS.register(
                    "biome_palette",
                    () -> USStructuresCommon.biomePalette()
            );
    *///?}

    private USStructuresNeoForge() {}
}
//?}
