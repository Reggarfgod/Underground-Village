# Underground Village (Stoneholm)

<p align="center">
  <a href="https://modrinth.com/mod/underground-village,-stoneholm"><img src="https://img.shields.io/modrinth/dt/KmyhssPl?color=34D058&label=Modrinth%20Downloads&logo=modrinth&logoColor=white" alt="Modrinth Downloads"></a>
  <a href="https://www.curseforge.com/minecraft/mc-mods/underground-villages-stoneholm"><img src="https://img.shields.io/curseforge/dt/1123746?color=FC7303&label=CurseForge%20Downloads&logo=curseforge&logoColor=white" alt="CurseForge Downloads"></a>
  <a href="https://github.com/Reggarfgod/Underground-Village/issues"><img src="https://img.shields.io/github/issues/Reggarfgod/Underground-Village?color=6E40C9&label=Issues&logo=github" alt="GitHub Issues"></a>
  <a href="https://discord.gg/CN962KMpJk"><img src="https://img.shields.io/discord/430776550443581450?color=5865F2&label=Discord&logo=discord" alt="Discord"></a>
</p>


<p align="center">
  <a href="https://zap-hosting.com/reggarf" target="_blank" rel="nofollow noopener">
    <img src="https://media.forgecdn.net/attachments/description/1123746/description_88a3d82d-4ba5-4d0b-8666-efc74536ed10.png" alt="ZAP-Hosting">
  </a>
</p>

Need a high-performance server to play with friends? Rent a server with **ZAP-Hosting**!  
Use promo code **`Reggarf-1047`** at checkout for **20% off** your order:  
👉 **[https://zap-hosting.com/reggarf](https://zap-hosting.com/reggarf)**

---

**Underground Village** is a modern multi-loader port and continuation of **[Stoneholm](https://github.com/TheGrimsey/StoneholmForge)** (originally created by [TheGrimsey](https://github.com/TheGrimsey)), adding sprawling procedurally generated underground villages to Minecraft. Inspired by Strongholds and surface Villages, it brings life, mystery, and civilization to the depths.

Explore underground settlements that adapt to the biome above them—featuring complex networks of hallways, multi-tier staircases, artisan workspaces, bedrooms, overgrown chambers, and forgotten crypts. Convert them into your subterranean fortress, build a settlement above ground, or trade with deep-dwelling villagers.

---

### Supported Minecraft Versions & Mod Loaders

| Minecraft Version | NeoForge | Fabric | Forge | Status |
| :--- | :---: | :---: | :---: | :---: |
| **26.1 – 26.3** | ✔️ | ✔️ | — | **Latest / Active** |
| **1.21.1** | ✔️ | ✔️ | ✔️ | Supported |
| **1.20.1** | — | ✔️ | ✔️ | Legacy Supported |

> **Note**: Backports to older Minecraft versions prior to 1.20.1 will not be done.

---

# Requirements

- **Minecraft**: `1.21.1` or `26.1 – 26.3`
- **Required Library**:
  - **[Better Library](https://modrinth.com/mod/better-library)** ([CurseForge](https://www.curseforge.com/minecraft/mc-mods/better-library)) *(Required on all versions & loaders)*
- **Mod Loader**:
  - [NeoForge](https://neoforged.net/)
  - [Fabric](https://fabricmc.net/) (+ [Fabric API](https://modrinth.com/mod/fabric-api))
- **Java**: Java 21+ (Java 25 for `26.1 – 26.3`)

---

# Features

- 🎨 **14 Biome-Themed Underground Villages**: Villages automatically adapt their blocks and architectural style to match the surface biome directly above them—including **Desert, Badlands, Jungle, Plains, Forest, Taiga, Snowy, Savanna, Swamp, Dark Forest, Cherry Grove, Mushroom Fields, Mountain,** and **Ocean** biomes (plus automatic matching for modded biomes!).
- 🌊 **Unified Ocean Village**: Explore sunken **Ocean Villages** built with Prismarine and Sandstone blocks.
- 🧭 **Biome-Specific `/locate` Commands**: Search for any biome village directly with `/locate structure underground_village:<biome>_village` (such as `desert_village`, `cherry_grove_village`, `ocean_village`, `snowy_village`) or `/locate structure underground_village:village`.
- 🗺️ **Smart Buried World Generation**: Keeps underground rooms and hallways safely buried underground so only the surface entrance peeks above ground, with natural vanilla-like village spacing and fast lag-free `/locate` searches.
- ⚙️ **Fully Configurable**:
  - Interactive in-game config menu (via **Better Library** / ModMenu).
  - Toggle biome-themed palettes on or off.
  - Adjust village structure size, max distance from center, spacing, and separation.
- ⚖️ **Balanced Loot Progression**: Grounded loot tables featuring supplies, utility scrap, and food rather than game-breaking early progression gear.

---

# Screenshots

### Badlands Underground Village
<p><img src=".img/badlands_village.png" alt="Badlands Underground Village" width="900"/></p>

### Cherry Grove Underground Village
<p><img src=".img/cherry_grove_village.png" alt="Cherry Grove Underground Village" width="900"/></p>

### Desert Underground Village
<p><img src=".img/desert_village.png" alt="Desert Underground Village" width="900"/></p>

### Forest Underground Village
<p><img src=".img/forest_village.png" alt="Forest Underground Village" width="900"/></p>

### Jungle Underground Village
<p><img src=".img/jungle_village.png" alt="Jungle Underground Village" width="900"/></p>

### Mushroom Fields Underground Village
<p><img src=".img/mushroom_village.png" alt="Mushroom Fields Underground Village" width="900"/></p>

### Ocean Underground Village
<p><img src=".img/ocean_village.png" alt="Ocean Underground Village" width="900"/></p>

### Savanna Underground Village
<p><img src=".img/savanna_village.png" alt="Savanna Underground Village" width="900"/></p>

### Snowy Underground Village
<p><img src=".img/snowy_village.png" alt="Snowy Underground Village" width="900"/></p>

### Swamp Underground Village
<p><img src=".img/swamp_village.png" alt="Swamp Underground Village" width="900"/></p>

### Classic Hallways & Interiors
<p><img src=".img/pbsb5j2.jpg" alt="Underground Village main hallway and living quarters" width="900"/></p>

<p><img src=".img/pw8f7p0.jpg" alt="Underground Village central hall and workstations" width="900"/></p>

<p><img src=".img/5jj3fdj.jpg" alt="Deep village chamber and stone staircase" width="900"/></p>

<p><img src=".img/wfaf.png" alt="Subterranean village courtyard and living area" width="900"/></p>

<p><img src=".img/876r52s.png" alt="Overgrown underground corridor" width="900"/></p>

---

# Technical Info

Underground Villages are jigsaw structures that make use of template pools and processors as well as structure files. Creating jigsaw structures can be challenging, but [TelepathicGrunt's StructureTutorialMod repo](https://github.com/TelepathicGrunt/StructureTutorialMod) has been an invaluable reference when developing this mod.

---

## License & Credits

- **License**: This mod is licensed under the [MIT License](LICENSE). You are free to port, modify, or include it in modpacks.
- **Original Mod**: Credits and special thanks to [TheGrimsey](https://github.com/TheGrimsey) for the original [Stoneholm](https://github.com/TheGrimsey/StoneholmForge) mod.
