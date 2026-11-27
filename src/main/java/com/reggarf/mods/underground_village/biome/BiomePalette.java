package com.reggarf.mods.underground_village.biome;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;

public class BiomePalette {

    private final Block planks;
    private final Block log;
    private final Block wood;
    private final Block strippedLog;
    private final Block strippedWood;
    private final Block stairs;
    private final Block slab;
    private final Block fence;
    private final Block fenceGate;
    private final Block door;
    private final Block trapdoor;
    private final Block pressurePlate;
    private final Block button;

    private final Block stoneBricks;
    private final Block crackedStoneBricks;
    private final Block stoneBrickStairs;
    private final Block stoneBrickSlab;
    private final Block stoneBrickWall;
    private final Block chiseledStoneBricks;

    private final Block cobblestone;
    private final Block cobblestoneStairs;
    private final Block cobblestoneSlab;
    private final Block cobblestoneWall;

    private final Block mossyCobblestone;
    private final Block mossyCobblestoneStairs;
    private final Block mossyCobblestoneSlab;
    private final Block mossyCobblestoneWall;

    private final Block mossyStoneBricks;
    private final Block mossyStoneBrickStairs;
    private final Block mossyStoneBrickSlab;
    private final Block mossyStoneBrickWall;

    private final Block stone;
    private final Block stoneStairs;
    private final Block stoneSlab;

    private final Block leaves;
    private final Block dirt;
    private final int wallVineChance;

    private final Block[] stoneBrickBlendBlocks;
    private final int[] stoneBrickBlendThresholds;
    private final Block[] cobblestoneBlendBlocks;
    private final int[] cobblestoneBlendThresholds;
    private final Block[] stoneBlendBlocks;
    private final int[] stoneBlendThresholds;
    private final Block[] planksBlendBlocks;
    private final int[] planksBlendThresholds;

