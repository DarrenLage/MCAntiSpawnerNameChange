package dev.draco.mcantispawnernamechange;

import dev.draco.mcantispawnernamechange.listeners.AnvilListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCAntiSpawnerNameChange extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new AnvilListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
