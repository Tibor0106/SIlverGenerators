package hu.tibor.Generator.Generators;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.I.IGeneratorCreator;
import hu.tibor.Generator.Objects.GeneratorObject;
import hu.tibor.Generator.Objects.GeneratorProperty;
import hu.tibor.Generator.Objects.GeneratorType;
import hu.tibor.Generator.Objects.LoadedGenerators;
import hu.tibor.Utils;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
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
            return Utils.ItemCreator(Material.RED_GLAZED_TERRACOTTA, "§4§lMob Generátor", new ArrayList<String>(), true, getId());
        }

        @Override
        public String getName() {
            return "§4§lMob Generátor";
        }

        @Override
        public String getId() {
            return "mob_generator";
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
            upgradePrice[0] = 5500;
            upgradePrice[1] = 13000;
            upgradePrice[2] = 20000;
            return upgradePrice;
        }

        @Override
        public GeneratorProperty getGeneratorPropery() {
            GeneratorObject[][] generatorObject = new GeneratorObject[getMaxLevel()][20];
            generatorObject[0][0] =  new GeneratorObject(null, EntityType.BEE, 0.60f);
            generatorObject[0][1] =  new GeneratorObject(null, EntityType.CHICKEN, 0.70f);
            generatorObject[0][2] =  new GeneratorObject(null, EntityType.COW, 0.90f);

            generatorObject[1][0] =  new GeneratorObject(null, EntityType.BEE, 0.30f);
            generatorObject[1][1] =  new GeneratorObject(null, EntityType.CHICKEN, 0.70f);
            generatorObject[1][2] =  new GeneratorObject(null, EntityType.COW, 0.30f);
            generatorObject[1][3] =  new GeneratorObject(null, EntityType.PIG, 0.35f);
            generatorObject[1][4] =  new GeneratorObject(null, EntityType.ZOMBIE, 0.14f);


            generatorObject[2][0] =  new GeneratorObject(null, EntityType.CHICKEN, 0.70f);
            generatorObject[2][1] =  new GeneratorObject(null, EntityType.COW, 0.30f);
            generatorObject[2][2] =  new GeneratorObject(null, EntityType.PIG, 0.35f);
            generatorObject[2][3] =  new GeneratorObject(null, EntityType.ZOMBIE, 0.15f);
            generatorObject[2][4] =  new GeneratorObject(null, EntityType.SKELETON, 0.10f);
            generatorObject[2][5] =  new GeneratorObject(null, EntityType.BLAZE, 0.30f);




            GeneratorProperty generatorProperty = new GeneratorProperty(GeneratorType.MOB, generatorObject, BrakeTime());
            return generatorProperty;
        }

        @Override
        public Material[] getBlockOfLevel() {
            Material[] blocks = new Material[getMaxLevel()];
            blocks[0] = Material.RED_GLAZED_TERRACOTTA;
            blocks[1] = Material.BLACK_GLAZED_TERRACOTTA;
            blocks[2] = Material.PURPLE_GLAZED_TERRACOTTA;

            return blocks;
        }

        @Override
        public float[] BrakeTime() {
            float[] time = new float[getMaxLevel()];
            time[0] = 15;
            time[1] = 14.5f;
            time[2] = 13.5f;

            return time;
        }

    @Override
    public void Do(LoadedGenerators generator) {

    }

}
