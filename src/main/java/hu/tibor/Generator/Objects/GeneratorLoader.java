package hu.tibor.Generator.Objects;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.Generators.MobGenerator;
import hu.tibor.Generator.Generators.OreGenerator;
import hu.tibor.Generator.Generators.WoodGenerator;
import hu.tibor.GeneratorMain;
import hu.tibor.Utils;
import org.bukkit.plugin.Plugin;

public class GeneratorLoader {
    private Plugin plugin;
    private static OreGenerator oreGenerator;

    private static WoodGenerator woodGenerator;

    private static MobGenerator mobGenerator;
    public  GeneratorLoader(Plugin plugin){
        this.plugin = plugin;
        oreGenerator = new OreGenerator();
        oreGenerator.getGenerator();
        GeneratorMain.generators.add(oreGenerator.getGenerator());

        woodGenerator = new WoodGenerator();
        woodGenerator.getGenerator();
        GeneratorMain.generators.add(woodGenerator.getGenerator());

        mobGenerator = new MobGenerator();
        mobGenerator.getGenerator();
        GeneratorMain.generators.add(mobGenerator.getGenerator());
    }
    public static Generator getOreGenerator() {
        Generator gen = oreGenerator.getGenerator();
        return gen;
    }
}
