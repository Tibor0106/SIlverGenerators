package hu.tibor.Generator.Generators;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.I.IGeneratorCreator;
import hu.tibor.Generator.Objects.GeneratorObject;
import hu.tibor.Generator.Objects.GeneratorProperty;
import hu.tibor.Generator.Objects.GeneratorType;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.Utils;
import me.filoghost.holographicdisplays.api.HolographicDisplaysAPI;
import me.filoghost.holographicdisplays.api.hologram.Hologram;
import me.filoghost.holographicdisplays.api.hologram.line.TextHologramLine;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class OreGenerator implements IGeneratorCreator {
    private  Generator generator;
    @Override
    public Generator getGenerator() {
        generator = new Generator(getGeneratorItem(), getId(), getName(), getMaxLevel(),
                upgradePrice(), getGeneratorPropery(), getBlockOfLevel(), this);
        return generator;
    }
    @Override
    public ItemStack getGeneratorItem() {
        return Utils.ItemCreator(Material.COBBLESTONE, "&b&lÉrc Generátor", new ArrayList<String>(), true, getId());
    }

    @Override
    public String getName() {
        return "&b&lÉrc Generátor";
    }

    @Override
    public String getId() {
        return "ore_generator";
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float[] upgradePrice() {
        float[] upgradePrice = new float[getMaxLevel()];
        upgradePrice[0] = 5500;
        upgradePrice[1] = 13000;
        upgradePrice[2] = 20000;
        upgradePrice[3] = 30000;
        upgradePrice[4] = 45000;
        return upgradePrice;
    }

    @Override
    public GeneratorProperty getGeneratorPropery() {
        GeneratorObject[][] generatorObject = new GeneratorObject[getMaxLevel()][20];
        generatorObject[0][0] =  new GeneratorObject(new ItemStack(Material.IRON_INGOT), null, 0.60f);
        generatorObject[0][1] =  new GeneratorObject(new ItemStack(Material.COAL), null, 0.70f);
        generatorObject[0][2] =  new GeneratorObject(new ItemStack(Material.COBBLESTONE), null, 0.90f);


        generatorObject[1][0] =  new GeneratorObject(new ItemStack(Material.GOLD_INGOT), null, 0.15f);
        generatorObject[1][1] =  new GeneratorObject(new ItemStack(Material.IRON_INGOT), null, 0.70f);
        generatorObject[1][2] =  new GeneratorObject(new ItemStack(Material.COBBLESTONE), null, 0.80f);
        generatorObject[1][3] =  new GeneratorObject(new ItemStack(Material.COAL), null, 0.75f);

        generatorObject[2][0] =  new GeneratorObject(new ItemStack(Material.DIAMOND), null, 0.10f);
        generatorObject[2][1] =  new GeneratorObject(new ItemStack(Material.EMERALD), null, 0.20f);
        generatorObject[2][2] =  new GeneratorObject(new ItemStack(Material.GOLD_INGOT), null, 0.20f);
        generatorObject[2][3] =  new GeneratorObject(new ItemStack(Material.COAL), null, 0.85f);
        generatorObject[2][4] =  new GeneratorObject(new ItemStack(Material.IRON_INGOT), null, 0.80f);

        generatorObject[3][0] =  new GeneratorObject(new ItemStack(Material.NETHERITE_INGOT), null, 0.10f);
        generatorObject[3][1] =  new GeneratorObject(new ItemStack(Material.DIAMOND), null, 0.20f);
        generatorObject[3][2] =  new GeneratorObject(new ItemStack(Material.EMERALD), null, 0.30f);
        generatorObject[3][3] =  new GeneratorObject(new ItemStack(Material.GOLD_INGOT), null, 0.30f);
        generatorObject[3][4] =  new GeneratorObject(new ItemStack(Material.IRON_INGOT), null, 0.90f);


        generatorObject[4][0] =  new GeneratorObject(new ItemStack(Material.NETHERITE_INGOT), null, 0.20f);
        generatorObject[4][1] =  new GeneratorObject(new ItemStack(Material.EMERALD), null, 0.40f);
        generatorObject[4][2] =  new GeneratorObject(new ItemStack(Material.DIAMOND), null, 0.30f);
        generatorObject[4][3] =  new GeneratorObject(new ItemStack(Material.GOLD_INGOT), null, 0.45f);
        generatorObject[4][4] =  new GeneratorObject(new ItemStack(Material.IRON_INGOT), null, 0.80f);


        GeneratorProperty generatorProperty = new GeneratorProperty(GeneratorType.ITEM, generatorObject, BrakeTime());
        return generatorProperty;
    }

    @Override
    public Material[] getBlockOfLevel() {
        Material[] blocks = new Material[getMaxLevel()];
        blocks[0] = Material.COBBLESTONE;
        blocks[1] = Material.COAL_BLOCK;
        blocks[2] = Material.GOLD_BLOCK;
        blocks[3] = Material.EMERALD_BLOCK;
        blocks[4] = Material.DIAMOND_BLOCK;
        return blocks;
    }

    @Override
    public float[] BrakeTime() {
        float[] time = new float[getMaxLevel()];
        time[0] = 15;
        time[1] = 14.5f;
        time[2] = 13.5f;
        time[3] = 10;
        time[4] = 4.5f;
        return time;
    }

    @Override
    public void Do(LoadedGenerators generator) {

    }

}
