package com.reggarf.mods.underground_village.biome;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class BiomePaletteCache {

    public static class VillageContext {
        public final ChunkPos centerChunk;
        public final int centerX;
        public final int centerZ;
        public final int maxDistance;
        public final BiomePalette palette;
        public final long timestamp;

        public VillageContext(ChunkPos centerChunk, BiomePalette palette, int maxDistance) {
            this.centerChunk = centerChunk;
            this.centerX = centerChunk.getMiddleBlockX();
            this.centerZ = centerChunk.getMiddleBlockZ();
            this.maxDistance = maxDistance > 0 ? maxDistance + 32 : 160;
            this.palette = palette;
            this.timestamp = System.currentTimeMillis();
        }

        public boolean contains(int x, int z) {
            int dx = Math.abs(x - centerX);
            int dz = Math.abs(z - centerZ);
            return dx <= maxDistance && dz <= maxDistance;
        }
    }

    private static final Map<ChunkPos, VillageContext> REGISTERED_VILLAGES = new ConcurrentHashMap<>();
    private static final Map<Long, BiomePalette> CHUNK_CACHE = new ConcurrentHashMap<>();
    private static final int MAX_VILLAGES = 512;
    private static final int MAX_CHUNKS = 2048;

    private static long chunkKey(int chunkX, int chunkZ) {
        return (((long) chunkX) << 32) | (((long) chunkZ) & 0xFFFFFFFFL);
    }

    public static void registerVillage(ChunkPos centerChunk, BiomePalette palette, int maxDistance) {
        if (REGISTERED_VILLAGES.size() >= MAX_VILLAGES) {
            pruneVillages();
        }
        REGISTERED_VILLAGES.put(centerChunk, new VillageContext(centerChunk, palette, maxDistance));
    }

    public static BiomePalette getPalette(LevelReader level, BlockPos pos) {
        int x = pos.getX();
        int z = pos.getZ();

        // 1. Check registered village contexts
        for (VillageContext context : REGISTERED_VILLAGES.values()) {
            if (context.contains(x, z)) {
                return context.palette;
            }
        }

        // 2. Check chunk cache
        long key = chunkKey(x >> 4, z >> 4);
        BiomePalette cached = CHUNK_CACHE.get(key);
        if (cached != null) {
            return cached;
        }

        // 3. Fallback: resolve surface biome above this position safely
        int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
        //? if >=26.1 {
        int minY = level.getMinY();
        int maxY = level.getMaxY();
        //?} else {
        /*int minY = level.getMinBuildHeight();
        int maxY = level.getMaxBuildHeight();
        *///?}

        if (surfaceY <= minY || surfaceY >= maxY) {
            surfaceY = level.getSeaLevel();
        }

        BlockPos surfacePos = new BlockPos(x, surfaceY, z);
        Holder<Biome> surfaceBiome = level.getBiome(surfacePos);
        BiomePalette palette = BiomePalettes.getPaletteForBiome(surfaceBiome);

        if (CHUNK_CACHE.size() >= MAX_CHUNKS) {
            CHUNK_CACHE.clear();
        }
        CHUNK_CACHE.put(key, palette);

        return palette;
    }

    private static void pruneVillages() {
        if (REGISTERED_VILLAGES.size() <= MAX_VILLAGES / 2) return;
        long cutoff = System.currentTimeMillis() - (1000L * 60 * 30); // 30 minutes
        Iterator<Map.Entry<ChunkPos, VillageContext>> it = REGISTERED_VILLAGES.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ChunkPos, VillageContext> entry = it.next();
            if (entry.getValue().timestamp < cutoff) {
                it.remove();
            }
        }
        if (REGISTERED_VILLAGES.size() >= MAX_VILLAGES) {
            REGISTERED_VILLAGES.clear();
        }
    }

    public static void clear() {
        REGISTERED_VILLAGES.clear();
        CHUNK_CACHE.clear();
    }

    private BiomePaletteCache() {}
}
