package com.reggarf.mods.underground_village.register;

//? if fabric {
/*//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class USStructureProcessorTypeAccessFabric implements USStructureProcessorTypeAccess {

    @Override
    public StructureProcessorType<?> biomePalette() {
        return USStructuresFabric.BIOME_PALETTE;
    }
}
//?} else {
/^import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public class USStructureProcessorTypeAccessFabric implements USStructureProcessorTypeAccess {

    @Override
    public MapCodec<? extends StructureProcessor> biomePalette() {
        return USStructuresFabric.BIOME_PALETTE;
    }
}
^///?}
*///?}
