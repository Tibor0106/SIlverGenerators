package hu.tibor.Generator;


import hu.tibor.Generator.Evenets.GeneratorPlace;
import hu.tibor.Generator.I.IGeneratorCreator;
import hu.tibor.Generator.Objects.GeneratorObject;
import hu.tibor.Generator.Objects.GeneratorProperty;
import hu.tibor.Generator.Objects.GeneratorType;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.GeneratorMain;
import me.filoghost.holographicdisplays.api.hologram.Hologram;
import me.filoghost.holographicdisplays.api.hologram.line.HologramLine;
import me.filoghost.holographicdisplays.api.hologram.line.ItemHologramLine;
import me.filoghost.holographicdisplays.api.hologram.line.TextHologramLine;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Generator {
    public ItemStack generatorItem;
    public String name;
    public String id;

    public  int maxLevel;
    public float[] upgradePrice;
    public GeneratorProperty property;
    public Material[] blockOfLevel;

    public IGeneratorCreator creator;


    public Generator(ItemStack GeneratorItem, String id, String name, int maxLevel,
                     float[] upgradePrice, GeneratorProperty generatorProperty, Material[] blockOfLevel, IGeneratorCreator creator){
        this.generatorItem = GeneratorItem;
        this.id = id;
        this.name = name;
        this.maxLevel = maxLevel;
        this.upgradePrice = upgradePrice;
        this.property = generatorProperty;
        this.blockOfLevel = blockOfLevel;
        this.creator = creator;

    }

    public static void TimerStart(){
        Bukkit.getScheduler().runTaskTimer(hu.tibor.GeneratorMain.getPlugin(hu.tibor.GeneratorMain.class), new Runnable() {
            @Override
            public void run() {

                    for (LoadedGenerators i : GeneratorMain.Loadedgenerators) {
                        Location loc = new Location(i.location.getWorld(), i.location.getX(), i.location.getY(), i.location.getZ());
                        if(loc.add(0, -3,0).getBlock().getType() == Material.AIR){
                            GeneratorMain.Loadedgenerators.remove(i);
                            i.hologram.delete();
                            continue;
                        }
                        TextHologramLine item = (TextHologramLine) i.hologram.getLines().get(3);
                        if(i.timer == 0){
                            item.setText("§4§lKiüthető");
                            i.generator.creator.Do(i);
                        } else {
                            i.timer = i.timer-0.5f;
                            item.setText("§4§l"+i.timer);

                        }
                    }

            }
        }, 10, 10);
    }
    public static void BrakedGenerator(LoadedGenerators generator, Player braker){
        double rand = Math.round(Math.random() * 100.0) / 100.0;
        int o = 0;
        double minDifference = Double.MAX_VALUE;
        GeneratorObject selectedObject = null;

        for (GeneratorObject i : generator.generator.property.generatorObjects[generator.level-1]) {
            if(i == null){
                continue;
            }
            double difference = Math.abs(rand - i.probability);
            if (difference < minDifference) {
                minDifference = difference;
                selectedObject = i;
            }
        }

        if (selectedObject != null) {
            if(generator.generator.property.type == GeneratorType.ITEM){
                braker.getLocation().getWorld().dropItem(braker.getLocation().add(0, 1, 0), selectedObject.item);
            } else if(generator.generator.property.type == GeneratorType.MOB){
                generator.location.getWorld().spawnEntity(generator.location, selectedObject.entity);
            }

        }



    }
    public static void UpgradeGenerator(LoadedGenerators gen, Player p){

        ItemHologramLine item = (ItemHologramLine) gen.hologram.getLines().get(0);
        item.setItemStack(new ItemStack(gen.generator.blockOfLevel[gen.level-1]));
        TextHologramLine name1 = (TextHologramLine) gen.hologram.getLines().get(1);
        name1.setText(gen.generator.name.replace("&", "§")+"§a - Level "+gen.level);
        GeneratorPlace.addBlockData(gen.location.getBlock(), gen);
        gen.timer = 0;

    }
    public String  createGeneratorKey(){
        String charset = "qwertzuiopasdfghjklyxcvbnm123456789";
        Random random = new Random();
        String key = "";

        for(int i = 0; i < 7; i++){
            key += charset.toCharArray()[random.nextInt(charset.length())];
        }
        return  key;
    }
}
