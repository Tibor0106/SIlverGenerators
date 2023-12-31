package hu.tibor;

import hu.tibor.Commands.GeneratorGive;
import hu.tibor.GUIManager.IMenuHandler;
import hu.tibor.Generator.Evenets.GeneratorInteract;
import hu.tibor.Generator.Evenets.GeneratorPlace;
import hu.tibor.Generator.Generator;
import hu.tibor.Generator.Objects.GeneratorLoader;
import hu.tibor.Generator.Objects.LoadedGenerators;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public final class GeneratorMain extends JavaPlugin {
    public static ArrayList<Generator> generators = new ArrayList<>();
    public static ArrayList<LoadedGenerators> Loadedgenerators = new ArrayList<>();
    private GeneratorLoader generatorLoader;

    @Override
    public void onEnable()
    {
        try{
            saveDefaultConfig();
            new GeneratorLoader(this);
            GeneratorPlace gnp = new GeneratorPlace(this);
            getServer().getPluginCommand("generator-give").setExecutor(new GeneratorGive());
            getServer().getPluginCommand("generator-give").setTabCompleter(new GeneratorGive());
            Generator.TimerStart();
            IMenuHandler iMenuHandler = new IMenuHandler(this);
            GeneratorInteract generatorInteract = new GeneratorInteract(this);

            Bukkit.getLogger().info("§aPlugin was successful loaded.");
        }catch (Exception err){
            err.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {

    }
}
