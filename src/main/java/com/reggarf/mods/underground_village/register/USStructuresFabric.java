package com.reggarf.mods.underground_village.register;

//? if fabric {
/*import com.reggarf.mods.underground_village.structure.UndergroundStructure;
import com.reggarf.mods.underground_village.structure.UnderwaterStructures;
import com.reggarf.mods.underground_village.structure.processor.BiomePaletteProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
//? if >=26.1 {
import net.minecraft.resources.Identifier;
//?} else {
/^import net.minecraft.resources.Identifier;
^///?}
import net.minecraft.world.level.levelgen.structure.StructureType;
//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
//?}

import static com.reggarf.mods.underground_village.Constants.MODID;

public final class USStructuresFabric {

    public static StructureType<UndergroundStructure> UNDERGROUND_STRUCTURE;
    public static StructureType<UnderwaterStructures> UNDERWATER_STRUCTURES;
    //? if <26.3 {
    public static StructureProcessorType<BiomePaletteProcessor> BIOME_PALETTE;
    //?} else {
    /^public static com.mojang.serialization.MapCodec<BiomePaletteProcessor> BIOME_PALETTE;
    ^///?}

    public static void register() {
        UNDERGROUND_STRUCTURE = Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                //? if >=26.1 {
                Identifier.fromNamespaceAndPath(MODID, "underground_structures"),
                //?} elif >=1.21 {
                /^Identifier.fromNamespaceAndPath(MODID, "underground_structures"),
                ^///?} else {
                /^new Identifier(MODID, "underground_structures"),
                ^///?}
                () -> UndergroundStructure.CODEC
        );

        UNDERWATER_STRUCTURES = Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                //? if >=26.1 {
                Identifier.fromNamespaceAndPath(MODID, "underwater_structures"),
                //?} elif >=1.21 {
                /^Identifier.fromNamespaceAndPath(MODID, "underwater_structures"),
                ^///?} else {
                /^new Identifier(MODID, "underwater_structures"),
                ^///?}
                () -> UnderwaterStructures.CODEC
        );

        BIOME_PALETTE = Registry.register(
                BuiltInRegistries.STRUCTURE_PROCESSOR,
                //? if >=26.1 {
                Identifier.fromNamespaceAndPath(MODID, "biome_palette"),
                //?} elif >=1.21 {
                /^Identifier.fromNamespaceAndPath(MODID, "biome_palette"),
                ^///?} else {
                /^new Identifier(MODID, "biome_palette"),
                ^///?}
                USStructuresCommon.biomePalette()
        );
    }

    private USStructuresFabric() {}
}
*///?}
