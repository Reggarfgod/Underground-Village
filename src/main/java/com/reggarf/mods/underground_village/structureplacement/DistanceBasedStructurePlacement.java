package com.reggarf.mods.underground_village.structureplacement;

import com.mojang.serialization.Codec;
//? if >1.20.1 {
import com.mojang.serialization.MapCodec;
//?}
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.reggarf.mods.underground_village.CommonClass;
import com.reggarf.mods.underground_village.register.USStructurePlacements;
import net.minecraft.core.Vec3i;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
//? if >=26.3 {
/*import net.minecraft.world.level.levelgen.structure.placement.AbstractSpreadingStructurePlacement;
*///?} else {
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
//?}

import java.util.Optional;

public class DistanceBasedStructurePlacement extends RandomSpreadStructurePlacement {

    //? if <=1.20.1 {
    /*public static final Codec<DistanceBasedStructurePlacement> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Vec3i.offsetCodec(16)
                            .optionalFieldOf("locate_offset", Vec3i.ZERO)
                            .forGetter(DistanceBasedStructurePlacement::locateOffset),

                    StructurePlacement.FrequencyReductionMethod.CODEC
                            .optionalFieldOf("frequency_reduction_method",
                                    StructurePlacement.FrequencyReductionMethod.DEFAULT)
                            .forGetter(DistanceBasedStructurePlacement::frequencyReductionMethod),

                    Codec.floatRange(0.0F, 1.0F)
                            .optionalFieldOf("frequency", 1.0F)
                            .forGetter(DistanceBasedStructurePlacement::frequency),

                    ExtraCodecs.NON_NEGATIVE_INT
                            .fieldOf("salt")
                            .forGetter(DistanceBasedStructurePlacement::salt),

                    StructurePlacement.ExclusionZone.CODEC
                            .optionalFieldOf("exclusion_zone")
                            .forGetter(DistanceBasedStructurePlacement::exclusionZone),

                    // Accepted from JSON but IGNORED (config used instead)
                    Codec.intRange(0, Integer.MAX_VALUE)
                            .fieldOf("spacing")
                            .forGetter(p -> 0),

                    // Accepted from JSON but IGNORED (config used instead)
                    Codec.intRange(0, Integer.MAX_VALUE)
                            .fieldOf("separation")
                            .forGetter(p -> 0),

                    RandomSpreadType.CODEC
                            .optionalFieldOf("spread_type", RandomSpreadType.LINEAR)
                            .forGetter(DistanceBasedStructurePlacement::spreadType),

                    Codec.intRange(0, Integer.MAX_VALUE)
                            .optionalFieldOf("min_distance_from_world_origin")
                            .forGetter(DistanceBasedStructurePlacement::minDistanceFromWorldOrigin)
            ).apply(instance, instance.stable(DistanceBasedStructurePlacement::new)));
    *///?} elif >=26.3 {
    /*public static final MapCodec<DistanceBasedStructurePlacement> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Vec3i.offsetCodec(16)
                            .optionalFieldOf("locate_offset", Vec3i.ZERO)
                            .forGetter(DistanceBasedStructurePlacement::locateOffset),

                    AbstractSpreadingStructurePlacement.FrequencyReductionMethod.CODEC
                            .optionalFieldOf("frequency_reduction_method",
                                    AbstractSpreadingStructurePlacement.FrequencyReductionMethod.DEFAULT)
                            .forGetter(DistanceBasedStructurePlacement::frequencyReductionMethod),

                    Codec.floatRange(0.0F, 1.0F)
                            .optionalFieldOf("frequency", 1.0F)
                            .forGetter(DistanceBasedStructurePlacement::frequency),

                    ExtraCodecs.NON_NEGATIVE_INT
                            .fieldOf("salt")
                            .forGetter(DistanceBasedStructurePlacement::salt),

                    AbstractSpreadingStructurePlacement.ExclusionZone.CODEC
                            .optionalFieldOf("exclusion_zone")
                            .forGetter(DistanceBasedStructurePlacement::exclusionZone),

                    // Accepted from JSON but IGNORED (config used instead)
                    Codec.intRange(0, Integer.MAX_VALUE)
                            .fieldOf("spacing")
                            .forGetter(p -> 0),

                    // Accepted from JSON but IGNORED (config used instead)
                    Codec.intRange(0, Integer.MAX_VALUE)
                            .fieldOf("separation")
                            .forGetter(p -> 0),

                    RandomSpreadType.CODEC
                            .optionalFieldOf("spread_type", RandomSpreadType.LINEAR)
                            .forGetter(DistanceBasedStructurePlacement::spreadType),

                    Codec.intRange(0, Integer.MAX_VALUE)
                            .optionalFieldOf("min_distance_from_world_origin")
                            .forGetter(DistanceBasedStructurePlacement::minDistanceFromWorldOrigin)
            ).apply(instance, instance.stable(DistanceBasedStructurePlacement::new)));
    *///?} else {
    public static final MapCodec<DistanceBasedStructurePlacement> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Vec3i.offsetCodec(16)
                            .optionalFieldOf("locate_offset", Vec3i.ZERO)
                            .forGetter(DistanceBasedStructurePlacement::locateOffset),

