package com.reggarf.mods.underground_village.structure.processor;

//? if <=1.20.1 {
/*import com.mojang.serialization.Codec;
*///?} else {
import com.mojang.serialization.MapCodec;
//?}
import com.reggarf.mods.underground_village.CommonClass;
import com.reggarf.mods.underground_village.biome.BiomePalette;
import com.reggarf.mods.underground_village.biome.BiomePaletteCache;
import com.reggarf.mods.underground_village.register.USRegistryAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
//?}
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

//? if <26.3 {
public class BiomePaletteProcessor extends StructureProcessor {
//?} else {
/*public class BiomePaletteProcessor implements StructureProcessor {
*///?}

    public static final BiomePaletteProcessor INSTANCE = new BiomePaletteProcessor();

    //? if <=1.20.1 {
    /*public static final Codec<BiomePaletteProcessor> CODEC = Codec.unit(INSTANCE);
    *///?} else {
    public static final MapCodec<BiomePaletteProcessor> CODEC = MapCodec.unit(() -> INSTANCE);
    //?}

    public BiomePaletteProcessor() {}

    //? if <26.3 {
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(
            LevelReader level,
            BlockPos templatePos,
            BlockPos pivotPos,
            StructureTemplate.StructureBlockInfo originalBlockInfo,
            StructureTemplate.StructureBlockInfo transformedBlockInfo,
            StructurePlaceSettings settings
    ) {
        if (!CommonClass.CONFIG.enableBiomePalettes.get()) {
            return transformedBlockInfo;
        }

        BiomePalette palette = BiomePaletteCache.getPalette(level, transformedBlockInfo.pos());
        BlockState originalState = transformedBlockInfo.state();
        BlockState newState = palette.transform(originalState, level, transformedBlockInfo.pos());

        if (newState == originalState) {
            return transformedBlockInfo;
        }

        return new StructureTemplate.StructureBlockInfo(
                transformedBlockInfo.pos(),
                newState,
                transformedBlockInfo.nbt()
        );
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return USRegistryAccess.PROCESSORS.biomePalette();
    }
    //?} else {
    /*@Override
    public StructureTemplate.StructureBlockInfo processBlock(
            LevelReader level,
            BlockPos targetPosition,
            BlockPos referencePos,
            BlockPos templateRelativePos,
            StructureTemplate.StructureBlockInfo processedBlockInfo,
            StructurePlaceSettings settings
    ) {
        if (!CommonClass.CONFIG.enableBiomePalettes.get()) {
            return processedBlockInfo;
        }

        BiomePalette palette = BiomePaletteCache.getPalette(level, processedBlockInfo.pos());
        BlockState originalState = processedBlockInfo.state();
        BlockState newState = palette.transform(originalState, level, processedBlockInfo.pos());

        if (newState == originalState) {
            return processedBlockInfo;
        }

        return new StructureTemplate.StructureBlockInfo(
                processedBlockInfo.pos(),
                newState,
                processedBlockInfo.nbt()
        );
    }

    @Override
    public MapCodec<? extends StructureProcessor> codec() {
        return CODEC;
    }
    *///?}
}
