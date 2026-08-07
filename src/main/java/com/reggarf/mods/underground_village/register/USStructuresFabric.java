package com.reggarf.mods.underground_village.register;

//? if fabric {
/*import com.reggarf.mods.underground_village.structure.UndergroundStructure;
import com.reggarf.mods.underground_village.structure.UnderwaterStructures;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
//? if >=26.1 {
import net.minecraft.resources.Identifier;
//?} else {
/^import net.minecraft.resources.ResourceLocation;^/
//?}
import net.minecraft.world.level.levelgen.structure.StructureType;

import static com.reggarf.mods.underground_village.Constants.MODID;

public final class USStructuresFabric {

    public static StructureType<UndergroundStructure> UNDERGROUND_STRUCTURE;
    public static StructureType<UnderwaterStructures> UNDERWATER_STRUCTURES;

    public static void register() {
        UNDERGROUND_STRUCTURE = Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                //? if >=26.1 {
                Identifier.fromNamespaceAndPath(MODID, "underground_structures"),
                //?} elif >=1.21 {
                /^ResourceLocation.fromNamespaceAndPath(MODID, "underground_structures"),^/
                //?} else {
                /^new ResourceLocation(MODID, "underground_structures"),^/
                //?}
                () -> UndergroundStructure.CODEC
        );

        UNDERWATER_STRUCTURES = Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                //? if >=26.1 {
                Identifier.fromNamespaceAndPath(MODID, "underwater_structures"),
                //?} elif >=1.21 {
                /^ResourceLocation.fromNamespaceAndPath(MODID, "underwater_structures"),^/
                //?} else {
                /^new ResourceLocation(MODID, "underwater_structures"),^/
                //?}
                () -> UnderwaterStructures.CODEC
        );
    }

    private USStructuresFabric() {}
}
*///?}
