package hu.tibor;

import hu.tibor.Generator.Generator;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Utils {

    public static ItemStack ItemCreator(Material material, String name, List<String> lore, boolean glow, String id){

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name.replace("&", "§"));
        if(id != null){
            NamespacedKey key = new NamespacedKey(hu.tibor.GeneratorMain.getPlugin(hu.tibor.GeneratorMain.class), "generator");
            meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);
        }
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        if(glow){
            item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        }
        return item;
    }
    public static boolean generatorExist(String id){
        for (Generator gen : GeneratorMain.generators){
            if(gen.id.equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public static Generator getGeneratorById(String id)  {
        for(Generator gen : GeneratorMain.generators){
            if(gen.id.equalsIgnoreCase(id)){
                return gen;
            }
        }
        return null;
    }
    public static boolean isGenerator(ItemStack item){
        NamespacedKey namespacedKey = new NamespacedKey(hu.tibor.GeneratorMain.getPlugin(hu.tibor.GeneratorMain.class), "generator");
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta.getPersistentDataContainer().has(namespacedKey, PersistentDataType.STRING)) {
            return true;
        }
        return false;
    }
    public static String getGeneratorKey(ItemStack itemStack) {
        NamespacedKey namespacedKey = new NamespacedKey(hu.tibor.GeneratorMain.getPlugin(hu.tibor.GeneratorMain.class), "generator");
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta.getPersistentDataContainer().has(namespacedKey, PersistentDataType.STRING)) {
            return itemMeta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }
    public static String  createGeneratorKey(){
        String charset = "qwertzuiopasdfghjklyxcvbnm123456789";
        Random random = new Random();
        String key = "";

        for(int i = 0; i < 7; i++){
            key += charset.toCharArray()[random.nextInt(charset.length())];
        }
        return  key;
    }
}
