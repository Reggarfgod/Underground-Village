package com.reggarf.mods.underground_village;

//? if fabric {
/*import com.reggarf.mods.underground_village.register.USRegistryAccess;
import com.reggarf.mods.underground_village.register.USStructurePlacements;
import com.reggarf.mods.underground_village.register.USStructureProcessorTypeAccessFabric;
import com.reggarf.mods.underground_village.register.USStructureTypeAccessFabric;
import com.reggarf.mods.underground_village.register.USStructuresFabric;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
//? if >=26.1 {
import net.minecraft.resources.Identifier;
//?} else {
/^import net.minecraft.resources.Identifier;
^///?}

public class Underground_village implements ModInitializer {

    @Override
    public void onInitialize() {
        USStructuresFabric.register();
        USRegistryAccess.STRUCTURES = new USStructureTypeAccessFabric();
        USRegistryAccess.PROCESSORS = new USStructureProcessorTypeAccessFabric();
        CommonClass.init();

        Registry.register(
                BuiltInRegistries.STRUCTURE_PLACEMENT,
                //? if >=26.1 {
                Identifier.fromNamespaceAndPath(Constants.MODID, "distance_based_structure_placement"),
                //?} elif >=1.21 {
                /^Identifier.fromNamespaceAndPath(Constants.MODID, "distance_based_structure_placement"),
                ^///?} else {
                /^new Identifier(Constants.MODID, "distance_based_structure_placement"),
                ^///?}
                USStructurePlacements.DISTANCE_BASED_STRUCTURE_PLACEMENT
        );
    }
}
*///?} elif neoforge {
import com.reggarf.mods.underground_village.register.StructurePlacements;
import com.reggarf.mods.underground_village.register.USRegistryAccess;
import com.reggarf.mods.underground_village.register.USStructureProcessorTypeAccessNeoForge;
import com.reggarf.mods.underground_village.register.USStructureTypeAccessNeoForge;
import com.reggarf.mods.underground_village.register.USStructuresNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MODID)
public class Underground_village {

    public Underground_village(IEventBus eventBus, ModContainer modContainer) {
        USStructuresNeoForge.STRUCTURES.register(eventBus);
        USStructuresNeoForge.PROCESSORS.register(eventBus);
        StructurePlacements.register(eventBus);
        USRegistryAccess.STRUCTURES = new USStructureTypeAccessNeoForge();
        USRegistryAccess.PROCESSORS = new USStructureProcessorTypeAccessNeoForge();
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();
    }
}
//?}
