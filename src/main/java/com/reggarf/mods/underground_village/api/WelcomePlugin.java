package com.reggarf.mods.underground_village.api;

import com.reggarf.mods.better_lib.popup.api.PopupTheme;
import com.reggarf.mods.better_lib.popup.api.WelcomePopupButton;
import com.reggarf.mods.better_lib.popup.api.WelcomePopupData;
import com.reggarf.mods.better_lib.popup.api.WelcomePopupPlugin;
import com.reggarf.mods.better_lib.popup.api.WelcomePopupPlugins;
import com.reggarf.mods.underground_village.CommonClass;
import com.reggarf.mods.underground_village.Constants;

public class WelcomePlugin implements WelcomePopupPlugin {

    @Override
    public String getModId() {
        return Constants.MODID;
    }

    @Override
    public String getModName() {
        return Constants.MOD_NAME;
    }

    @Override
    public boolean enabled() {
        return CommonClass.CONFIG.enableInGameMessage.get();
    }

    @Override
    public int getAccentColor() {
        return 0xF7C742;
    }

    @Override
    public PopupTheme getTheme() {
        return PopupTheme.MODERN;
    }

    @Override
    public WelcomePopupData getPopupData() {
        return WelcomePopupData.builder()
                .title("Underground Villages")
                .subtitle("SUBTERRANEAN EXPLORATION")
                .theme(PopupTheme.MODERN)
                .accentColor(0xF7C742)
                .addText("Underground Villages! adds naturally generated villages deep below the surface.", 0xFFFFFF)
                .addText("Need help, found a bug, or missing a recipe or structure? Use command !report or the links below to get support and stay updated:", 0xCCCCCC)
                .addBlankLine()
                .highlightBox("ZAP-HOSTING CODE", "Reggarf-1047", "20% OFF", "Click to copy promo code")
                .addButton(WelcomePopupButton.discord("https://discord.gg/kb6BntpcYq"))
                .addButton(WelcomePopupButton.reportBug("https://github.com/Reggarfgod/Underground-Village/issues"))
                .addButton(WelcomePopupButton.secondary("ZAP-Hosting", "https://zap-hosting.com/reggarf", "Support Reggarf (20% off)"))
                .addButton(WelcomePopupButton.secondary("CurseForge", "https://www.curseforge.com/minecraft/mc-mods/underground-villages-stoneholm", "Config & Updates"))
                .build();
    }

    public static void register() {
        WelcomePopupPlugins.register(new WelcomePlugin());
    }
}
