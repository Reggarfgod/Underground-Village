plugins {
    id("dev.kikugie.stonecutter")
}

stonecutter active "26.1-neoforge"

stonecutter parameters {
    val (version, loader) = current.project.split('-', limit = 2)

    properties {
        tags(version, loader)
    }

    constants {
        match(loader, "fabric", "neoforge")
    }

    swaps["mod_version"] = "\"${properties["mod.version"]}\";"
    swaps["minecraft"] = "\"${current.version}\";"
    constants["release"] = properties["mod.id"] != "template"
    targets["fapi"] = properties.getOrNull("deps.fabric_api") ?: "0"

    replacements {
        string(current.parsed >= "26.1") {
            replace("ResourceLocation", "Identifier")
        }
    }
}
