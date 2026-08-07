package com.reggarf.mods.underground_village.structure;

import com.mojang.serialization.Codec;
//? if >1.20.1 {
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
//?}
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.reggarf.mods.underground_village.CommonClass;
import com.reggarf.mods.underground_village.register.USRegistryAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
//? if >=26.1 {
import net.minecraft.resources.Identifier;
//?} else {
/*import net.minecraft.resources.ResourceLocation;
*///?}
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class UndergroundStructure extends Structure {

    //? if <=1.20.1 {
    /*public static final Codec<UndergroundStructure> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            UndergroundStructure.settingsCodec(instance),
                            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(s -> s.startPool),
                            ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(s -> s.startJigsawName),
                            Codec.intRange(0, 30).fieldOf("size").forGetter(s -> 0),
                            HeightProvider.CODEC.fieldOf("start_height").forGetter(s -> s.startHeight),
                            Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(s -> s.projectStartToHeightmap),
                            Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(s -> 0)
                    ).apply(instance, UndergroundStructure::new)
            );
    *///?} else {
    public static final MapCodec<UndergroundStructure> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            UndergroundStructure.settingsCodec(instance),
                            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(s -> s.startPool),
                            //? if >=26.1 {
                            Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(s -> s.startJigsawName),
                            //?} else {
                            /*ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(s -> s.startJigsawName),
                            *///?}

                            // Accepted from JSON but IGNORED (config used instead)
                            Codec.intRange(0, 30).fieldOf("size").forGetter(s -> 0),

                            HeightProvider.CODEC.fieldOf("start_height").forGetter(s -> s.startHeight),
                            Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(s -> s.projectStartToHeightmap),

                            // Accepted from JSON but IGNORED (config used instead)
                            Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(s -> 0),

                            DimensionPadding.CODEC.optionalFieldOf(
                                    "dimension_padding",
                                    JigsawStructure.DEFAULT_DIMENSION_PADDING
                            ).forGetter(s -> s.dimensionPadding),

                            LiquidSettings.CODEC.optionalFieldOf(
                                    "liquid_settings",
                                    JigsawStructure.DEFAULT_LIQUID_SETTINGS
                            ).forGetter(s -> s.liquidSettings)
                    ).apply(instance, UndergroundStructure::new)
            );
    //?}

    private final Holder<StructureTemplatePool> startPool;
    //? if >=26.1 {
    private final Optional<Identifier> startJigsawName;
    //?} else {
    /*private final Optional<ResourceLocation> startJigsawName;
    *///?}
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    //? if >1.20.1 {
    private final DimensionPadding dimensionPadding;
    private final LiquidSettings liquidSettings;
    //?}

    //? if <=1.20.1 {
    /*public UndergroundStructure(
            StructureSettings settings,
            Holder<StructureTemplatePool> startPool,
            Optional<ResourceLocation> startJigsawName,
            int ignoredSize,
            HeightProvider startHeight,
            Optional<Heightmap.Types> projectStartToHeightmap,
            int ignoredMaxDistance
    ) {
        super(settings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
    }
    *///?} else {
    public UndergroundStructure(
            StructureSettings settings,
            Holder<StructureTemplatePool> startPool,
            //? if >=26.1 {
            Optional<Identifier> startJigsawName,
            //?} else {
            /*Optional<ResourceLocation> startJigsawName,
            *///?}
            int ignoredSize,
            HeightProvider startHeight,
            Optional<Heightmap.Types> projectStartToHeightmap,
            int ignoredMaxDistance,
            DimensionPadding dimensionPadding,
            LiquidSettings liquidSettings
    ) {
        super(settings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.dimensionPadding = dimensionPadding;
        this.liquidSettings = liquidSettings;
    }
    //?}

    private static boolean extraSpawningChecks(GenerationContext context) {

        ChunkPos chunkPos = context.chunkPos();

        int x = chunkPos.getMiddleBlockX();
        int z = chunkPos.getMiddleBlockZ();

        var level = context.heightAccessor();

        int centerY = context.chunkGenerator().getBaseHeight(
                x,
                z,
                Heightmap.Types.WORLD_SURFACE_WG,
                level,
                context.randomState()
        );

        // Global height limits
        if (centerY < 45 || centerY > 85)
            return false;

        int minHeight = centerY;
        int maxHeight = centerY;

        // Check 10 blocks around center
        for (int dx = -10; dx <= 10; dx++) {
            for (int dz = -10; dz <= 10; dz++) {

                int checkX = x + dx;
                int checkZ = z + dz;

                int surfaceY = context.chunkGenerator().getBaseHeight(
                        checkX,
                        checkZ,
                        Heightmap.Types.WORLD_SURFACE_WG,
                        level,
                        context.randomState()
                );

                int oceanFloorY = context.chunkGenerator().getBaseHeight(
                        checkX,
                        checkZ,
                        Heightmap.Types.OCEAN_FLOOR_WG,
                        level,
                        context.randomState()
                );

                // Water nearby (ocean, river, lake)
                if (surfaceY - oceanFloorY > 2) {
                    return false;
                }

                //? if >=26.3 {
                /*Holder<Biome> biome = context.biomeSource().createUncachedResolver(context.randomState()).getNoiseBiome(
                        checkX >> 2,
                        surfaceY >> 2,
                        checkZ >> 2
                );
                *///?} else {
                Holder<Biome> biome = context.biomeSource().getNoiseBiome(
                        checkX >> 2,
                        surfaceY >> 2,
                        checkZ >> 2,
                        context.randomState().sampler()
                );
                //?}

                // Reject mountain biomes
                if (biome.is(BiomeTags.IS_MOUNTAIN)) {
                    return false;
                }

                minHeight = Math.min(minHeight, surfaceY);
                maxHeight = Math.max(maxHeight, surfaceY);
            }
        }

        // Area must be nearly flat
        if ((maxHeight - minHeight) > 6) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {

        if (!extraSpawningChecks(context)) {
            return Optional.empty();
        }

        int startY = startHeight.sample(
                context.random(),
                new WorldGenerationContext(
                        context.chunkGenerator(),
                        context.heightAccessor()
                )
        );

        ChunkPos chunkPos = context.chunkPos();
        BlockPos blockPos = new BlockPos(
                chunkPos.getMinBlockX(),
                startY,
                chunkPos.getMinBlockZ()
        );

        //CONFIG VALUES USED HERE
        int actualSize = CommonClass.CONFIG.structureSize.get();
        int actualMaxDistance = CommonClass.CONFIG.maxDistanceFromCenter.get();

        return JigsawPlacement.addPieces(
                context,
                startPool,
                startJigsawName,
                actualSize,
                blockPos,
                false,
                projectStartToHeightmap,
                //? if <=1.20.1 {
                /*actualMaxDistance
                *///?} elif <26.1 {
                /*actualMaxDistance,
                PoolAliasLookup.EMPTY,
                dimensionPadding,
                liquidSettings
                *///?} else {
                new JigsawStructure.MaxDistance(actualMaxDistance),
                PoolAliasLookup.EMPTY,
                dimensionPadding,
                liquidSettings
                //?}
        );
    }

    @Override
    public StructureType<?> type() {
        return USRegistryAccess.STRUCTURES.underground();
    }
}
