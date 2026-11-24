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
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
//? if >=26.1 {
import net.minecraft.resources.Identifier;
//?} else {
/*import net.minecraft.resources.ResourceLocation;
*///?}
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class UndergroundStructure extends Structure {

    static final Direction[] DIRECTIONS = new Direction[] {
        Direction.NORTH,
        Direction.SOUTH,
        Direction.EAST,
        Direction.WEST
    };
    static final BooleanProperty[] DIRECTION_PROPERTIES = new BooleanProperty[] {
        CrossCollisionBlock.NORTH,
        CrossCollisionBlock.SOUTH,
        CrossCollisionBlock.EAST,
        CrossCollisionBlock.WEST
    };

    //? if >=26.3 {
    /*static final net.minecraft.world.level.block.Block[] BARS = {
        Blocks.IRON_BARS,
        Blocks.GLASS_PANE,
        Blocks.STAINED_GLASS_PANE.white(),
        Blocks.STAINED_GLASS_PANE.orange(),
        Blocks.STAINED_GLASS_PANE.magenta(),
        Blocks.STAINED_GLASS_PANE.lightBlue(),
        Blocks.STAINED_GLASS_PANE.yellow(),
        Blocks.STAINED_GLASS_PANE.lime(),
        Blocks.STAINED_GLASS_PANE.pink(),
        Blocks.STAINED_GLASS_PANE.gray(),
        Blocks.STAINED_GLASS_PANE.lightGray(),
        Blocks.STAINED_GLASS_PANE.cyan(),
        Blocks.STAINED_GLASS_PANE.purple(),
        Blocks.STAINED_GLASS_PANE.blue(),
        Blocks.STAINED_GLASS_PANE.brown(),
        Blocks.STAINED_GLASS_PANE.green(),
        Blocks.STAINED_GLASS_PANE.red(),
        Blocks.STAINED_GLASS_PANE.black(),
    };*/
    //?} else {
    static final net.minecraft.world.level.block.Block[] BARS = {
        Blocks.IRON_BARS,
        Blocks.GLASS_PANE,
        Blocks.WHITE_STAINED_GLASS_PANE,
        Blocks.ORANGE_STAINED_GLASS_PANE,
        Blocks.MAGENTA_STAINED_GLASS_PANE,
        Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,
        Blocks.YELLOW_STAINED_GLASS_PANE,
        Blocks.LIME_STAINED_GLASS_PANE,
        Blocks.PINK_STAINED_GLASS_PANE,
        Blocks.GRAY_STAINED_GLASS_PANE,
        Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,
        Blocks.CYAN_STAINED_GLASS_PANE,
        Blocks.PURPLE_STAINED_GLASS_PANE,
        Blocks.BLUE_STAINED_GLASS_PANE,
        Blocks.BROWN_STAINED_GLASS_PANE,
        Blocks.GREEN_STAINED_GLASS_PANE,
        Blocks.RED_STAINED_GLASS_PANE,
        Blocks.BLACK_STAINED_GLASS_PANE,
    };
    //?}

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

        int surfaceY = context.chunkGenerator().getBaseHeight(
                x,
                z,
                Heightmap.Types.WORLD_SURFACE_WG,
                context.heightAccessor(),
                context.randomState()
        );

        if (surfaceY < 40 || surfaceY > 120) {
            return false;
        }

        int oceanFloorY = context.chunkGenerator().getBaseHeight(
                x,
                z,
                Heightmap.Types.OCEAN_FLOOR_WG,
                context.heightAccessor(),
                context.randomState()
        );

        if (surfaceY - oceanFloorY > 2) {
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

        // CONFIG VALUES USED HERE
        int actualSize = CommonClass.CONFIG.structureSize.get();
        int actualMaxDistance = CommonClass.CONFIG.maxDistanceFromCenter.get();

        return JigsawPlacement.addPieces(
                context,
                startPool,
                startJigsawName,
                actualSize,
                blockPos,
                true,
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
    public void afterPlace(WorldGenLevel world, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox box, ChunkPos chunkPos, PiecesContainer pieces) {
        pieces.pieces().forEach(structurePiece -> {
            BoundingBox boundingBox = structurePiece.getBoundingBox();

            int minX = Math.max(boundingBox.minX(), box.minX());
            int maxX = Math.min(boundingBox.maxX(), box.maxX());
            int minY = Math.max(boundingBox.minY(), box.minY());
            int maxY = Math.min(boundingBox.maxY(), box.maxY());
            int minZ = Math.max(boundingBox.minZ(), box.minZ());
            int maxZ = Math.min(boundingBox.maxZ(), box.maxZ());

            if (minX > maxX || minY > maxY || minZ > maxZ) {
                return;
            }

            RandomSource pieceRandom = RandomSource.create(boundingBox.hashCode());
            net.minecraft.world.level.block.Block newBlock = BARS[pieceRandom.nextInt(BARS.length)];
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    for (int z = minZ; z <= maxZ; z++) {
                        blockPos.set(x, y, z);
                        BlockState blockState = world.getBlockState(blockPos);
                        //? if >=26.3 {
                        /*if (blockState.is(Blocks.CONCRETE.pink())) {*/
                        //?} else {
                        if (blockState.is(Blocks.PINK_CONCRETE)) {
                        //?}
                            if (
                                world.getBlockState(blockPos.relative(Direction.NORTH)).isAir() && world.getBlockState(blockPos.relative(Direction.SOUTH)).isAir()
                                    || world.getBlockState(blockPos.relative(Direction.EAST)).isAir() && world.getBlockState(blockPos.relative(Direction.WEST)).isAir()
                            ) {
                                BlockState newState = newBlock.defaultBlockState();

                                for (int i = 0; i < DIRECTIONS.length; i++) {
                                    Direction direction = DIRECTIONS[i];
                                    BooleanProperty directionProperty = DIRECTION_PROPERTIES[i];

                                    BlockPos adjacentPos = blockPos.relative(direction);
                                    BlockState adjacentState = world.getBlockState(adjacentPos);

                                    if (((IronBarsBlock) Blocks.IRON_BARS).attachsTo(adjacentState, adjacentState.isFaceSturdy(world, adjacentPos, direction.getOpposite()))) {
                                        newState = newState.setValue(directionProperty, true);
                                    }
                                }

                                world.setBlock(blockPos, newState, net.minecraft.world.level.block.Block.UPDATE_CLIENTS);
                            } else {
                                BlockState adjacentState = world.getBlockState(blockPos.relative(Direction.DOWN));
                                world.setBlock(blockPos, adjacentState.getBlock().defaultBlockState(), net.minecraft.world.level.block.Block.UPDATE_CLIENTS);
                            }
                        }
                    }
                }
            }
        });

        super.afterPlace(world, structureManager, chunkGenerator, random, box, chunkPos, pieces);
    }

    @Override
    public StructureType<?> type() {
        return USRegistryAccess.STRUCTURES.underground();
    }
}
