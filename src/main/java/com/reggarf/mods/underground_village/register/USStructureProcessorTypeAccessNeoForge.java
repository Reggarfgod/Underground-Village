package com.reggarf.mods.underground_village.register;

//? if neoforge {
//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class USStructureProcessorTypeAccessNeoForge implements USStructureProcessorTypeAccess {

    @Override
    public StructureProcessorType<?> biomePalette() {
        return USStructuresNeoForge.BIOME_PALETTE.get();
    }
}
//?} else {
/*import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public class USStructureProcessorTypeAccessNeoForge implements USStructureProcessorTypeAccess {

    @Override
    public MapCodec<? extends StructureProcessor> biomePalette() {
        return USStructuresNeoForge.BIOME_PALETTE.get();
    }
}
*///?}
//?}
