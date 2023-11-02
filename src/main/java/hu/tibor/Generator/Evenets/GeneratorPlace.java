package hu.tibor.Generator.Evenets;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.GeneratorMain;
import hu.tibor.Utils;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GeneratorPlace implements Listener {
    private Plugin plugin;
    public GeneratorPlace(Plugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onGeneratorPlace(BlockPlaceEvent e){
        try{
            if(e.getItemInHand() != null){
                if(Utils.isGenerator(e.getItemInHand())){
                    Generator generator = Utils.getGeneratorById(Utils.getGeneratorKey(e.getItemInHand()));
                    if(generator != null){
                        LoadedGenerators gen =  new LoadedGenerators(e.getPlayer(),
                                new ArrayList<>(), generator, 1, e.getBlock().getLocation());
                        GeneratorMain.Loadedgenerators.add(gen);
                        addBlockData(e.getBlockPlaced(), gen);
                    }
                }
            }
        }catch (Exception err ){
        }
    }
    public static void addBlockData(Block block, LoadedGenerators generator){
        BlockState blockState = block.getState();
        blockState.setMetadata("generator", new
                FixedMetadataValue(hu.tibor.GeneratorMain.getPlugin(hu.tibor.GeneratorMain.class), generator.key));
        blockState.update();
    }
    public static String getCustomMetadata(Block block, String metadataKey) {
        MetadataValue metadataValue = block.getMetadata(metadataKey).get(0);

        if (metadataValue.getOwningPlugin() instanceof GeneratorMain) {
            String customMetadata = (String) metadataValue.value();
            return customMetadata;
        } else {
            return null;
        }
    }
    @EventHandler
    public void onGeneratorBrake(BlockBreakEvent e){
        try{
            String item = getCustomMetadata(e.getBlock(), "generator");
            if(item != null){
                if(!e.getPlayer().hasPermission("generator.brakeGeneratorOperator")){
                    e.setCancelled(true);
                } else {
                    return;
                }
                for (LoadedGenerators gen : GeneratorMain.Loadedgenerators) {
                    if (gen.key.equalsIgnoreCase(item))
                        if (gen.timer == 0) {
                            gen.timer = gen.generator.property.BrakeTime[gen.level - 1];
                            Generator.BrakedGenerator(gen, e.getPlayer());
                        }
                }
            }

        }catch (Exception err){
        }
    }
}

