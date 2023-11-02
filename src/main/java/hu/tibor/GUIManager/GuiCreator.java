package hu.tibor.GUIManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class GuiCreator implements InventoryHolder{
    private Inventory inventory;
    private Plugin plugin;


    public GuiCreator(InventoryHolder holder, Player p, String name, int size, ItemStack[] content, Plugin plugin){
        this.plugin = plugin;
        this.inventory = Bukkit.createInventory(holder, size, name);
        this.inventory.setStorageContents(content);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
