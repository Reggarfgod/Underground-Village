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
import com.reggarf.mods.underground_village.biome.BiomePalette;
import com.reggarf.mods.underground_village.biome.BiomePaletteCache;
import com.reggarf.mods.underground_village.biome.BiomePalettes;
import com.reggarf.mods.underground_village.register.USRegistryAccess;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
//? if >=26.1 {
import net.minecraft.resources.Identifier;
//?} else {
/*import net.minecraft.resources.Identifier;
*///?}
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.PiecesContainer;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class UndergroundStructure extends Structure {

    private static final int MIN_BURIED_COVER_BLOCKS = 2;
    private static final int MIN_CONNECTED_PIECES = 8;
    private static final int[][] ENTRANCE_CARDINAL_OFFSETS = {
        {-5, 0}, {5, 0}, {0, -5}, {0, 5}
    };
    private static final int[][] SUPPORT_RING_OFFSETS = {
        {-20, 0}, {20, 0}, {0, -20}, {0, 20}
    };

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
    static final BooleanProperty[] VINE_PROPERTIES = new BooleanProperty[] {
        VineBlock.NORTH,
        VineBlock.SOUTH,
        VineBlock.EAST,
        VineBlock.WEST
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
    };
    *///?} else {
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
                            Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(s -> s.startJigsawName),
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
                            /*Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(s -> s.startJigsawName),
                            *///?}
                            Codec.intRange(0, 30).fieldOf("size").forGetter(s -> 0),
                            HeightProvider.CODEC.fieldOf("start_height").forGetter(s -> s.startHeight),
                            Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(s -> s.projectStartToHeightmap),
                            Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(s -> 0),
                            DimensionPadding.CODEC.optionalFieldOf("dimension_padding", JigsawStructure.DEFAULT_DIMENSION_PADDING).forGetter(s -> s.dimensionPadding),
                            LiquidSettings.CODEC.optionalFieldOf("liquid_settings", JigsawStructure.DEFAULT_LIQUID_SETTINGS).forGetter(s -> s.liquidSettings)
                    ).apply(instance, UndergroundStructure::new)
            );
    //?}

    private final Holder<StructureTemplatePool> startPool;
    //? if >=26.1 {
    private final Optional<Identifier> startJigsawName;
    //?} else {
    /*private final Optional<Identifier> startJigsawName;
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
            Optional<Identifier> startJigsawName,
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
            /*Optional<Identifier> startJigsawName,
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

    private static boolean checkTerrainSupport(GenerationContext context, int x, int z, int surfaceY) {
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

        // Reject sheer cliff edges directly under the surface entrance footprint
        for (int[] offset : ENTRANCE_CARDINAL_OFFSETS) {
            int nearFloorY = context.chunkGenerator().getBaseHeight(
                    x + offset[0],
                    z + offset[1],
                    Heightmap.Types.OCEAN_FLOOR_WG,
                    context.heightAccessor(),
                    context.randomState()
            );
            if (surfaceY - nearFloorY > 5) {
                return false;
            }
        }

        // Fast-reject narrow isolated spires before running expensive JigsawPlacement
        for (int[] offset : SUPPORT_RING_OFFSETS) {
            int ringFloorY = context.chunkGenerator().getBaseHeight(
                    x + offset[0],
                    z + offset[1],
                    Heightmap.Types.OCEAN_FLOOR_WG,
                    context.heightAccessor(),
                    context.randomState()
            );
            if (ringFloorY >= surfaceY - 22) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<GenerationStub> findValidGenerationPoint(GenerationContext context) {
        return findGenerationPoint(context);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {

        ChunkPos chunkPos = context.chunkPos();
        int middleX = chunkPos.getMiddleBlockX();
        int middleZ = chunkPos.getMiddleBlockZ();

        int surfaceY = context.chunkGenerator().getBaseHeight(
                middleX,
                middleZ,
                Heightmap.Types.WORLD_SURFACE_WG,
                context.heightAccessor(),
                context.randomState()
        );

        if (surfaceY < 40 || surfaceY > 120) {
            return Optional.empty();
        }

        // Validate surface biome FIRST so non-matching structures exit immediately in 1 height query
        //? if >=26.3 {
        /*Holder<Biome> surfaceBiome = context.biomeResolver().getNoiseBiome(
                QuartPos.fromBlock(middleX),
                QuartPos.fromBlock(surfaceY),
                QuartPos.fromBlock(middleZ)
        );
        *///?} else {
        Holder<Biome> surfaceBiome = context.biomeSource().getNoiseBiome(
                QuartPos.fromBlock(middleX),
                QuartPos.fromBlock(surfaceY),
                QuartPos.fromBlock(middleZ),
                context.randomState().sampler()
        );
        //?}
        if (!context.validBiome().test(surfaceBiome)) {
            return Optional.empty();
        }

        if (!checkTerrainSupport(context, middleX, middleZ, surfaceY)) {
            return Optional.empty();
        }

        int startY = startHeight.sample(
                context.random(),
                new WorldGenerationContext(
                        context.chunkGenerator(),
                        context.heightAccessor()
                )
        );

        BlockPos blockPos = new BlockPos(
                chunkPos.getMinBlockX(),
                startY,
                chunkPos.getMinBlockZ()
        );

        // CONFIG VALUES USED HERE
        int actualSize = CommonClass.CONFIG.structureSize.get();
        int actualMaxDistance = CommonClass.CONFIG.maxDistanceFromCenter.get();

        Optional<GenerationStub> stubOpt = JigsawPlacement.addPieces(
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

        if (stubOpt.isEmpty()) {
            return Optional.empty();
        }

        GenerationStub rawStub = stubOpt.get();
        List<StructurePiece> keptPieces = filterExposedPieces(context, rawStub.getPiecesBuilder().build().pieces(), Heightmap.Types.OCEAN_FLOOR_WG);
        if (keptPieces.size() < MIN_CONNECTED_PIECES) {
            return Optional.empty();
        }

        BiomePalette palette = BiomePalettes.getPaletteForBiome(surfaceBiome);
        BiomePaletteCache.registerVillage(chunkPos, palette, actualMaxDistance);

        return Optional.of(new GenerationStub(rawStub.position(), builder -> {
            for (StructurePiece piece : keptPieces) {
                builder.addPiece(piece);
            }
        }));
    }

    /**
     * Keeps only pieces that are properly buried below the target heightmap (except the surface
     * entrance piece[0] and the vertical stair shaft directly underneath the entrance footprint),
     * pruning any exposed branches via BFS connectivity from the entrance so no non-entrance piece
     * protrudes into open air.
     */
    static List<StructurePiece> filterExposedPieces(
            GenerationContext context,
            List<StructurePiece> allPieces,
            Heightmap.Types heightmapType
    ) {
        if (allPieces.isEmpty()) {
            return List.of();
        }

        int n = allPieces.size();
        BoundingBox entranceBox = allPieces.get(0).getBoundingBox();
        Long2IntOpenHashMap heightCache = new Long2IntOpenHashMap();
        heightCache.defaultReturnValue(Integer.MIN_VALUE);

        boolean[] valid = new boolean[n];
        valid[0] = true; // Root entrance piece belongs on the surface

        List<BoundingBox> validatedBoxes = new ArrayList<>(n);

        for (int i = 1; i < n; i++) {
            BoundingBox bb = allPieces.get(i).getBoundingBox();
            if (isWithinEntranceShaftFootprint(bb, entranceBox)) {
                valid[i] = isEntranceShaftBuried(context, bb, entranceBox, heightmapType, heightCache);
            } else if (bb.maxY() < 30 || isContainedInAny(bb, validatedBoxes)) {
                valid[i] = true;
            } else {
                valid[i] = isPieceBuried(context, bb, heightmapType, heightCache);
                if (valid[i]) {
                    validatedBoxes.add(bb);
                }
            }
        }

        // BFS from entrance piece[0] so pruned exposed branches never leave disconnected floating rooms
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            BoundingBox currBox = allPieces.get(curr).getBoundingBox();
            for (int next = 1; next < n; next++) {
                if (!visited[next] && valid[next] && boxesTouchOrOverlap(currBox, allPieces.get(next).getBoundingBox())) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        List<StructurePiece> kept = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                kept.add(allPieces.get(i));
            }
        }
        return kept;
    }

    private static boolean isContainedInAny(BoundingBox bb, List<BoundingBox> validatedBoxes) {
        for (int i = validatedBoxes.size() - 1; i >= 0; i--) {
            BoundingBox parent = validatedBoxes.get(i);
            if (bb.minX() >= parent.minX() && bb.maxX() <= parent.maxX()
                    && bb.minZ() >= parent.minZ() && bb.maxZ() <= parent.maxZ()
                    && bb.maxY() <= parent.maxY()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWithinEntranceShaftFootprint(BoundingBox bb, BoundingBox entranceBox) {
        return bb.minX() >= entranceBox.minX() - 1
                && bb.maxX() <= entranceBox.maxX() + 1
                && bb.minZ() >= entranceBox.minZ() - 1
                && bb.maxZ() <= entranceBox.maxZ() + 1
                && bb.maxY() >= entranceBox.minY() - 2;
    }

    private static boolean isEntranceShaftBuried(
            GenerationContext context,
            BoundingBox bb,
            BoundingBox entranceBox,
            Heightmap.Types heightmapType,
            Long2IntOpenHashMap heightCache
    ) {
        int lowerExitCeilingY = Math.min(bb.maxY(), bb.minY() + 6);
        int minX = bb.minX() - 1;
        int maxX = bb.maxX() + 1;
        int minZ = bb.minZ() - 1;
        int maxZ = bb.maxZ() + 1;
        int centerX = (minX + maxX) >> 1;
        int centerZ = (minZ + maxZ) >> 1;

        int[][] points = {
            {centerX, centerZ},
            {minX, minZ}, {maxX, minZ}, {minX, maxZ}, {maxX, maxZ}
        };

        for (int[] p : points) {
            int groundY = sampleHeightY(context, p[0], p[1], heightmapType, heightCache);
            if (lowerExitCeilingY > groundY - MIN_BURIED_COVER_BLOCKS) {
                return false;
            }
            boolean insideEntrance = p[0] >= entranceBox.minX() && p[0] <= entranceBox.maxX()
                    && p[1] >= entranceBox.minZ() && p[1] <= entranceBox.maxZ();
            if (!insideEntrance && bb.maxY() > groundY + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPieceBuried(
            GenerationContext context,
            BoundingBox bb,
            Heightmap.Types heightmapType,
            Long2IntOpenHashMap heightCache
    ) {
        int minX = bb.minX() - 1;
        int maxX = bb.maxX() + 1;
        int minZ = bb.minZ() - 1;
        int maxZ = bb.maxZ() + 1;
        int centerX = (minX + maxX) >> 1;
        int centerZ = (minZ + maxZ) >> 1;
        int thresholdY = bb.maxY() + MIN_BURIED_COVER_BLOCKS;

        // Check center first, then 4 corners for fast early rejection
        if (sampleHeightY(context, centerX, centerZ, heightmapType, heightCache) < thresholdY) return false;
        if (sampleHeightY(context, minX, minZ, heightmapType, heightCache) < thresholdY) return false;
        if (sampleHeightY(context, maxX, minZ, heightmapType, heightCache) < thresholdY) return false;
        if (sampleHeightY(context, minX, maxZ, heightmapType, heightCache) < thresholdY) return false;
        if (sampleHeightY(context, maxX, maxZ, heightmapType, heightCache) < thresholdY) return false;

        // For wide rooms (>14 blocks), also sample edge midpoints
        if (maxX - minX > 14 || maxZ - minZ > 14) {
            if (sampleHeightY(context, centerX, minZ, heightmapType, heightCache) < thresholdY) return false;
            if (sampleHeightY(context, centerX, maxZ, heightmapType, heightCache) < thresholdY) return false;
            if (sampleHeightY(context, minX, centerZ, heightmapType, heightCache) < thresholdY) return false;
            if (sampleHeightY(context, maxX, centerZ, heightmapType, heightCache) < thresholdY) return false;
        }
        return true;
    }

    private static int sampleHeightY(
            GenerationContext context,
            int x,
            int z,
            Heightmap.Types heightmapType,
            Long2IntOpenHashMap heightCache
    ) {
        // 2-block quantization shares adjacent piece queries while staying within 1 block of true corner
        int qx = x & ~1;
        int qz = z & ~1;
        long key = (((long) qx) << 32) | (qz & 0xFFFFFFFFL);
        int cached = heightCache.get(key);
        if (cached != Integer.MIN_VALUE) {
            return cached;
        }
        int groundY = context.chunkGenerator().getBaseHeight(
                qx,
                qz,
                heightmapType,
                context.heightAccessor(),
                context.randomState()
        );
        heightCache.put(key, groundY);
        return groundY;
    }

    private static boolean boxesTouchOrOverlap(BoundingBox a, BoundingBox b) {
        boolean overlapX = a.minX() <= b.maxX() && a.maxX() >= b.minX();
        boolean overlapY = a.minY() <= b.maxY() && a.maxY() >= b.minY();
        boolean overlapZ = a.minZ() <= b.maxZ() && a.maxZ() >= b.minZ();
        boolean nearX = a.minX() <= b.maxX() + 1 && a.maxX() >= b.minX() - 1;
        boolean nearY = a.minY() <= b.maxY() + 1 && a.maxY() >= b.minY() - 1;
        boolean nearZ = a.minZ() <= b.maxZ() + 1 && a.maxZ() >= b.minZ() - 1;
        return (overlapX && overlapY && nearZ)
                || (overlapX && overlapZ && nearY)
                || (overlapY && overlapZ && nearX);
    }

    @Override
    public void afterPlace(WorldGenLevel world, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox box, ChunkPos chunkPos, PiecesContainer pieces) {
        BiomePalette palette = CommonClass.CONFIG.enableBiomePalettes.get()
                ? BiomePaletteCache.getPalette(world, box.getCenter())
                : null;
        int wallVineChance = palette != null ? palette.getWallVineChance() : 12;

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
                        /*if (blockState.is(Blocks.CONCRETE.pink())) {
                        *///?} else {
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
                        } else if (wallVineChance > 0 && blockState.isAir() && y > minY + 1 && y < maxY) {
                            int h = x * 374761393 + y * 668265263 + z * 1442695041;
                            h = (h ^ (h >>> 13)) * 1274126177;
                            int roll = ((h ^ (h >>> 16)) & 0x7FFFFFFF) % 1000;
                            if (roll < wallVineChance && world.getBlockState(blockPos.below()).isAir()) {
                                for (int i = 0; i < DIRECTIONS.length; i++) {
                                    int idx = (roll + i) & 3;
                                    Direction direction = DIRECTIONS[idx];
                                    BlockPos adjacentPos = blockPos.relative(direction);
                                    BlockState adjacentState = world.getBlockState(adjacentPos);
                                    if (adjacentState.isFaceSturdy(world, adjacentPos, direction.getOpposite())
                                            && adjacentState.isCollisionShapeFullBlock(world, adjacentPos)
                                            && !(adjacentState.getBlock() instanceof LeavesBlock)
                                            && !adjacentState.hasBlockEntity()) {
                                        BlockState vineState = Blocks.VINE.defaultBlockState().setValue(VINE_PROPERTIES[idx], true);
                                        world.setBlock(blockPos, vineState, net.minecraft.world.level.block.Block.UPDATE_CLIENTS);
                                        if ((roll & 1) == 0 && world.getBlockState(blockPos.below(2)).isAir()) {
                                            world.setBlock(blockPos.below(), vineState, net.minecraft.world.level.block.Block.UPDATE_CLIENTS);
                                        }
                                        break;
                                    }
                                }
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
