package com.reggarf.mods.underground_village;

import com.reggarf.mods.underground_village.api.JoinPlugin;
import com.reggarf.mods.underground_village.config.USConfigs;

public class CommonClass {
    public static USConfigs.Common CONFIG = USConfigs.COMMON;

    public static void init() {
        JoinPlugin.register();
        USConfigs.init();
    }
}
