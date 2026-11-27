package com.reggarf.mods.underground_village.register;

//? if <26.3 {
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public interface USStructureProcessorTypeAccess {

    StructureProcessorType<?> biomePalette();
}
//?} else {
/*import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public interface USStructureProcessorTypeAccess {

    MapCodec<? extends StructureProcessor> biomePalette();
}
*///?}
