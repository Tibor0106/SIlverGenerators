package hu.tibor.Generator.Generators;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.I.IGeneratorCreator;
import hu.tibor.Generator.Objects.GeneratorObject;
import hu.tibor.Generator.Objects.GeneratorProperty;
import hu.tibor.Generator.Objects.GeneratorType;
import hu.tibor.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class WoodGenerator implements IGeneratorCreator {
    private Generator generator;
    @Override
    public Generator getGenerator() {
        generator = new Generator(getGeneratorItem(), getId(), getName(), getMaxLevel(),
                upgradePrice(), getGeneratorPropery(), getBlockOfLevel());
        return generator;
    }
    @Override
    public ItemStack getGeneratorItem() {
        return Utils.ItemCreator(Material.OAK_LOG, "&6&lFa Generátor", new ArrayList<String>(), true, getId());
    }

    @Override
    public String getName() {
        return "&7&lFa Generátor";
    }

    @Override
    public String getId() {
        return "wood_generator";
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public float[] upgradePrice() {
        float[] upgradePrice = new float[getMaxLevel()];
        upgradePrice[0] = 10000;
        upgradePrice[1] = 50000;
        upgradePrice[2] = 100000;
        return upgradePrice;
    }

    @Override
    public GeneratorProperty getGeneratorPropery() {
        GeneratorObject[][] generatorObject = new GeneratorObject[getMaxLevel()][20];
        generatorObject[0][0] =  new GeneratorObject(new ItemStack(Material.OAK_PLANKS), null, 25f);
        generatorObject[0][1] =  new GeneratorObject(new ItemStack(Material.BIRCH_PLANKS), null, 25f);
        generatorObject[0][2] =  new GeneratorObject(new ItemStack(Material.JUNGLE_PLANKS), null, 25f);
        generatorObject[0][3] =  new GeneratorObject(new ItemStack(Material.ACACIA_PLANKS), null, 25f);

        generatorObject[1][0] =  new GeneratorObject(new ItemStack(Material.OAK_PLANKS), null, 25f);
        generatorObject[1][1] =  new GeneratorObject(new ItemStack(Material.BIRCH_PLANKS), null, 25f);
        generatorObject[1][2] =  new GeneratorObject(new ItemStack(Material.JUNGLE_PLANKS), null, 25f);
        generatorObject[1][3] =  new GeneratorObject(new ItemStack(Material.ACACIA_PLANKS), null, 25f);
        generatorObject[1][4] =  new GeneratorObject(new ItemStack(Material.OAK_LOG), null, 25f);
        generatorObject[1][5] =  new GeneratorObject(new ItemStack(Material.BIRCH_PLANKS), null, 25f);
        generatorObject[1][6] =  new GeneratorObject(new ItemStack(Material.JUNGLE_PLANKS), null, 25f);
        generatorObject[1][7] =  new GeneratorObject(new ItemStack(Material.ACACIA_LOG), null, 25f);

        generatorObject[2][0] =  new GeneratorObject(new ItemStack(Material.OAK_PLANKS), null, 25f);
        generatorObject[2][1] =  new GeneratorObject(new ItemStack(Material.BIRCH_PLANKS), null, 25f);
        generatorObject[2][2] =  new GeneratorObject(new ItemStack(Material.JUNGLE_PLANKS), null, 25f);
        generatorObject[2][3] =  new GeneratorObject(new ItemStack(Material.ACACIA_PLANKS), null, 25f);
        generatorObject[2][5] =  new GeneratorObject(new ItemStack(Material.OAK_PLANKS), null, 25f);
        generatorObject[2][6] =  new GeneratorObject(new ItemStack(Material.BIRCH_LOG), null, 25f);
        generatorObject[2][7] =  new GeneratorObject(new ItemStack(Material.SPRUCE_LOG), null, 25f);
        generatorObject[2][8] =  new GeneratorObject(new ItemStack(Material.ACACIA_PLANKS), null, 25f);




        GeneratorProperty generatorProperty = new GeneratorProperty(GeneratorType.ITEM, generatorObject, BrakeTime());
        return generatorProperty;
    }

    @Override
    public Material[] getBlockOfLevel() {
        Material[] blocks = new Material[getMaxLevel()];
        blocks[0] = Material.OAK_LOG;
        blocks[1] = Material.BIRCH_LOG;
        blocks[2] = Material.SPRUCE_LOG;


        return blocks;
    }

    @Override
    public float[] BrakeTime() {
        float[] time = new float[getMaxLevel()];
        time[0] =25;
        time[1] = 16.5f;
        time[2] = 15.5f;
        return time;
    }
}
