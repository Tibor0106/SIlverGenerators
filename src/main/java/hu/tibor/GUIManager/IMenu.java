package hu.tibor.GUIManager;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface IMenu extends InventoryHolder {
    void  onItemClick(ClickType clickType, Player player, int slot, ItemStack item);

}
