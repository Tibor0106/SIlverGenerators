package hu.tibor.GUIManager.GUI;


import hu.tibor.GUIManager.GuiCreator;
import hu.tibor.GUIManager.IMenu;
import hu.tibor.Generator.Generator;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.GeneratorMain;
import hu.tibor.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;



public class GeneratorGUI implements IMenu {
    GuiCreator gui;
    LoadedGenerators gen;
    public  GeneratorGUI(LoadedGenerators generator){
        this.gen = generator;
    }

    @Override
    public void onItemClick(ClickType clickType, Player player, int slot, ItemStack item) {
        if(slot == 13){
            if(gen.level == gen.generator.maxLevel){
                return;
            }
            for (LoadedGenerators generator: GeneratorMain.Loadedgenerators) {
                if(generator.key.equalsIgnoreCase(gen.key)){
                    Location loc = new Location(generator.location.getWorld(), generator.location.getX(),
                            generator.location.getY()-3, generator.location.getZ());
                    generator.level++;
                    loc.getBlock().setType(generator.generator.blockOfLevel[generator.level-1]);
                    Generator.UpgradeGenerator(generator, player);
                    GeneratorGUI  generatorGUI = new GeneratorGUI(generator);
                    player.openInventory(generatorGUI.getInventory());
                }
            }


        }
    }
    @Override
    public Inventory getInventory() {
        ItemStack[] items = new ItemStack[9*3];

        for(int i = 0;i < 9 ;i++){
            items[i] = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        }
        for(int i = 17 ;i < 27 ;i++){
            items[i] = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        }
        items[10] = gen.generator.generatorItem;
        items[17] = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        items[9] = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        if(gen.level != gen.generator.maxLevel){
            items[13] = Utils.ItemCreator(Material.EMERALD, "§aFejlesztés §2- §a"
                    +gen.generator.upgradePrice[gen.level], new ArrayList<String>(), false, null);
        } else {
            items[13] = Utils.ItemCreator(Material.IRON_INGOT, "§eA generátor elérte a maximum szinetet.", new ArrayList<>(), false, null);
        }
        items[16] = Utils.ItemCreator(Material.BARRIER, "§4§lFELSZEDÉS",
                new ArrayList<String>(Arrays.asList("  ","§4§lFIGYELEM§8§l: §c§lA generátor szintje törlödni fog!", "")),
                true, null);
        gui = new GuiCreator(this, null, "Generátor Menü", 9*3, items, hu.tibor.GeneratorMain.getPlugin(GeneratorMain.class));
        return gui.getInventory();
    }
}
