package com.reggarf.mods.underground_village.register;

//? if <=1.20.1 {
/*import com.mojang.serialization.Codec;
*///?} else {
import com.mojang.serialization.MapCodec;
//?}
import com.reggarf.mods.underground_village.structure.UndergroundStructure;
import com.reggarf.mods.underground_village.structure.UnderwaterStructures;
import com.reggarf.mods.underground_village.structure.processor.BiomePaletteProcessor;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
//?}

public final class USStructuresCommon {

    //? if <=1.20.1 {
    /*private static <T extends Structure> StructureType<T> create(Codec<T> codec) {
        return () -> codec;
    }

    private static <T extends StructureProcessor> StructureProcessorType<T> createProcessor(Codec<T> codec) {
        return () -> codec;
    }
    *///?} elif <26.3 {
    private static <T extends Structure> StructureType<T> create(MapCodec<T> codec) {
        return () -> codec;
    }

    private static <T extends StructureProcessor> StructureProcessorType<T> createProcessor(MapCodec<T> codec) {
        return () -> codec;
    }
    //?} else {
    /*private static <T extends Structure> StructureType<T> create(MapCodec<T> codec) {
        return () -> codec;
    }
    *///?}

    public static StructureType<UndergroundStructure> underground() {
        return create(UndergroundStructure.CODEC);
    }

    public static StructureType<UnderwaterStructures> underwater() {
        return create(UnderwaterStructures.CODEC);
    }

    //? if <26.3 {
    public static StructureProcessorType<BiomePaletteProcessor> biomePalette() {
        return createProcessor(BiomePaletteProcessor.CODEC);
    }
    //?} else {
    /*public static MapCodec<BiomePaletteProcessor> biomePalette() {
        return BiomePaletteProcessor.CODEC;
    }
    *///?}

    private USStructuresCommon() {}
}
