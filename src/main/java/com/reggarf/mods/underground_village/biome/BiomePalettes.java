package com.reggarf.mods.underground_village.biome;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class BiomePalettes {

    //? if >=26.3 {
    /*private static final Block ORANGE_TERRACOTTA = Blocks.DYED_TERRACOTTA.orange();
    private static final Block BROWN_TERRACOTTA = Blocks.DYED_TERRACOTTA.brown();
    private static final Block RED_TERRACOTTA = Blocks.DYED_TERRACOTTA.red();
    private static final Block PINK_TERRACOTTA = Blocks.DYED_TERRACOTTA.pink();
    private static final Block WHITE_TERRACOTTA = Blocks.DYED_TERRACOTTA.white();
    *///?} else {
    private static final Block ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA;
    private static final Block BROWN_TERRACOTTA = Blocks.BROWN_TERRACOTTA;
    private static final Block RED_TERRACOTTA = Blocks.RED_TERRACOTTA;
    private static final Block PINK_TERRACOTTA = Blocks.PINK_TERRACOTTA;
    private static final Block WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA;
    //?}

    // 1. Desert
    public static final BiomePalette DESERT = BiomePalette.builder()
            .planks(Blocks.CUT_SANDSTONE)
            .planksBlend(Blocks.SANDSTONE, 6, Blocks.SMOOTH_SANDSTONE, 4)
            .log(Blocks.SMOOTH_SANDSTONE)
            .wood(Blocks.CUT_SANDSTONE)
            .strippedLog(Blocks.SMOOTH_SANDSTONE)
            .strippedWood(Blocks.CUT_SANDSTONE)
            .stairs(Blocks.SANDSTONE_STAIRS)
            .slab(Blocks.SANDSTONE_SLAB)
            .fence(Blocks.SANDSTONE_WALL)
            .fenceGate(Blocks.BIRCH_FENCE_GATE)
            .door(Blocks.BIRCH_DOOR)
            .trapdoor(Blocks.BIRCH_TRAPDOOR)
            .pressurePlate(Blocks.BIRCH_PRESSURE_PLATE)
            .button(Blocks.BIRCH_BUTTON)
            .stoneBricks(Blocks.SMOOTH_SANDSTONE)
            .stoneBrickBlend(Blocks.CUT_SANDSTONE, 6, Blocks.SANDSTONE, 4, Blocks.TERRACOTTA, 3)
            .crackedStoneBricks(Blocks.SANDSTONE)
            .stoneBrickStairs(Blocks.SMOOTH_SANDSTONE_STAIRS)
            .stoneBrickSlab(Blocks.SMOOTH_SANDSTONE_SLAB)
            .stoneBrickWall(Blocks.SANDSTONE_WALL)
            .chiseledStoneBricks(Blocks.CHISELED_SANDSTONE)
            .cobblestone(Blocks.SANDSTONE)
            .cobblestoneBlend(Blocks.CUT_SANDSTONE, 8, Blocks.TERRACOTTA, 4)
            .cobblestoneStairs(Blocks.SANDSTONE_STAIRS)
            .cobblestoneSlab(Blocks.SANDSTONE_SLAB)
            .cobblestoneWall(Blocks.SANDSTONE_WALL)
            .mossyCobblestone(Blocks.TERRACOTTA)
            .mossyCobblestoneStairs(Blocks.SANDSTONE_STAIRS)
            .mossyCobblestoneSlab(Blocks.SANDSTONE_SLAB)
            .mossyCobblestoneWall(Blocks.SANDSTONE_WALL)
            .mossyStoneBricks(Blocks.TERRACOTTA)
            .mossyStoneBrickStairs(Blocks.SMOOTH_SANDSTONE_STAIRS)
            .mossyStoneBrickSlab(Blocks.SMOOTH_SANDSTONE_SLAB)
            .mossyStoneBrickWall(Blocks.SANDSTONE_WALL)
            .stone(Blocks.SMOOTH_SANDSTONE)
            .stoneBlend(Blocks.SANDSTONE, 8, Blocks.CUT_SANDSTONE, 4)
            .stoneStairs(Blocks.SMOOTH_SANDSTONE_STAIRS)
            .stoneSlab(Blocks.SMOOTH_SANDSTONE_SLAB)
            .leaves(Blocks.CUT_SANDSTONE)
            .dirt(Blocks.SAND)
            .wallVineChance(6)
            .build();

    // 2. Badlands
    public static final BiomePalette BADLANDS = BiomePalette.builder()
            .planks(Blocks.RED_SANDSTONE)
            .planksBlend(Blocks.CUT_RED_SANDSTONE, 6, Blocks.TERRACOTTA, 4)
            .log(BROWN_TERRACOTTA)
            .wood(Blocks.SMOOTH_RED_SANDSTONE)
            .strippedLog(RED_TERRACOTTA)
            .strippedWood(Blocks.SMOOTH_RED_SANDSTONE)
            .stairs(Blocks.RED_SANDSTONE_STAIRS)
            .slab(Blocks.RED_SANDSTONE_SLAB)
            .fence(Blocks.RED_SANDSTONE_WALL)
            .fenceGate(Blocks.DARK_OAK_FENCE_GATE)
            .door(Blocks.DARK_OAK_DOOR)
            .trapdoor(Blocks.DARK_OAK_TRAPDOOR)
            .pressurePlate(Blocks.DARK_OAK_PRESSURE_PLATE)
            .button(Blocks.DARK_OAK_BUTTON)
            .stoneBricks(Blocks.TERRACOTTA)
            .stoneBrickBlend(ORANGE_TERRACOTTA, 6, BROWN_TERRACOTTA, 4, Blocks.RED_SANDSTONE, 4)
            .crackedStoneBricks(Blocks.RED_SANDSTONE)
            .stoneBrickStairs(Blocks.RED_SANDSTONE_STAIRS)
            .stoneBrickSlab(Blocks.RED_SANDSTONE_SLAB)
            .stoneBrickWall(Blocks.RED_SANDSTONE_WALL)
            .chiseledStoneBricks(Blocks.CHISELED_RED_SANDSTONE)
            .cobblestone(Blocks.RED_SANDSTONE)
            .cobblestoneBlend(Blocks.SMOOTH_RED_SANDSTONE, 8, ORANGE_TERRACOTTA, 4)
            .cobblestoneStairs(Blocks.RED_SANDSTONE_STAIRS)
            .cobblestoneSlab(Blocks.RED_SANDSTONE_SLAB)
            .cobblestoneWall(Blocks.RED_SANDSTONE_WALL)
            .mossyCobblestone(Blocks.CUT_RED_SANDSTONE)
            .mossyCobblestoneStairs(Blocks.RED_SANDSTONE_STAIRS)
            .mossyCobblestoneSlab(Blocks.RED_SANDSTONE_SLAB)
            .mossyCobblestoneWall(Blocks.RED_SANDSTONE_WALL)
            .mossyStoneBricks(ORANGE_TERRACOTTA)
            .mossyStoneBrickStairs(Blocks.RED_SANDSTONE_STAIRS)
            .mossyStoneBrickSlab(Blocks.RED_SANDSTONE_SLAB)
            .mossyStoneBrickWall(Blocks.RED_SANDSTONE_WALL)
            .stone(Blocks.SMOOTH_RED_SANDSTONE)
            .stoneBlend(Blocks.RED_SANDSTONE, 8, Blocks.TERRACOTTA, 4)
            .stoneStairs(Blocks.RED_SANDSTONE_STAIRS)
            .stoneSlab(Blocks.RED_SANDSTONE_SLAB)
            .leaves(Blocks.CUT_RED_SANDSTONE)
            .dirt(Blocks.RED_SAND)
            .wallVineChance(6)
            .build();

    // 3. Jungle
    public static final BiomePalette JUNGLE = BiomePalette.builder()
            .planks(Blocks.JUNGLE_PLANKS)
            .planksBlend(Blocks.STRIPPED_JUNGLE_WOOD, 6, Blocks.BAMBOO_PLANKS, 4)
            .log(Blocks.JUNGLE_LOG)
            .wood(Blocks.JUNGLE_WOOD)
            .strippedLog(Blocks.STRIPPED_JUNGLE_LOG)
            .strippedWood(Blocks.STRIPPED_JUNGLE_WOOD)
            .stairs(Blocks.JUNGLE_STAIRS)
            .slab(Blocks.JUNGLE_SLAB)
            .fence(Blocks.JUNGLE_FENCE)
            .fenceGate(Blocks.JUNGLE_FENCE_GATE)
            .door(Blocks.JUNGLE_DOOR)
            .trapdoor(Blocks.JUNGLE_TRAPDOOR)
            .pressurePlate(Blocks.JUNGLE_PRESSURE_PLATE)
            .button(Blocks.JUNGLE_BUTTON)
            .stoneBricks(Blocks.JUNGLE_PLANKS)
            .stoneBrickBlend(Blocks.STRIPPED_JUNGLE_WOOD, 6, Blocks.JUNGLE_WOOD, 4, Blocks.MOSSY_COBBLESTONE, 3)
            .crackedStoneBricks(Blocks.STRIPPED_JUNGLE_WOOD)
            .stoneBrickStairs(Blocks.JUNGLE_STAIRS)
            .stoneBrickSlab(Blocks.JUNGLE_SLAB)
            .stoneBrickWall(Blocks.JUNGLE_FENCE)
            .chiseledStoneBricks(Blocks.JUNGLE_LOG)
            .cobblestone(Blocks.MOSSY_COBBLESTONE)
            .cobblestoneBlend(Blocks.STRIPPED_JUNGLE_WOOD, 7, Blocks.COBBLESTONE, 5)
            .cobblestoneStairs(Blocks.JUNGLE_STAIRS)
            .cobblestoneSlab(Blocks.JUNGLE_SLAB)
            .cobblestoneWall(Blocks.JUNGLE_FENCE)
            .mossyCobblestone(Blocks.MOSSY_COBBLESTONE)
            .mossyCobblestoneStairs(Blocks.MOSSY_COBBLESTONE_STAIRS)
            .mossyCobblestoneSlab(Blocks.MOSSY_COBBLESTONE_SLAB)
            .mossyCobblestoneWall(Blocks.MOSSY_COBBLESTONE_WALL)
            .mossyStoneBricks(Blocks.MOSSY_STONE_BRICKS)
            .mossyStoneBrickStairs(Blocks.MOSSY_STONE_BRICK_STAIRS)
            .mossyStoneBrickSlab(Blocks.MOSSY_STONE_BRICK_SLAB)
            .mossyStoneBrickWall(Blocks.MOSSY_STONE_BRICK_WALL)
            .stone(Blocks.STRIPPED_JUNGLE_LOG)
            .stoneBlend(Blocks.MOSSY_COBBLESTONE, 7, Blocks.JUNGLE_WOOD, 5)
            .stoneStairs(Blocks.JUNGLE_STAIRS)
            .stoneSlab(Blocks.JUNGLE_SLAB)
            .leaves(Blocks.JUNGLE_LEAVES)
            .dirt(Blocks.DIRT)
            .wallVineChance(30)
            .build();

    // 4. Plains (Default vanilla Underground Village look with subtle stone blending)
    public static final BiomePalette PLAINS = BiomePalette.builder()
            .planksBlend(Blocks.STRIPPED_OAK_WOOD, 6)
            .stoneBrickBlend(Blocks.CRACKED_STONE_BRICKS, 5, Blocks.MOSSY_STONE_BRICKS, 4, Blocks.COBBLESTONE, 3)
            .cobblestoneBlend(Blocks.ANDESITE, 7, Blocks.MOSSY_COBBLESTONE, 4)
            .stoneBlend(Blocks.ANDESITE, 8, Blocks.COBBLESTONE, 4)
            .wallVineChance(12)
            .build();

    // 5. Forest
    public static final BiomePalette FOREST = BiomePalette.builder()
            .planks(Blocks.BIRCH_PLANKS)
            .planksBlend(Blocks.STRIPPED_BIRCH_WOOD, 6, Blocks.OAK_PLANKS, 4)
            .log(Blocks.BIRCH_LOG)
            .wood(Blocks.BIRCH_WOOD)
            .strippedLog(Blocks.STRIPPED_BIRCH_LOG)
            .strippedWood(Blocks.STRIPPED_BIRCH_WOOD)
            .stairs(Blocks.BIRCH_STAIRS)
            .slab(Blocks.BIRCH_SLAB)
            .fence(Blocks.BIRCH_FENCE)
            .fenceGate(Blocks.BIRCH_FENCE_GATE)
            .door(Blocks.BIRCH_DOOR)
            .trapdoor(Blocks.BIRCH_TRAPDOOR)
            .pressurePlate(Blocks.BIRCH_PRESSURE_PLATE)
            .button(Blocks.BIRCH_BUTTON)
            .stoneBricks(Blocks.BIRCH_PLANKS)
            .stoneBrickBlend(Blocks.STRIPPED_BIRCH_WOOD, 6, Blocks.MOSSY_STONE_BRICKS, 4, Blocks.OAK_PLANKS, 3)
            .crackedStoneBricks(Blocks.STRIPPED_BIRCH_WOOD)
            .stoneBrickStairs(Blocks.BIRCH_STAIRS)
            .stoneBrickSlab(Blocks.BIRCH_SLAB)
            .stoneBrickWall(Blocks.BIRCH_FENCE)
            .chiseledStoneBricks(Blocks.BIRCH_LOG)
            .cobblestone(Blocks.MOSSY_COBBLESTONE)
            .cobblestoneBlend(Blocks.STRIPPED_BIRCH_WOOD, 7, Blocks.COBBLESTONE, 5)
            .cobblestoneStairs(Blocks.BIRCH_STAIRS)
            .cobblestoneSlab(Blocks.BIRCH_SLAB)
            .cobblestoneWall(Blocks.BIRCH_FENCE)
            .mossyCobblestone(Blocks.MOSSY_COBBLESTONE)
            .mossyCobblestoneStairs(Blocks.MOSSY_COBBLESTONE_STAIRS)
            .mossyCobblestoneSlab(Blocks.MOSSY_COBBLESTONE_SLAB)
            .mossyCobblestoneWall(Blocks.MOSSY_COBBLESTONE_WALL)
            .mossyStoneBricks(Blocks.MOSSY_STONE_BRICKS)
            .mossyStoneBrickStairs(Blocks.MOSSY_STONE_BRICK_STAIRS)
            .mossyStoneBrickSlab(Blocks.MOSSY_STONE_BRICK_SLAB)
            .mossyStoneBrickWall(Blocks.MOSSY_STONE_BRICK_WALL)
            .stone(Blocks.STRIPPED_BIRCH_LOG)
            .stoneBlend(Blocks.STONE_BRICKS, 7, Blocks.MOSSY_COBBLESTONE, 5)
            .stoneStairs(Blocks.BIRCH_STAIRS)
            .stoneSlab(Blocks.BIRCH_SLAB)
            .leaves(Blocks.BIRCH_LEAVES)
            .dirt(Blocks.DIRT)
            .wallVineChance(20)
            .build();

    // 6. Taiga
    public static final BiomePalette TAIGA = BiomePalette.builder()
            .planks(Blocks.SPRUCE_PLANKS)
            .planksBlend(Blocks.STRIPPED_SPRUCE_WOOD, 6)
            .log(Blocks.SPRUCE_LOG)
            .wood(Blocks.SPRUCE_WOOD)
            .strippedLog(Blocks.STRIPPED_SPRUCE_LOG)
            .strippedWood(Blocks.STRIPPED_SPRUCE_WOOD)
            .stairs(Blocks.SPRUCE_STAIRS)
            .slab(Blocks.SPRUCE_SLAB)
            .fence(Blocks.SPRUCE_FENCE)
            .fenceGate(Blocks.SPRUCE_FENCE_GATE)
            .door(Blocks.SPRUCE_DOOR)
            .trapdoor(Blocks.SPRUCE_TRAPDOOR)
            .pressurePlate(Blocks.SPRUCE_PRESSURE_PLATE)
            .button(Blocks.SPRUCE_BUTTON)
            .stoneBricks(Blocks.SPRUCE_PLANKS)
            .stoneBrickBlend(Blocks.STRIPPED_SPRUCE_WOOD, 6, Blocks.MOSSY_COBBLESTONE, 4, Blocks.COBBLESTONE, 3)
            .crackedStoneBricks(Blocks.STRIPPED_SPRUCE_WOOD)
            .stoneBrickStairs(Blocks.SPRUCE_STAIRS)
            .stoneBrickSlab(Blocks.SPRUCE_SLAB)
            .stoneBrickWall(Blocks.SPRUCE_FENCE)
            .chiseledStoneBricks(Blocks.SPRUCE_LOG)
            .cobblestone(Blocks.MOSSY_COBBLESTONE)
            .cobblestoneBlend(Blocks.COBBLESTONE, 8, Blocks.STRIPPED_SPRUCE_WOOD, 5)
            .cobblestoneStairs(Blocks.SPRUCE_STAIRS)
            .cobblestoneSlab(Blocks.SPRUCE_SLAB)
            .cobblestoneWall(Blocks.SPRUCE_FENCE)
            .mossyCobblestone(Blocks.MOSSY_COBBLESTONE)
            .mossyCobblestoneStairs(Blocks.MOSSY_COBBLESTONE_STAIRS)
            .mossyCobblestoneSlab(Blocks.MOSSY_COBBLESTONE_SLAB)
            .mossyCobblestoneWall(Blocks.MOSSY_COBBLESTONE_WALL)
            .mossyStoneBricks(Blocks.MOSSY_STONE_BRICKS)
            .mossyStoneBrickStairs(Blocks.MOSSY_STONE_BRICK_STAIRS)
            .mossyStoneBrickSlab(Blocks.MOSSY_STONE_BRICK_SLAB)
            .mossyStoneBrickWall(Blocks.MOSSY_STONE_BRICK_WALL)
            .stone(Blocks.STRIPPED_SPRUCE_LOG)
            .stoneBlend(Blocks.COBBLESTONE, 7, Blocks.MOSSY_COBBLESTONE, 5)
            .stoneStairs(Blocks.SPRUCE_STAIRS)
            .stoneSlab(Blocks.SPRUCE_SLAB)
            .leaves(Blocks.SPRUCE_LEAVES)
            .dirt(Blocks.COARSE_DIRT)
            .wallVineChance(12)
            .build();

    // 7. Snowy Biomes (Snow and Calcite instead of wood/ice; wood kept only for fences/doors)
    public static final BiomePalette SNOWY = BiomePalette.builder()
            .planks(Blocks.SNOW_BLOCK)
            .planksBlend(Blocks.CALCITE, 8)
            .log(Blocks.CALCITE)
            .wood(Blocks.SNOW_BLOCK)
            .strippedLog(Blocks.CALCITE)
            .strippedWood(Blocks.SNOW_BLOCK)
            .stairs(Blocks.SMOOTH_QUARTZ_STAIRS)
            .slab(Blocks.SMOOTH_QUARTZ_SLAB)
            .fence(Blocks.SPRUCE_FENCE)
            .fenceGate(Blocks.SPRUCE_FENCE_GATE)
            .door(Blocks.SPRUCE_DOOR)
            .trapdoor(Blocks.SPRUCE_TRAPDOOR)
            .pressurePlate(Blocks.SPRUCE_PRESSURE_PLATE)
            .button(Blocks.SPRUCE_BUTTON)
            .stoneBricks(Blocks.CALCITE)
            .stoneBrickBlend(Blocks.SNOW_BLOCK, 10)
            .crackedStoneBricks(Blocks.SNOW_BLOCK)
            .stoneBrickStairs(Blocks.SMOOTH_QUARTZ_STAIRS)
            .stoneBrickSlab(Blocks.SMOOTH_QUARTZ_SLAB)
            .stoneBrickWall(Blocks.SPRUCE_FENCE)
            .chiseledStoneBricks(Blocks.CALCITE)
            .cobblestone(Blocks.SNOW_BLOCK)
            .cobblestoneBlend(Blocks.CALCITE, 10)
            .cobblestoneStairs(Blocks.SMOOTH_QUARTZ_STAIRS)
            .cobblestoneSlab(Blocks.SMOOTH_QUARTZ_SLAB)
            .cobblestoneWall(Blocks.SPRUCE_FENCE)
            .mossyCobblestone(Blocks.CALCITE)
            .mossyCobblestoneStairs(Blocks.SMOOTH_QUARTZ_STAIRS)
            .mossyCobblestoneSlab(Blocks.SMOOTH_QUARTZ_SLAB)
            .mossyCobblestoneWall(Blocks.SPRUCE_FENCE)
            .mossyStoneBricks(Blocks.SNOW_BLOCK)
            .mossyStoneBrickStairs(Blocks.SMOOTH_QUARTZ_STAIRS)
            .mossyStoneBrickSlab(Blocks.SMOOTH_QUARTZ_SLAB)
            .mossyStoneBrickWall(Blocks.SPRUCE_FENCE)
            .stone(Blocks.CALCITE)
            .stoneBlend(Blocks.SNOW_BLOCK, 10)
            .stoneStairs(Blocks.SMOOTH_QUARTZ_STAIRS)
            .stoneSlab(Blocks.SMOOTH_QUARTZ_SLAB)
            .leaves(Blocks.SPRUCE_LEAVES)
            .dirt(Blocks.SNOW_BLOCK)
            .wallVineChance(6)
            .build();

    // 8. Savanna
    public static final BiomePalette SAVANNA = BiomePalette.builder()
            .planks(Blocks.ACACIA_PLANKS)
            .planksBlend(Blocks.STRIPPED_ACACIA_WOOD, 6, Blocks.TERRACOTTA, 4)
            .log(Blocks.ACACIA_LOG)
            .wood(Blocks.ACACIA_WOOD)
            .strippedLog(Blocks.STRIPPED_ACACIA_LOG)
            .strippedWood(Blocks.STRIPPED_ACACIA_WOOD)
            .stairs(Blocks.ACACIA_STAIRS)
            .slab(Blocks.ACACIA_SLAB)
            .fence(Blocks.ACACIA_FENCE)
            .fenceGate(Blocks.ACACIA_FENCE_GATE)
            .door(Blocks.ACACIA_DOOR)
            .trapdoor(Blocks.ACACIA_TRAPDOOR)
            .pressurePlate(Blocks.ACACIA_PRESSURE_PLATE)
            .button(Blocks.ACACIA_BUTTON)
            .stoneBricks(Blocks.ACACIA_PLANKS)
            .stoneBrickBlend(Blocks.STRIPPED_ACACIA_WOOD, 6, Blocks.TERRACOTTA, 5, ORANGE_TERRACOTTA, 3)
            .crackedStoneBricks(Blocks.TERRACOTTA)
            .stoneBrickStairs(Blocks.ACACIA_STAIRS)
            .stoneBrickSlab(Blocks.ACACIA_SLAB)
            .stoneBrickWall(Blocks.ACACIA_FENCE)
            .chiseledStoneBricks(Blocks.ACACIA_LOG)
            .cobblestone(Blocks.TERRACOTTA)
            .cobblestoneBlend(ORANGE_TERRACOTTA, 7, Blocks.MUD_BRICKS, 5)
            .cobblestoneStairs(Blocks.ACACIA_STAIRS)
            .cobblestoneSlab(Blocks.ACACIA_SLAB)
            .cobblestoneWall(Blocks.ACACIA_FENCE)
            .mossyCobblestone(Blocks.MUD_BRICKS)
            .mossyCobblestoneStairs(Blocks.MUD_BRICK_STAIRS)
            .mossyCobblestoneSlab(Blocks.MUD_BRICK_SLAB)
            .mossyCobblestoneWall(Blocks.MUD_BRICK_WALL)
            .mossyStoneBricks(Blocks.MUD_BRICKS)
            .mossyStoneBrickStairs(Blocks.ACACIA_STAIRS)
            .mossyStoneBrickSlab(Blocks.ACACIA_SLAB)
            .mossyStoneBrickWall(Blocks.ACACIA_FENCE)
            .stone(Blocks.STRIPPED_ACACIA_LOG)
            .stoneBlend(Blocks.TERRACOTTA, 7, Blocks.PACKED_MUD, 5)
            .stoneStairs(Blocks.ACACIA_STAIRS)
            .stoneSlab(Blocks.ACACIA_SLAB)
            .leaves(Blocks.ACACIA_LEAVES)
            .dirt(Blocks.DIRT)
            .wallVineChance(8)
            .build();

    // 9. Swamp
    public static final BiomePalette SWAMP = BiomePalette.builder()
            .planks(Blocks.MANGROVE_PLANKS)
            .planksBlend(Blocks.STRIPPED_MANGROVE_WOOD, 6, Blocks.PACKED_MUD, 4)
            .log(Blocks.MANGROVE_LOG)
            .wood(Blocks.MANGROVE_WOOD)
            .strippedLog(Blocks.STRIPPED_MANGROVE_LOG)
            .strippedWood(Blocks.STRIPPED_MANGROVE_WOOD)
            .stairs(Blocks.MANGROVE_STAIRS)
            .slab(Blocks.MANGROVE_SLAB)
            .fence(Blocks.MANGROVE_FENCE)
            .fenceGate(Blocks.MANGROVE_FENCE_GATE)
            .door(Blocks.MANGROVE_DOOR)
            .trapdoor(Blocks.MANGROVE_TRAPDOOR)
            .pressurePlate(Blocks.MANGROVE_PRESSURE_PLATE)
            .button(Blocks.MANGROVE_BUTTON)
            .stoneBricks(Blocks.MUD_BRICKS)
            .stoneBrickBlend(Blocks.PACKED_MUD, 6, Blocks.MANGROVE_PLANKS, 4, Blocks.MUDDY_MANGROVE_ROOTS, 3)
            .crackedStoneBricks(Blocks.PACKED_MUD)
            .stoneBrickStairs(Blocks.MUD_BRICK_STAIRS)
            .stoneBrickSlab(Blocks.MUD_BRICK_SLAB)
            .stoneBrickWall(Blocks.MUD_BRICK_WALL)
            .chiseledStoneBricks(Blocks.MANGROVE_LOG)
            .cobblestone(Blocks.PACKED_MUD)
            .cobblestoneBlend(Blocks.MOSSY_COBBLESTONE, 7, Blocks.MUD_BRICKS, 5)
            .cobblestoneStairs(Blocks.MUD_BRICK_STAIRS)
            .cobblestoneSlab(Blocks.MUD_BRICK_SLAB)
            .cobblestoneWall(Blocks.MUD_BRICK_WALL)
            .mossyCobblestone(Blocks.MOSSY_COBBLESTONE)
            .mossyCobblestoneStairs(Blocks.MOSSY_COBBLESTONE_STAIRS)
            .mossyCobblestoneSlab(Blocks.MOSSY_COBBLESTONE_SLAB)
            .mossyCobblestoneWall(Blocks.MOSSY_COBBLESTONE_WALL)
            .mossyStoneBricks(Blocks.MUDDY_MANGROVE_ROOTS)
            .mossyStoneBrickStairs(Blocks.MUD_BRICK_STAIRS)
            .mossyStoneBrickSlab(Blocks.MUD_BRICK_SLAB)
            .mossyStoneBrickWall(Blocks.MUD_BRICK_WALL)
            .stone(Blocks.MUD_BRICKS)
            .stoneBlend(Blocks.PACKED_MUD, 8, Blocks.MUDDY_MANGROVE_ROOTS, 4)
            .stoneStairs(Blocks.MUD_BRICK_STAIRS)
            .stoneSlab(Blocks.MUD_BRICK_SLAB)
            .leaves(Blocks.MANGROVE_LEAVES)
            .dirt(Blocks.MUD)
            .wallVineChance(25)
            .build();

    // 10. Dark Forest
    public static final BiomePalette DARK_FOREST = BiomePalette.builder()
            .planks(Blocks.DARK_OAK_PLANKS)
            .planksBlend(Blocks.STRIPPED_DARK_OAK_WOOD, 6)
            .log(Blocks.DARK_OAK_LOG)
            .wood(Blocks.DARK_OAK_WOOD)
            .strippedLog(Blocks.STRIPPED_DARK_OAK_LOG)
            .strippedWood(Blocks.STRIPPED_DARK_OAK_WOOD)
            .stairs(Blocks.DARK_OAK_STAIRS)
            .slab(Blocks.DARK_OAK_SLAB)
            .fence(Blocks.DARK_OAK_FENCE)
            .fenceGate(Blocks.DARK_OAK_FENCE_GATE)
            .door(Blocks.DARK_OAK_DOOR)
            .trapdoor(Blocks.DARK_OAK_TRAPDOOR)
            .pressurePlate(Blocks.DARK_OAK_PRESSURE_PLATE)
            .button(Blocks.DARK_OAK_BUTTON)
            .stoneBricks(Blocks.DEEPSLATE_BRICKS)
            .stoneBrickBlend(Blocks.CRACKED_DEEPSLATE_BRICKS, 6, Blocks.DEEPSLATE_TILES, 4, Blocks.COBBLED_DEEPSLATE, 3)
            .crackedStoneBricks(Blocks.CRACKED_DEEPSLATE_BRICKS)
            .stoneBrickStairs(Blocks.DEEPSLATE_BRICK_STAIRS)
            .stoneBrickSlab(Blocks.DEEPSLATE_BRICK_SLAB)
            .stoneBrickWall(Blocks.DEEPSLATE_BRICK_WALL)
            .chiseledStoneBricks(Blocks.CHISELED_DEEPSLATE)
            .cobblestone(Blocks.COBBLED_DEEPSLATE)
            .cobblestoneBlend(Blocks.DEEPSLATE, 7, Blocks.POLISHED_DEEPSLATE, 5)
            .cobblestoneStairs(Blocks.COBBLED_DEEPSLATE_STAIRS)
            .cobblestoneSlab(Blocks.COBBLED_DEEPSLATE_SLAB)
            .cobblestoneWall(Blocks.COBBLED_DEEPSLATE_WALL)
            .mossyCobblestone(Blocks.MOSSY_COBBLESTONE)
            .mossyCobblestoneStairs(Blocks.COBBLED_DEEPSLATE_STAIRS)
            .mossyCobblestoneSlab(Blocks.COBBLED_DEEPSLATE_SLAB)
            .mossyCobblestoneWall(Blocks.COBBLED_DEEPSLATE_WALL)
            .mossyStoneBricks(Blocks.DEEPSLATE_TILES)
            .mossyStoneBrickStairs(Blocks.DEEPSLATE_TILE_STAIRS)
            .mossyStoneBrickSlab(Blocks.DEEPSLATE_TILE_SLAB)
            .mossyStoneBrickWall(Blocks.DEEPSLATE_TILE_WALL)
            .stone(Blocks.DEEPSLATE)
            .stoneBlend(Blocks.COBBLED_DEEPSLATE, 7, Blocks.POLISHED_DEEPSLATE, 5)
            .stoneStairs(Blocks.COBBLED_DEEPSLATE_STAIRS)
            .stoneSlab(Blocks.COBBLED_DEEPSLATE_SLAB)
            .leaves(Blocks.DARK_OAK_LEAVES)
            .dirt(Blocks.DIRT)
            .wallVineChance(20)
            .build();

    // 11. Cherry Grove
    public static final BiomePalette CHERRY_GROVE = BiomePalette.builder()
            .planks(Blocks.CHERRY_PLANKS)
            .planksBlend(Blocks.STRIPPED_CHERRY_WOOD, 6)
            .log(Blocks.CHERRY_LOG)
            .wood(Blocks.CHERRY_WOOD)
            .strippedLog(Blocks.STRIPPED_CHERRY_LOG)
            .strippedWood(Blocks.STRIPPED_CHERRY_WOOD)
            .stairs(Blocks.CHERRY_STAIRS)
            .slab(Blocks.CHERRY_SLAB)
            .fence(Blocks.CHERRY_FENCE)
            .fenceGate(Blocks.CHERRY_FENCE_GATE)
            .door(Blocks.CHERRY_DOOR)
            .trapdoor(Blocks.CHERRY_TRAPDOOR)
            .pressurePlate(Blocks.CHERRY_PRESSURE_PLATE)
            .button(Blocks.CHERRY_BUTTON)
            .stoneBricks(Blocks.CHERRY_PLANKS)
            .stoneBrickBlend(Blocks.STRIPPED_CHERRY_WOOD, 6, PINK_TERRACOTTA, 4, Blocks.CALCITE, 3)
            .crackedStoneBricks(Blocks.STRIPPED_CHERRY_WOOD)
            .stoneBrickStairs(Blocks.CHERRY_STAIRS)
            .stoneBrickSlab(Blocks.CHERRY_SLAB)
            .stoneBrickWall(Blocks.CHERRY_FENCE)
            .chiseledStoneBricks(Blocks.CHERRY_LOG)
            .cobblestone(Blocks.STRIPPED_CHERRY_WOOD)
            .cobblestoneBlend(Blocks.CALCITE, 7, PINK_TERRACOTTA, 5)
            .cobblestoneStairs(Blocks.CHERRY_STAIRS)
            .cobblestoneSlab(Blocks.CHERRY_SLAB)
            .cobblestoneWall(Blocks.CHERRY_FENCE)
            .mossyCobblestone(PINK_TERRACOTTA)
            .mossyCobblestoneStairs(Blocks.CHERRY_STAIRS)
            .mossyCobblestoneSlab(Blocks.CHERRY_SLAB)
            .mossyCobblestoneWall(Blocks.CHERRY_FENCE)
            .mossyStoneBricks(WHITE_TERRACOTTA)
            .mossyStoneBrickStairs(Blocks.CHERRY_STAIRS)
            .mossyStoneBrickSlab(Blocks.CHERRY_SLAB)
            .mossyStoneBrickWall(Blocks.CHERRY_FENCE)
            .stone(Blocks.STRIPPED_CHERRY_LOG)
            .stoneBlend(Blocks.STRIPPED_CHERRY_WOOD, 7, Blocks.CALCITE, 5)
            .stoneStairs(Blocks.CHERRY_STAIRS)
            .stoneSlab(Blocks.CHERRY_SLAB)
            .leaves(Blocks.CHERRY_LEAVES)
            .dirt(Blocks.DIRT)
            .wallVineChance(12)
            .build();

    // 12. Mushroom Fields (No red mushroom block in normal building palette; reserved for foliage/leaves only)
    public static final BiomePalette MUSHROOM_FIELDS = BiomePalette.builder()
            .planks(Blocks.BROWN_MUSHROOM_BLOCK)
            .planksBlend(Blocks.MUSHROOM_STEM, 7, Blocks.BIRCH_PLANKS, 4)
            .log(Blocks.MUSHROOM_STEM)
            .wood(Blocks.BROWN_MUSHROOM_BLOCK)
            .strippedLog(Blocks.MUSHROOM_STEM)
            .strippedWood(Blocks.STRIPPED_BIRCH_WOOD)
            .stairs(Blocks.BIRCH_STAIRS)
            .slab(Blocks.BIRCH_SLAB)
            .fence(Blocks.BIRCH_FENCE)
            .fenceGate(Blocks.BIRCH_FENCE_GATE)
            .door(Blocks.BIRCH_DOOR)
            .trapdoor(Blocks.BIRCH_TRAPDOOR)
            .pressurePlate(Blocks.BIRCH_PRESSURE_PLATE)
            .button(Blocks.BIRCH_BUTTON)
            .stoneBricks(Blocks.MUSHROOM_STEM)
            .stoneBrickBlend(Blocks.BROWN_MUSHROOM_BLOCK, 7, Blocks.BIRCH_PLANKS, 4)
            .crackedStoneBricks(Blocks.BROWN_MUSHROOM_BLOCK)
            .stoneBrickStairs(Blocks.BIRCH_STAIRS)
            .stoneBrickSlab(Blocks.BIRCH_SLAB)
            .stoneBrickWall(Blocks.BIRCH_FENCE)
            .chiseledStoneBricks(Blocks.STRIPPED_BIRCH_WOOD)
            .cobblestone(Blocks.BROWN_MUSHROOM_BLOCK)
            .cobblestoneBlend(Blocks.MUSHROOM_STEM, 7, Blocks.MYCELIUM, 4)
            .cobblestoneStairs(Blocks.BIRCH_STAIRS)
            .cobblestoneSlab(Blocks.BIRCH_SLAB)
            .cobblestoneWall(Blocks.BIRCH_FENCE)
            .mossyCobblestone(Blocks.MYCELIUM)
            .mossyCobblestoneStairs(Blocks.BIRCH_STAIRS)
            .mossyCobblestoneSlab(Blocks.BIRCH_SLAB)
            .mossyCobblestoneWall(Blocks.BIRCH_FENCE)
            .mossyStoneBricks(Blocks.BROWN_MUSHROOM_BLOCK)
            .mossyStoneBrickStairs(Blocks.BIRCH_STAIRS)
            .mossyStoneBrickSlab(Blocks.BIRCH_SLAB)
            .mossyStoneBrickWall(Blocks.BIRCH_FENCE)
            .stone(Blocks.MUSHROOM_STEM)
            .stoneBlend(Blocks.BROWN_MUSHROOM_BLOCK, 8, Blocks.BIRCH_PLANKS, 4)
            .stoneStairs(Blocks.BIRCH_STAIRS)
            .stoneSlab(Blocks.BIRCH_SLAB)
            .leaves(Blocks.RED_MUSHROOM_BLOCK)
            .dirt(Blocks.MYCELIUM)
            .wallVineChance(12)
            .build();

    // 13. Mountain Biomes
    public static final BiomePalette MOUNTAIN = BiomePalette.builder()
            .planks(Blocks.SPRUCE_PLANKS)
            .planksBlend(Blocks.STRIPPED_SPRUCE_WOOD, 6)
            .log(Blocks.SPRUCE_LOG)
            .wood(Blocks.SPRUCE_WOOD)
            .strippedLog(Blocks.STRIPPED_SPRUCE_LOG)
            .strippedWood(Blocks.STRIPPED_SPRUCE_WOOD)
            .stairs(Blocks.SPRUCE_STAIRS)
            .slab(Blocks.SPRUCE_SLAB)
            .fence(Blocks.SPRUCE_FENCE)
            .fenceGate(Blocks.SPRUCE_FENCE_GATE)
            .door(Blocks.SPRUCE_DOOR)
            .trapdoor(Blocks.SPRUCE_TRAPDOOR)
            .pressurePlate(Blocks.SPRUCE_PRESSURE_PLATE)
            .button(Blocks.SPRUCE_BUTTON)
            .stoneBricks(Blocks.POLISHED_ANDESITE)
            .stoneBrickBlend(Blocks.ANDESITE, 6, Blocks.TUFF_BRICKS, 4, Blocks.STONE_BRICKS, 3)
            .crackedStoneBricks(Blocks.CRACKED_STONE_BRICKS)
            .stoneBrickStairs(Blocks.POLISHED_ANDESITE_STAIRS)
            .stoneBrickSlab(Blocks.POLISHED_ANDESITE_SLAB)
            .stoneBrickWall(Blocks.ANDESITE_WALL)
            .chiseledStoneBricks(Blocks.CHISELED_DEEPSLATE)
            .cobblestone(Blocks.ANDESITE)
            .cobblestoneBlend(Blocks.TUFF, 7, Blocks.COBBLESTONE, 5)
            .cobblestoneStairs(Blocks.ANDESITE_STAIRS)
            .cobblestoneSlab(Blocks.ANDESITE_SLAB)
            .cobblestoneWall(Blocks.ANDESITE_WALL)
            .mossyCobblestone(Blocks.TUFF)
            .mossyCobblestoneStairs(Blocks.TUFF_STAIRS)
            .mossyCobblestoneSlab(Blocks.TUFF_SLAB)
            .mossyCobblestoneWall(Blocks.TUFF_WALL)
            .mossyStoneBricks(Blocks.DEEPSLATE_BRICKS)
            .mossyStoneBrickStairs(Blocks.DEEPSLATE_BRICK_STAIRS)
            .mossyStoneBrickSlab(Blocks.DEEPSLATE_BRICK_SLAB)
            .mossyStoneBrickWall(Blocks.DEEPSLATE_BRICK_WALL)
            .stone(Blocks.POLISHED_ANDESITE)
            .stoneBlend(Blocks.ANDESITE, 8, Blocks.TUFF, 4)
            .stoneStairs(Blocks.POLISHED_ANDESITE_STAIRS)
            .stoneSlab(Blocks.POLISHED_ANDESITE_SLAB)
            .leaves(Blocks.SPRUCE_LEAVES)
            .dirt(Blocks.GRAVEL)
            .wallVineChance(12)
            .build();

    // 14. Ocean / Beach
    public static final BiomePalette OCEAN_BEACH = BiomePalette.builder()
            .planks(Blocks.SANDSTONE)
            .planksBlend(Blocks.CUT_SANDSTONE, 6, Blocks.SMOOTH_SANDSTONE, 4)
            .log(Blocks.SMOOTH_SANDSTONE)
            .wood(Blocks.CUT_SANDSTONE)
            .strippedLog(Blocks.SMOOTH_SANDSTONE)
            .strippedWood(Blocks.CUT_SANDSTONE)
            .stairs(Blocks.SANDSTONE_STAIRS)
            .slab(Blocks.SANDSTONE_SLAB)
            .fence(Blocks.SANDSTONE_WALL)
            .fenceGate(Blocks.BIRCH_FENCE_GATE)
            .door(Blocks.BIRCH_DOOR)
            .trapdoor(Blocks.BIRCH_TRAPDOOR)
            .pressurePlate(Blocks.BIRCH_PRESSURE_PLATE)
            .button(Blocks.BIRCH_BUTTON)
            .stoneBricks(Blocks.PRISMARINE_BRICKS)
            .stoneBrickBlend(Blocks.PRISMARINE, 6, Blocks.DARK_PRISMARINE, 4, Blocks.SMOOTH_SANDSTONE, 3)
            .crackedStoneBricks(Blocks.PRISMARINE)
            .stoneBrickStairs(Blocks.PRISMARINE_BRICK_STAIRS)
            .stoneBrickSlab(Blocks.PRISMARINE_BRICK_SLAB)
            .stoneBrickWall(Blocks.PRISMARINE_WALL)
            .chiseledStoneBricks(Blocks.CHISELED_SANDSTONE)
            .cobblestone(Blocks.SANDSTONE)
            .cobblestoneBlend(Blocks.CUT_SANDSTONE, 7, Blocks.PRISMARINE, 5)
            .cobblestoneStairs(Blocks.SANDSTONE_STAIRS)
            .cobblestoneSlab(Blocks.SANDSTONE_SLAB)
            .cobblestoneWall(Blocks.SANDSTONE_WALL)
            .mossyCobblestone(Blocks.PRISMARINE)
            .mossyCobblestoneStairs(Blocks.PRISMARINE_STAIRS)
            .mossyCobblestoneSlab(Blocks.PRISMARINE_SLAB)
            .mossyCobblestoneWall(Blocks.PRISMARINE_WALL)
            .mossyStoneBricks(Blocks.DARK_PRISMARINE)
            .mossyStoneBrickStairs(Blocks.DARK_PRISMARINE_STAIRS)
            .mossyStoneBrickSlab(Blocks.DARK_PRISMARINE_SLAB)
            .mossyStoneBrickWall(Blocks.PRISMARINE_WALL)
            .stone(Blocks.SMOOTH_SANDSTONE)
            .stoneBlend(Blocks.SANDSTONE, 7, Blocks.PRISMARINE, 5)
            .stoneStairs(Blocks.SANDSTONE_STAIRS)
            .stoneSlab(Blocks.SANDSTONE_SLAB)
            .leaves(Blocks.PRISMARINE_BRICKS)
            .dirt(Blocks.SAND)
            .wallVineChance(6)
            .build();

    private static final Map<ResourceKey<Biome>, BiomePalette> CUSTOM_PALETTES = new ConcurrentHashMap<>();

    public static void registerCustomPalette(ResourceKey<Biome> biomeKey, BiomePalette palette) {
        CUSTOM_PALETTES.put(biomeKey, palette);
    }

    public static BiomePalette getPaletteForBiome(Holder<Biome> biomeHolder) {
        if (biomeHolder == null) {
            return PLAINS;
        }

        Optional<ResourceKey<Biome>> keyOpt = biomeHolder.unwrapKey();
        if (keyOpt.isPresent()) {
            ResourceKey<Biome> key = keyOpt.get();
            if (CUSTOM_PALETTES.containsKey(key)) {
                return CUSTOM_PALETTES.get(key);
            }

            // Specific vanilla biomes
            if (key.equals(Biomes.DESERT)) return DESERT;
            if (key.equals(Biomes.BADLANDS) || key.equals(Biomes.ERODED_BADLANDS) || key.equals(Biomes.WOODED_BADLANDS)) return BADLANDS;
            if (key.equals(Biomes.JUNGLE) || key.equals(Biomes.SPARSE_JUNGLE) || key.equals(Biomes.BAMBOO_JUNGLE)) return JUNGLE;
            if (key.equals(Biomes.CHERRY_GROVE)) return CHERRY_GROVE;
            if (key.equals(Biomes.DARK_FOREST)) return DARK_FOREST;
            if (key.equals(Biomes.SWAMP) || key.equals(Biomes.MANGROVE_SWAMP)) return SWAMP;
            if (key.equals(Biomes.MUSHROOM_FIELDS)) return MUSHROOM_FIELDS;
            if (key.equals(Biomes.SNOWY_PLAINS) || key.equals(Biomes.ICE_SPIKES) || key.equals(Biomes.SNOWY_TAIGA)
                    || key.equals(Biomes.SNOWY_BEACH) || key.equals(Biomes.GROVE) || key.equals(Biomes.SNOWY_SLOPES)
                    || key.equals(Biomes.JAGGED_PEAKS) || key.equals(Biomes.FROZEN_PEAKS)) {
                return SNOWY;
            }
            if (key.equals(Biomes.TAIGA) || key.equals(Biomes.OLD_GROWTH_PINE_TAIGA) || key.equals(Biomes.OLD_GROWTH_SPRUCE_TAIGA)) return TAIGA;
            if (key.equals(Biomes.SAVANNA) || key.equals(Biomes.SAVANNA_PLATEAU) || key.equals(Biomes.WINDSWEPT_SAVANNA)) return SAVANNA;
            if (key.equals(Biomes.FOREST) || key.equals(Biomes.FLOWER_FOREST) || key.equals(Biomes.BIRCH_FOREST) || key.equals(Biomes.OLD_GROWTH_BIRCH_FOREST)) return FOREST;
            if (key.equals(Biomes.STONY_PEAKS) || key.equals(Biomes.WINDSWEPT_HILLS) || key.equals(Biomes.WINDSWEPT_GRAVELLY_HILLS) || key.equals(Biomes.WINDSWEPT_FOREST)) return MOUNTAIN;
            if (key.equals(Biomes.BEACH) || key.equals(Biomes.STONY_SHORE) || key.equals(Biomes.WARM_OCEAN) || key.equals(Biomes.LUKEWARM_OCEAN)
                    || key.equals(Biomes.DEEP_LUKEWARM_OCEAN) || key.equals(Biomes.OCEAN) || key.equals(Biomes.DEEP_OCEAN)
                    || key.equals(Biomes.COLD_OCEAN) || key.equals(Biomes.DEEP_COLD_OCEAN) || key.equals(Biomes.FROZEN_OCEAN)
                    || key.equals(Biomes.DEEP_FROZEN_OCEAN)) {
                return OCEAN_BEACH;
            }
            if (key.equals(Biomes.PLAINS) || key.equals(Biomes.SUNFLOWER_PLAINS) || key.equals(Biomes.MEADOW)) return PLAINS;
        }

        // Biome Tags
        if (biomeHolder.is(BiomeTags.IS_BADLANDS)) return BADLANDS;
        if (biomeHolder.is(BiomeTags.IS_JUNGLE)) return JUNGLE;
        if (biomeHolder.is(BiomeTags.IS_SAVANNA)) return SAVANNA;
        if (biomeHolder.is(BiomeTags.IS_OCEAN) || biomeHolder.is(BiomeTags.IS_DEEP_OCEAN) || biomeHolder.is(BiomeTags.IS_BEACH)) return OCEAN_BEACH;
        if (biomeHolder.is(BiomeTags.SPAWNS_SNOW_FOXES) || biomeHolder.is(BiomeTags.SPAWNS_WHITE_RABBITS) || biomeHolder.is(BiomeTags.HAS_VILLAGE_SNOWY)) return SNOWY;
        if (biomeHolder.is(BiomeTags.IS_TAIGA)) return TAIGA;
        if (biomeHolder.is(BiomeTags.IS_MOUNTAIN) || biomeHolder.is(BiomeTags.IS_HILL)) return MOUNTAIN;
        if (biomeHolder.is(BiomeTags.IS_FOREST)) return FOREST;

        // Keyword matching on path for modded biomes
        if (keyOpt.isPresent()) {
            //? if >=26.1 {
            String path = keyOpt.get().identifier().getPath().toLowerCase(Locale.ROOT);
            //?} else {
            /*String path = keyOpt.get().location().getPath().toLowerCase(Locale.ROOT);
            *///?}
            if (path.contains("desert")) return DESERT;
            if (path.contains("badland") || path.contains("mesa")) return BADLANDS;
            if (path.contains("jungle") || path.contains("bamboo")) return JUNGLE;
            if (path.contains("cherry")) return CHERRY_GROVE;
            if (path.contains("dark_forest") || path.contains("dark_oak") || path.contains("roofed")) return DARK_FOREST;
            if (path.contains("swamp") || path.contains("marsh") || path.contains("bayou") || path.contains("mangrove")) return SWAMP;
            if (path.contains("mushroom") || path.contains("fungus")) return MUSHROOM_FIELDS;
            if (path.contains("snow") || path.contains("ice") || path.contains("frozen") || path.contains("frost") || path.contains("cold")) return SNOWY;
            if (path.contains("taiga") || path.contains("pine") || path.contains("spruce")) return TAIGA;
            if (path.contains("savanna") || path.contains("steppe")) return SAVANNA;
            if (path.contains("mountain") || path.contains("peak") || path.contains("cliff") || path.contains("crag") || path.contains("alps")) return MOUNTAIN;
            if (path.contains("ocean") || path.contains("beach") || path.contains("coast") || path.contains("shore") || path.contains("sea")) return OCEAN_BEACH;
            if (path.contains("forest") || path.contains("wood") || path.contains("birch")) return FOREST;
            if (path.contains("plains") || path.contains("prairie") || path.contains("field") || path.contains("meadow") || path.contains("grassland")) return PLAINS;
        }

        // Sensible fallback
        return PLAINS;
    }

    private BiomePalettes() {}
}
