package com.reggarf.mods.underground_village;

import com.reggarf.mods.underground_village.api.WelcomePlugin;
import com.reggarf.mods.underground_village.config.USConfigs;

public class CommonClass {
    public static USConfigs.Common CONFIG = USConfigs.COMMON;

    public static void init() {
        WelcomePlugin.register();
        USConfigs.init();
    }
}
