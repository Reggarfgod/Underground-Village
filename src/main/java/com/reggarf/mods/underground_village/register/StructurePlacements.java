package com.reggarf.mods.underground_village.register;

//? if neoforge {
import com.reggarf.mods.underground_village.Constants;
import net.minecraft.core.registries.Registries;
//? if >=26.3 {
/*import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
*///?} else {
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
//?}
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * NeoForge loader-only structure placement registration.
 * Common code must NEVER reference DeferredRegister.
 */
public class StructurePlacements {

    //? if >=26.3 {
    /*public static final DeferredRegister<MapCodec<? extends StructurePlacement>> STRUCTURE_PLACEMENTS =
            DeferredRegister.create(
                    Registries.STRUCTURE_PLACEMENT,
                    Constants.MODID
            );
    *///?} else {
    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENTS =
            DeferredRegister.create(
                    Registries.STRUCTURE_PLACEMENT,
                    Constants.MODID
            );
    //?}

    public static void register(IEventBus modBus) {

        STRUCTURE_PLACEMENTS.register(
                "distance_based_structure_placement",
                () -> USStructurePlacements.DISTANCE_BASED_STRUCTURE_PLACEMENT
        );

        STRUCTURE_PLACEMENTS.register(modBus);
    }
}
//?}