                    StructurePlacement.FrequencyReductionMethod.CODEC
                            .optionalFieldOf("frequency_reduction_method",
                                    StructurePlacement.FrequencyReductionMethod.DEFAULT)
                            .forGetter(DistanceBasedStructurePlacement::frequencyReductionMethod),

                    Codec.floatRange(0.0F, 1.0F)
                            .optionalFieldOf("frequency", 1.0F)
                            .forGetter(DistanceBasedStructurePlacement::frequency),

                    ExtraCodecs.NON_NEGATIVE_INT
                            .fieldOf("salt")
                            .forGetter(DistanceBasedStructurePlacement::salt),

                    StructurePlacement.ExclusionZone.CODEC
                            .optionalFieldOf("exclusion_zone")
                            .forGetter(DistanceBasedStructurePlacement::exclusionZone),

                    // Accepted from JSON but IGNORED (config used instead)
                    Codec.intRange(0, Integer.MAX_VALUE)
                            .fieldOf("spacing")
                            .forGetter(p -> 0),

                    // Accepted from JSON but IGNORED (config used instead)
                    Codec.intRange(0, Integer.MAX_VALUE)
                            .fieldOf("separation")
                            .forGetter(p -> 0),

                    RandomSpreadType.CODEC
                            .optionalFieldOf("spread_type", RandomSpreadType.LINEAR)
                            .forGetter(DistanceBasedStructurePlacement::spreadType),

                    Codec.intRange(0, Integer.MAX_VALUE)
                            .optionalFieldOf("min_distance_from_world_origin")
                            .forGetter(DistanceBasedStructurePlacement::minDistanceFromWorldOrigin)
            ).apply(instance, instance.stable(DistanceBasedStructurePlacement::new)));
    //?}

    private final Optional<Integer> minDistanceFromWorldOrigin;

    public DistanceBasedStructurePlacement(
            Vec3i locationOffset,
            //? if >=26.3 {
            /*AbstractSpreadingStructurePlacement.FrequencyReductionMethod frequencyReductionMethod,
            *///?} else {
            StructurePlacement.FrequencyReductionMethod frequencyReductionMethod,
            //?}
            float frequency,
            int salt,
            //? if >=26.3 {
            /*Optional<AbstractSpreadingStructurePlacement.ExclusionZone> exclusionZone,
            *///?} else {
            Optional<StructurePlacement.ExclusionZone> exclusionZone,
            //?}
            int ignoredSpacing,
            int ignoredSeparation,
            RandomSpreadType spreadType,
            Optional<Integer> minDistanceFromWorldOrigin
    ) {
        super(
                locationOffset,
                frequencyReductionMethod,
                frequency,
                salt,
                exclusionZone,
                CommonClass.CONFIG.placementSpacing.get(),
                CommonClass.CONFIG.placementSeparation.get(),
                spreadType
        );

        this.minDistanceFromWorldOrigin = minDistanceFromWorldOrigin;

        //Validate CONFIG, not JSON
        if (CommonClass.CONFIG.placementSpacing.get()
                <= CommonClass.CONFIG.placementSeparation.get()) {

            throw new RuntimeException("""
                [Underground Village]
                placementSpacing must be greater than placementSeparation

                    placementSpacing: %s
                    placementSeparation: %s
            """.formatted(
                    CommonClass.CONFIG.placementSpacing.get(),
                    CommonClass.CONFIG.placementSeparation.get()
            ));
        }
    }

    public Optional<Integer> minDistanceFromWorldOrigin() {
        return this.minDistanceFromWorldOrigin;
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState state, int x, int z) {

        if (minDistanceFromWorldOrigin.isPresent()) {
            long xBlock = x * 16L;
            long zBlock = z * 16L;
            long min = minDistanceFromWorldOrigin.get();

            if ((xBlock * xBlock) + (zBlock * zBlock) < (min * min)) {
                return false;
            }
        }

        ChunkPos pos = this.getPotentialStructureChunk(state.getLevelSeed(), x, z);
        //? if >=26.1 {
        return pos.x() == x && pos.z() == z;
        //?} else {
        /*return pos.x == x && pos.z == z;
        *///?}
    }

    //? if >=26.3 {
    /*@Override
    @SuppressWarnings("unchecked")
    public MapCodec<RandomSpreadStructurePlacement> codec() {
        return (MapCodec<RandomSpreadStructurePlacement>) (MapCodec<?>) CODEC;
    }
    *///?} else {
    @Override
    public StructurePlacementType<?> type() {
        return USStructurePlacements.DISTANCE_BASED_STRUCTURE_PLACEMENT;
    }
    //?}
}
