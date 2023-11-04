package hu.tibor.Generator.Generators;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.I.IGeneratorCreator;
import hu.tibor.Generator.Objects.GeneratorObject;
import hu.tibor.Generator.Objects.GeneratorProperty;
import hu.tibor.Generator.Objects.GeneratorType;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class MobGenerator implements IGeneratorCreator {

        private Generator generator;
        @Override
        public Generator getGenerator() {
            generator = new Generator(getGeneratorItem(), getId(), getName(), getMaxLevel(),
                    upgradePrice(), getGeneratorPropery(), getBlockOfLevel(), this);
            return generator;
        }
        @Override
        public ItemStack getGeneratorItem() {
            return Utils.ItemCreator(Material.COBBLESTONE, "§4§lMob Generátor", new ArrayList<String>(), true, getId());
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


            GeneratorProperty generatorProperty = new GeneratorProperty(GeneratorType.MOB, generatorObject, BrakeTime());
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