    public BiomePalette(Builder builder) {
        this.planks = builder.planks;
        this.log = builder.log;
        this.wood = builder.wood;
        this.strippedLog = builder.strippedLog;
        this.strippedWood = builder.strippedWood;
        this.stairs = builder.stairs;
        this.slab = builder.slab;
        this.fence = builder.fence;
        this.fenceGate = builder.fenceGate;
        this.door = builder.door;
        this.trapdoor = builder.trapdoor;
        this.pressurePlate = builder.pressurePlate;
        this.button = builder.button;
        this.stoneBricks = builder.stoneBricks;
        this.crackedStoneBricks = builder.crackedStoneBricks;
        this.stoneBrickStairs = builder.stoneBrickStairs;
        this.stoneBrickSlab = builder.stoneBrickSlab;
        this.stoneBrickWall = builder.stoneBrickWall;
        this.chiseledStoneBricks = builder.chiseledStoneBricks;
        this.cobblestone = builder.cobblestone;
        this.cobblestoneStairs = builder.cobblestoneStairs;
        this.cobblestoneSlab = builder.cobblestoneSlab;
        this.cobblestoneWall = builder.cobblestoneWall;
        this.mossyCobblestone = builder.mossyCobblestone;
        this.mossyCobblestoneStairs = builder.mossyCobblestoneStairs;
        this.mossyCobblestoneSlab = builder.mossyCobblestoneSlab;
        this.mossyCobblestoneWall = builder.mossyCobblestoneWall;
        this.mossyStoneBricks = builder.mossyStoneBricks;
        this.mossyStoneBrickStairs = builder.mossyStoneBrickStairs;
        this.mossyStoneBrickSlab = builder.mossyStoneBrickSlab;
        this.mossyStoneBrickWall = builder.mossyStoneBrickWall;
        this.stone = builder.stone;
        this.stoneStairs = builder.stoneStairs;
        this.stoneSlab = builder.stoneSlab;
        this.leaves = builder.leaves;
        this.dirt = builder.dirt;
        this.wallVineChance = builder.wallVineChance;

        this.stoneBrickBlendBlocks = builder.stoneBrickBlendBlocks;
        this.stoneBrickBlendThresholds = builder.stoneBrickBlendThresholds;
        this.cobblestoneBlendBlocks = builder.cobblestoneBlendBlocks;
        this.cobblestoneBlendThresholds = builder.cobblestoneBlendThresholds;
        this.stoneBlendBlocks = builder.stoneBlendBlocks;
        this.stoneBlendThresholds = builder.stoneBlendThresholds;
        this.planksBlendBlocks = builder.planksBlendBlocks;
        this.planksBlendThresholds = builder.planksBlendThresholds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Block getPlanks() { return planks; }
    public Block getLog() { return log; }
    public Block getWood() { return wood; }
    public Block getStrippedLog() { return strippedLog; }
    public Block getStrippedWood() { return strippedWood; }
    public Block getStairs() { return stairs; }
    public Block getSlab() { return slab; }
    public Block getFence() { return fence; }
    public Block getFenceGate() { return fenceGate; }
    public Block getDoor() { return door; }
    public Block getTrapdoor() { return trapdoor; }
    public Block getPressurePlate() { return pressurePlate; }
    public Block getButton() { return button; }
    public Block getStoneBricks() { return stoneBricks; }
    public Block getCrackedStoneBricks() { return crackedStoneBricks; }
    public Block getStoneBrickStairs() { return stoneBrickStairs; }
    public Block getStoneBrickSlab() { return stoneBrickSlab; }
    public Block getStoneBrickWall() { return stoneBrickWall; }
    public Block getChiseledStoneBricks() { return chiseledStoneBricks; }
    public Block getCobblestone() { return cobblestone; }
    public Block getCobblestoneStairs() { return cobblestoneStairs; }
    public Block getCobblestoneSlab() { return cobblestoneSlab; }
    public Block getCobblestoneWall() { return cobblestoneWall; }
    public Block getMossyCobblestone() { return mossyCobblestone; }
    public Block getMossyCobblestoneStairs() { return mossyCobblestoneStairs; }
    public Block getMossyCobblestoneSlab() { return mossyCobblestoneSlab; }
    public Block getMossyCobblestoneWall() { return mossyCobblestoneWall; }
    public Block getMossyStoneBricks() { return mossyStoneBricks; }
    public Block getMossyStoneBrickStairs() { return mossyStoneBrickStairs; }
    public Block getMossyStoneBrickSlab() { return mossyStoneBrickSlab; }
    public Block getMossyStoneBrickWall() { return mossyStoneBrickWall; }
    public Block getStone() { return stone; }
    public Block getStoneStairs() { return stoneStairs; }
    public Block getStoneSlab() { return stoneSlab; }
    public Block getLeaves() { return leaves; }
    public Block getDirt() { return dirt; }
    public int getWallVineChance() { return wallVineChance; }

    public BlockState transform(BlockState originalState, LevelReader level, BlockPos pos) {
        Block b = originalState.getBlock();
        Block target = null;

        if (b == Blocks.OAK_PLANKS || b == Blocks.SPRUCE_PLANKS) {
            target = pickBlended(planks, planksBlendBlocks, planksBlendThresholds, pos);
        } else if (b == Blocks.OAK_LOG || b == Blocks.SPRUCE_LOG) {
            target = log;
        } else if (b == Blocks.OAK_WOOD || b == Blocks.SPRUCE_WOOD) {
            target = wood;
        } else if (b == Blocks.STRIPPED_SPRUCE_LOG || b == Blocks.STRIPPED_BIRCH_LOG) {
            target = strippedLog;
        } else if (b == Blocks.STRIPPED_SPRUCE_WOOD) {
            target = strippedWood;
        } else if (b == Blocks.OAK_STAIRS || b == Blocks.SPRUCE_STAIRS) {
            target = stairs;
        } else if (b == Blocks.OAK_SLAB || b == Blocks.SPRUCE_SLAB) {
            target = slab;
        } else if (b == Blocks.OAK_FENCE || b == Blocks.SPRUCE_FENCE || b == Blocks.BIRCH_FENCE) {
            target = fence;
        } else if (b == Blocks.SPRUCE_FENCE_GATE || b == Blocks.OAK_FENCE_GATE) {
            target = fenceGate;
        } else if (b == Blocks.SPRUCE_DOOR || b == Blocks.OAK_DOOR) {
            target = door;
        } else if (b == Blocks.SPRUCE_TRAPDOOR || b == Blocks.BIRCH_TRAPDOOR || b == Blocks.OAK_TRAPDOOR) {
            target = trapdoor;
        } else if (b == Blocks.SPRUCE_PRESSURE_PLATE || b == Blocks.OAK_PRESSURE_PLATE) {
            target = pressurePlate;
        } else if (b == Blocks.SPRUCE_BUTTON || b == Blocks.OAK_BUTTON) {
            target = button;
        } else if (b == Blocks.STONE_BRICKS || b == Blocks.INFESTED_STONE_BRICKS) {
            target = pickBlended(stoneBricks, stoneBrickBlendBlocks, stoneBrickBlendThresholds, pos);
        } else if (b == Blocks.CRACKED_STONE_BRICKS || b == Blocks.INFESTED_CRACKED_STONE_BRICKS) {
            target = crackedStoneBricks;
        } else if (b == Blocks.STONE_BRICK_STAIRS) {
            target = stoneBrickStairs;
        } else if (b == Blocks.STONE_BRICK_SLAB) {
            target = stoneBrickSlab;
        } else if (b == Blocks.STONE_BRICK_WALL) {
            target = stoneBrickWall;
        } else if (b == Blocks.CHISELED_STONE_BRICKS || b == Blocks.INFESTED_CHISELED_STONE_BRICKS) {
            target = chiseledStoneBricks;
        } else if (b == Blocks.COBBLESTONE || b == Blocks.INFESTED_COBBLESTONE) {
            target = pickBlended(cobblestone, cobblestoneBlendBlocks, cobblestoneBlendThresholds, pos);
        } else if (b == Blocks.COBBLESTONE_STAIRS) {
            target = cobblestoneStairs;
        } else if (b == Blocks.COBBLESTONE_SLAB) {
            target = cobblestoneSlab;
        } else if (b == Blocks.COBBLESTONE_WALL) {
            target = cobblestoneWall;
        } else if (b == Blocks.MOSSY_COBBLESTONE) {
            target = mossyCobblestone;
        } else if (b == Blocks.MOSSY_COBBLESTONE_STAIRS) {
            target = mossyCobblestoneStairs;
        } else if (b == Blocks.MOSSY_COBBLESTONE_SLAB) {
            target = mossyCobblestoneSlab;
        } else if (b == Blocks.MOSSY_COBBLESTONE_WALL) {
            target = mossyCobblestoneWall;
        } else if (b == Blocks.MOSSY_STONE_BRICKS || b == Blocks.INFESTED_MOSSY_STONE_BRICKS) {
            target = mossyStoneBricks;
        } else if (b == Blocks.MOSSY_STONE_BRICK_STAIRS) {
            target = mossyStoneBrickStairs;
        } else if (b == Blocks.MOSSY_STONE_BRICK_SLAB) {
            target = mossyStoneBrickSlab;
        } else if (b == Blocks.MOSSY_STONE_BRICK_WALL) {
            target = mossyStoneBrickWall;
        } else if (b == Blocks.STONE || b == Blocks.INFESTED_STONE || b == Blocks.SMOOTH_STONE) {
            target = pickBlended(stone, stoneBlendBlocks, stoneBlendThresholds, pos);
        } else if (b == Blocks.STONE_STAIRS) {
            target = stoneStairs;
        } else if (b == Blocks.STONE_SLAB || b == Blocks.SMOOTH_STONE_SLAB) {
            target = stoneSlab;
        } else if (b == Blocks.OAK_LEAVES || b == Blocks.SPRUCE_LEAVES || b == Blocks.BIRCH_LEAVES) {
            target = leaves;
        } else if (dirt != null && dirt != Blocks.DIRT
                && (b == Blocks.DIRT || b == Blocks.COARSE_DIRT || b == Blocks.GRASS_BLOCK || b == Blocks.DIRT_PATH)) {
            target = dirt;
        }

        if (target == null || target == b) {
            return originalState;
        }

        BlockState newState = target.defaultBlockState();
        return copyBlockStateProperties(originalState, newState);
    }

    private static Block pickBlended(Block primary, Block[] blocks, int[] thresholds, BlockPos pos) {
        if (blocks == null || thresholds == null || blocks.length == 0 || pos == null) {
            return primary;
        }
        int h = pos.getX() * 374761393 + pos.getY() * 668265263 + pos.getZ() * 1442695041;
        h = (h ^ (h >>> 13)) * 1274126177;
        int roll = ((h ^ (h >>> 16)) & 0x7FFFFFFF) % 100;
        for (int i = 0; i < thresholds.length; i++) {
            if (roll < thresholds[i]) {
                return blocks[i];
            }
        }
        return primary;
    }

    public static BlockState copyBlockStateProperties(BlockState from, BlockState to) {
        // Direct property transfer
        for (Property<?> prop : from.getProperties()) {
            if (to.hasProperty(prop)) {
                to = copySingleProperty(from, to, prop);
            }
        }

        // Fence <-> Wall connection conversion
        boolean fromIsFence = from.hasProperty(BlockStateProperties.NORTH) && !from.hasProperty(BlockStateProperties.UP);
        boolean toIsWall = to.hasProperty(BlockStateProperties.UP);

        if (fromIsFence && toIsWall) {
            if (to.hasProperty(BlockStateProperties.NORTH_WALL)) {
                to = to.setValue(BlockStateProperties.NORTH_WALL, from.getValue(BlockStateProperties.NORTH) ? WallSide.LOW : WallSide.NONE);
            }
            if (to.hasProperty(BlockStateProperties.EAST_WALL)) {
                to = to.setValue(BlockStateProperties.EAST_WALL, from.getValue(BlockStateProperties.EAST) ? WallSide.LOW : WallSide.NONE);
            }
            if (to.hasProperty(BlockStateProperties.SOUTH_WALL)) {
                to = to.setValue(BlockStateProperties.SOUTH_WALL, from.getValue(BlockStateProperties.SOUTH) ? WallSide.LOW : WallSide.NONE);
            }
            if (to.hasProperty(BlockStateProperties.WEST_WALL)) {
                to = to.setValue(BlockStateProperties.WEST_WALL, from.getValue(BlockStateProperties.WEST) ? WallSide.LOW : WallSide.NONE);
            }
            to = to.setValue(BlockStateProperties.UP, true);
        } else if (!fromIsFence && from.hasProperty(BlockStateProperties.UP) && to.hasProperty(BlockStateProperties.NORTH) && !to.hasProperty(BlockStateProperties.UP)) {
            // Wall -> Fence
            if (from.hasProperty(BlockStateProperties.NORTH_WALL)) {
                to = to.setValue(BlockStateProperties.NORTH, from.getValue(BlockStateProperties.NORTH_WALL) != WallSide.NONE);
            }
            if (from.hasProperty(BlockStateProperties.EAST_WALL)) {
                to = to.setValue(BlockStateProperties.EAST, from.getValue(BlockStateProperties.EAST_WALL) != WallSide.NONE);
            }
            if (from.hasProperty(BlockStateProperties.SOUTH_WALL)) {
                to = to.setValue(BlockStateProperties.SOUTH, from.getValue(BlockStateProperties.SOUTH_WALL) != WallSide.NONE);
            }
            if (from.hasProperty(BlockStateProperties.WEST_WALL)) {
                to = to.setValue(BlockStateProperties.WEST, from.getValue(BlockStateProperties.WEST_WALL) != WallSide.NONE);
            }
        }

        return to;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> BlockState copySingleProperty(BlockState from, BlockState to, Property<T> prop) {
        return to.setValue(prop, from.getValue(prop));
    }

    public static class Builder {
        private Block planks = Blocks.OAK_PLANKS;
        private Block log = Blocks.OAK_LOG;
        private Block wood = Blocks.OAK_WOOD;
        private Block strippedLog = Blocks.STRIPPED_SPRUCE_LOG;
        private Block strippedWood = Blocks.STRIPPED_SPRUCE_WOOD;
        private Block stairs = Blocks.OAK_STAIRS;
        private Block slab = Blocks.OAK_SLAB;
        private Block fence = Blocks.OAK_FENCE;
        private Block fenceGate = Blocks.SPRUCE_FENCE_GATE;
        private Block door = Blocks.SPRUCE_DOOR;
        private Block trapdoor = Blocks.SPRUCE_TRAPDOOR;
        private Block pressurePlate = Blocks.SPRUCE_PRESSURE_PLATE;
        private Block button = Blocks.SPRUCE_BUTTON;

        private Block stoneBricks = Blocks.STONE_BRICKS;
        private Block crackedStoneBricks = Blocks.CRACKED_STONE_BRICKS;
        private Block stoneBrickStairs = Blocks.STONE_BRICK_STAIRS;
        private Block stoneBrickSlab = Blocks.STONE_BRICK_SLAB;
        private Block stoneBrickWall = Blocks.STONE_BRICK_WALL;
        private Block chiseledStoneBricks = Blocks.CHISELED_STONE_BRICKS;

        private Block cobblestone = Blocks.COBBLESTONE;
        private Block cobblestoneStairs = Blocks.COBBLESTONE_STAIRS;
        private Block cobblestoneSlab = Blocks.COBBLESTONE_SLAB;
        private Block cobblestoneWall = Blocks.COBBLESTONE_WALL;

        private Block mossyCobblestone = Blocks.MOSSY_COBBLESTONE;
        private Block mossyCobblestoneStairs = Blocks.MOSSY_COBBLESTONE_STAIRS;
        private Block mossyCobblestoneSlab = Blocks.MOSSY_COBBLESTONE_SLAB;
        private Block mossyCobblestoneWall = Blocks.MOSSY_COBBLESTONE_WALL;

        private Block mossyStoneBricks = Blocks.MOSSY_STONE_BRICKS;
        private Block mossyStoneBrickStairs = Blocks.MOSSY_STONE_BRICK_STAIRS;
        private Block mossyStoneBrickSlab = Blocks.MOSSY_STONE_BRICK_SLAB;
        private Block mossyStoneBrickWall = Blocks.MOSSY_STONE_BRICK_WALL;

        private Block stone = Blocks.STONE;
        private Block stoneStairs = Blocks.STONE_STAIRS;
        private Block stoneSlab = Blocks.STONE_SLAB;

        private Block leaves = Blocks.OAK_LEAVES;
        private Block dirt = Blocks.DIRT;
        private int wallVineChance = 12;

        private Block[] stoneBrickBlendBlocks;
        private int[] stoneBrickBlendThresholds;
        private Block[] cobblestoneBlendBlocks;
        private int[] cobblestoneBlendThresholds;
        private Block[] stoneBlendBlocks;
        private int[] stoneBlendThresholds;
        private Block[] planksBlendBlocks;
        private int[] planksBlendThresholds;

        public Builder planks(Block planks) { this.planks = planks; return this; }
        public Builder log(Block log) { this.log = log; return this; }
        public Builder wood(Block wood) { this.wood = wood; return this; }
        public Builder strippedLog(Block strippedLog) { this.strippedLog = strippedLog; return this; }
        public Builder strippedWood(Block strippedWood) { this.strippedWood = strippedWood; return this; }
        public Builder stairs(Block stairs) { this.stairs = stairs; return this; }
        public Builder slab(Block slab) { this.slab = slab; return this; }
        public Builder fence(Block fence) { this.fence = fence; return this; }
        public Builder fenceGate(Block fenceGate) { this.fenceGate = fenceGate; return this; }
        public Builder door(Block door) { this.door = door; return this; }
        public Builder trapdoor(Block trapdoor) { this.trapdoor = trapdoor; return this; }
        public Builder pressurePlate(Block pressurePlate) { this.pressurePlate = pressurePlate; return this; }
        public Builder button(Block button) { this.button = button; return this; }
        public Builder stoneBricks(Block stoneBricks) { this.stoneBricks = stoneBricks; return this; }
        public Builder crackedStoneBricks(Block crackedStoneBricks) { this.crackedStoneBricks = crackedStoneBricks; return this; }
        public Builder stoneBrickStairs(Block stoneBrickStairs) { this.stoneBrickStairs = stoneBrickStairs; return this; }
        public Builder stoneBrickSlab(Block stoneBrickSlab) { this.stoneBrickSlab = stoneBrickSlab; return this; }
        public Builder stoneBrickWall(Block stoneBrickWall) { this.stoneBrickWall = stoneBrickWall; return this; }
        public Builder chiseledStoneBricks(Block chiseledStoneBricks) { this.chiseledStoneBricks = chiseledStoneBricks; return this; }
        public Builder cobblestone(Block cobblestone) { this.cobblestone = cobblestone; return this; }
        public Builder cobblestoneStairs(Block cobblestoneStairs) { this.cobblestoneStairs = cobblestoneStairs; return this; }
        public Builder cobblestoneSlab(Block cobblestoneSlab) { this.cobblestoneSlab = cobblestoneSlab; return this; }
        public Builder cobblestoneWall(Block cobblestoneWall) { this.cobblestoneWall = cobblestoneWall; return this; }
        public Builder mossyCobblestone(Block mossyCobblestone) { this.mossyCobblestone = mossyCobblestone; return this; }
        public Builder mossyCobblestoneStairs(Block mossyCobblestoneStairs) { this.mossyCobblestoneStairs = mossyCobblestoneStairs; return this; }
        public Builder mossyCobblestoneSlab(Block mossyCobblestoneSlab) { this.mossyCobblestoneSlab = mossyCobblestoneSlab; return this; }
        public Builder mossyCobblestoneWall(Block mossyCobblestoneWall) { this.mossyCobblestoneWall = mossyCobblestoneWall; return this; }
        public Builder mossyStoneBricks(Block mossyStoneBricks) { this.mossyStoneBricks = mossyStoneBricks; return this; }
        public Builder mossyStoneBrickStairs(Block mossyStoneBrickStairs) { this.mossyStoneBrickStairs = mossyStoneBrickStairs; return this; }
        public Builder mossyStoneBrickSlab(Block mossyStoneBrickSlab) { this.mossyStoneBrickSlab = mossyStoneBrickSlab; return this; }
        public Builder mossyStoneBrickWall(Block mossyStoneBrickWall) { this.mossyStoneBrickWall = mossyStoneBrickWall; return this; }
        public Builder stone(Block stone) { this.stone = stone; return this; }
        public Builder stoneStairs(Block stoneStairs) { this.stoneStairs = stoneStairs; return this; }
        public Builder stoneSlab(Block stoneSlab) { this.stoneSlab = stoneSlab; return this; }
        public Builder leaves(Block leaves) { this.leaves = leaves; return this; }
        public Builder dirt(Block dirt) { this.dirt = dirt; return this; }
        public Builder wallVineChance(int wallVineChance) { this.wallVineChance = wallVineChance; return this; }

        public Builder stoneBrickBlend(Block b1, int p1) {
            this.stoneBrickBlendBlocks = new Block[]{b1};
            this.stoneBrickBlendThresholds = new int[]{p1};
            return this;
        }

        public Builder stoneBrickBlend(Block b1, int p1, Block b2, int p2) {
            this.stoneBrickBlendBlocks = new Block[]{b1, b2};
            this.stoneBrickBlendThresholds = new int[]{p1, p1 + p2};
            return this;
        }

        public Builder stoneBrickBlend(Block b1, int p1, Block b2, int p2, Block b3, int p3) {
            this.stoneBrickBlendBlocks = new Block[]{b1, b2, b3};
            this.stoneBrickBlendThresholds = new int[]{p1, p1 + p2, p1 + p2 + p3};
            return this;
        }

        public Builder stoneBrickBlend(Block b1, int p1, Block b2, int p2, Block b3, int p3, Block b4, int p4) {
            this.stoneBrickBlendBlocks = new Block[]{b1, b2, b3, b4};
            this.stoneBrickBlendThresholds = new int[]{p1, p1 + p2, p1 + p2 + p3, p1 + p2 + p3 + p4};
            return this;
        }

        public Builder cobblestoneBlend(Block b1, int p1) {
            this.cobblestoneBlendBlocks = new Block[]{b1};
            this.cobblestoneBlendThresholds = new int[]{p1};
            return this;
        }

        public Builder cobblestoneBlend(Block b1, int p1, Block b2, int p2) {
            this.cobblestoneBlendBlocks = new Block[]{b1, b2};
            this.cobblestoneBlendThresholds = new int[]{p1, p1 + p2};
            return this;
        }

        public Builder cobblestoneBlend(Block b1, int p1, Block b2, int p2, Block b3, int p3) {
            this.cobblestoneBlendBlocks = new Block[]{b1, b2, b3};
            this.cobblestoneBlendThresholds = new int[]{p1, p1 + p2, p1 + p2 + p3};
            return this;
        }

        public Builder stoneBlend(Block b1, int p1) {
            this.stoneBlendBlocks = new Block[]{b1};
            this.stoneBlendThresholds = new int[]{p1};
            return this;
        }

        public Builder stoneBlend(Block b1, int p1, Block b2, int p2) {
            this.stoneBlendBlocks = new Block[]{b1, b2};
            this.stoneBlendThresholds = new int[]{p1, p1 + p2};
            return this;
        }

        public Builder stoneBlend(Block b1, int p1, Block b2, int p2, Block b3, int p3) {
            this.stoneBlendBlocks = new Block[]{b1, b2, b3};
            this.stoneBlendThresholds = new int[]{p1, p1 + p2, p1 + p2 + p3};
            return this;
        }

        public Builder planksBlend(Block b1, int p1) {
            this.planksBlendBlocks = new Block[]{b1};
            this.planksBlendThresholds = new int[]{p1};
            return this;
        }

        public Builder planksBlend(Block b1, int p1, Block b2, int p2) {
            this.planksBlendBlocks = new Block[]{b1, b2};
            this.planksBlendThresholds = new int[]{p1, p1 + p2};
            return this;
        }

        public BiomePalette build() {
            return new BiomePalette(this);
        }
    }
}
