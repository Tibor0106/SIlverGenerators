package hu.tibor.Generator.Evenets;

import hu.tibor.GUIManager.GUI.GeneratorGUI;
import hu.tibor.Generator.Generator;
import hu.tibor.Generator.Objects.GeneratorLoader;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.GeneratorMain;
import hu.tibor.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class GeneratorInteract implements Listener {
    private Plugin plugin;
    public GeneratorInteract(Plugin plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGenerator(PlayerInteractEvent e){
        try{
            String generatorId = GeneratorPlace.getCustomMetadata(e.getClickedBlock(), "generator");
            if(generatorId != null){
                if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                    for (LoadedGenerators gen : GeneratorMain.Loadedgenerators){
                        if(e.getClickedBlock().getLocation().getWorld().getName().equalsIgnoreCase(gen.location.getWorld().getName())
                                && e.getClickedBlock().getLocation().getBlockX() == gen.location.getBlockX()
                                && e.getClickedBlock().getLocation().getBlockY()+3 == gen.location.getBlockY()
                                && e.getClickedBlock().getLocation().getBlockZ() == gen.location.getBlockZ()){
                            GeneratorGUI  generatorGUI = new GeneratorGUI(gen);
                            e.getPlayer().openInventory(generatorGUI.getInventory());

                            break;


                        }
                    }
                }
            }
        }catch (Exception err){

        }


    }
}
