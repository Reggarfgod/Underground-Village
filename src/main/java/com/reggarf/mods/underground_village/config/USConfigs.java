package com.reggarf.mods.underground_village.config;

import com.reggarf.mods.better_lib.configs.BetterLibConfigApi;
import com.reggarf.mods.better_lib.configs.ConfigBase;
import com.reggarf.mods.better_lib.configs.format.ConfigFormat;
import com.reggarf.mods.underground_village.Constants;

import java.util.Map;

public class USConfigs {

    public static final Common COMMON = new Common();

    public static void init() {
        init(ConfigFormat.YAML);
    }

    public static void init(ConfigFormat format) {
        BetterLibConfigApi.register(Constants.MODID, format, null, COMMON, null).loadAll();
    }

    public static class Common extends ConfigBase {

        // Categories
        public final Underground underground = nested(0, Underground::new, "Underground Village generation settings.");
        public final UnderWater underwater = nested(0, UnderWater::new, "Water-based underground village generation settings.");
        public final UnderWater water = underwater;
        public final Placement placement = nested(0, Placement::new, "Structure placement settings.");
        public final Messages messages = nested(0, Messages::new, "In-game message settings.");

        // Direct compatibility references
        public final ConfigInt structureSize = underground.structureSize;
        public final ConfigInt maxDistanceFromCenter = underground.maxDistanceFromCenter;
        public final ConfigBool enableBiomePalettes = underground.enableBiomePalettes;

        public final ConfigInt waterStructureSize = underwater.waterStructureSize;
        public final ConfigInt waterMaxDistanceFromCenter = underwater.waterMaxDistanceFromCenter;

        public final ConfigInt placementSpacing = placement.placementSpacing;
        public final ConfigInt placementSeparation = placement.placementSeparation;

        public final ConfigBool enableInGameMessage = messages.enableInGameMessage;

        @Override
        public String getName() {
            return "common";
        }

        @Override
        public void onLoad() {
            placement.onLoad();
        }

        @Override
        public void applyFromMap(Map<String, Object> map) {
            super.applyFromMap(map);
            if (map != null) {
                // Support legacy flat configuration migration or alternate keys if child sections are missing
                if (!map.containsKey(underground.getName())) underground.applyFromMap(map);
                if (!map.containsKey(underwater.getName()) && !map.containsKey("water")) {
                    underwater.applyFromMap(map);
                } else if (map.containsKey("water") && map.get("water") instanceof Map<?, ?> waterMap) {
                    //noinspection unchecked
                    underwater.applyFromMap((Map<String, Object>) waterMap);
                }
                if (!map.containsKey(placement.getName())) placement.applyFromMap(map);
                if (!map.containsKey(messages.getName())) messages.applyFromMap(map);
            }
        }
    }

    public static class Underground extends ConfigBase {

        public final ConfigInt structureSize = i(15, 1, 30, "structureSize", "Default size of underground village structures.");
        public final ConfigInt maxDistanceFromCenter = i(116, 1, 128, "maxDistanceFromCenter", "Maximum distance structure pieces can generate from the village center.");
        public final ConfigBool enableBiomePalettes = b(true, "enableBiomePalettes", "Whether underground villages dynamically adapt their materials to match the surface biome.");

        @Override
        public String getName() {
            return "underground";
        }
    }

    public static class UnderWater extends ConfigBase {

        public final ConfigInt waterStructureSize = i(15, 1, 30, "waterStructureSize", "Default size of water-based underground village structures.");
        public final ConfigInt waterMaxDistanceFromCenter = i(116, 1, 128, "waterMaxDistanceFromCenter", "Maximum distance water structure pieces can generate from the center.");

        @Override
        public String getName() {
            return "under_water";
        }
    }

    public static class Placement extends ConfigBase {

        public final ConfigInt placementSpacing = i(34, 1, 256, "placementSpacing", "Spacing between underground village placements (must be greater than separation).");
        public final ConfigInt placementSeparation = i(8, 0, 255, "placementSeparation", "Minimum separation between underground village placements.");

        @Override
        public String getName() {
            return "placement";
        }

        @Override
        public void onLoad() {
            if (placementSeparation.get() >= placementSpacing.get()) {
                placementSeparation.set(Math.max(0, placementSpacing.get() - 1));
            }
        }
    }

    public static class Messages extends ConfigBase {

        public final ConfigBool enableInGameMessage = b(true, "enableInGameMessage", "Show the welcome message with Discord, GitHub, and support links on first join. (Requires restart)", "[@cui:RequiresRestart:CLIENT]");

        @Override
        public String getName() {
            return "messages";
        }
    }
}
