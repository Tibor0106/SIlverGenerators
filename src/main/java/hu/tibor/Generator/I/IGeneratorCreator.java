package hu.tibor.Generator.I;

import hu.tibor.Generator.Objects.GeneratorProperty;
import hu.tibor.Generator.Objects.LoadedGenerators;
import me.filoghost.holographicdisplays.api.hologram.Hologram;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface IGeneratorCreator extends GeneratorHolder{
    ItemStack getGeneratorItem();
    String getName();
    String getId();
    int getLevel();
    int getMaxLevel();
    float[] upgradePrice();
    GeneratorProperty getGeneratorPropery();
    Material[] getBlockOfLevel();
    float[] BrakeTime();
    void Do(LoadedGenerators generator);
}
