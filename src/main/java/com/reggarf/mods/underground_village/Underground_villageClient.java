package com.reggarf.mods.underground_village;

//? if neoforge {
import com.reggarf.mods.better_lib.configs.demo.BetterLibConfigScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Constants.MODID, dist = Dist.CLIENT)
public class Underground_villageClient {

    public Underground_villageClient(ModContainer modContainer) {
        // Enable Minecraft's in-game Mod List config screen button (client-only)
        modContainer.registerExtensionPoint(
                IConfigScreenFactory.class,
                (container, parent) -> BetterLibConfigScreen.ModScreen(parent, Constants.MODID)
        );
    }
}
//?}
