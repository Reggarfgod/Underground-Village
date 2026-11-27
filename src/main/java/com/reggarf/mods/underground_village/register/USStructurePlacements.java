package com.reggarf.mods.underground_village.register;

//? if <=1.20.1 {
/*import com.mojang.serialization.Codec;
*///?} else {
import com.mojang.serialization.MapCodec;
//?}
import com.reggarf.mods.underground_village.structureplacement.DistanceBasedStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
//? if >=26.3 {

/**///?} else {
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
//?}

public class USStructurePlacements {

    //? if >=26.3 {
    /*public static final MapCodec<DistanceBasedStructurePlacement>
            DISTANCE_BASED_STRUCTURE_PLACEMENT = DistanceBasedStructurePlacement.CODEC;
    *///?} else {
    public static final StructurePlacementType<DistanceBasedStructurePlacement>
            DISTANCE_BASED_STRUCTURE_PLACEMENT =
            explicitStructureTypeTyping(DistanceBasedStructurePlacement.CODEC);

    //? if <=1.20.1 {
    /*private static <T extends StructurePlacement>
    StructurePlacementType<T> explicitStructureTypeTyping(Codec<T> codec) {
        return () -> codec;
    }
    *///?} else {
    private static <T extends StructurePlacement>
    StructurePlacementType<T> explicitStructureTypeTyping(MapCodec<T> codec) {
        return () -> codec;
    }
    //?}
    //?}

    private USStructurePlacements() {}
}
