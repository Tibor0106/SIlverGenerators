package hu.tibor.Generator.Objects;

import hu.tibor.Generator.Generator;
import hu.tibor.Utils;
import me.filoghost.holographicdisplays.api.HolographicDisplaysAPI;
import me.filoghost.holographicdisplays.api.hologram.Hologram;
import me.filoghost.holographicdisplays.api.hologram.line.TextHologramLine;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import java.util.List;
import java.util.Random;

public class LoadedGenerators {
    public Player owner;
    public List<String> playerAccess;
    public Generator generator;
    public Hologram hologram;
    public Location location;
    public float timer;
    public String key;
    public int level;

    public LoadedGenerators(Player owner, List<String> playerAccess, Generator generator, int generatorLevel, Location location){
        this.generator = generator;
        this.playerAccess = playerAccess;
        this.location = location;
        this.level = generatorLevel;
        this.hologram = createHologram(this.location);
        this.timer = 0;
        String genKey = Utils.createGeneratorKey();
        this.key = genKey;
        this.generator.key = genKey;


    }
    private Hologram createHologram(Location location){
        Material mat = generator.blockOfLevel[level-1];
        HolographicDisplaysAPI api = HolographicDisplaysAPI.get(hu.tibor.GeneratorMain.getPlugin(hu.tibor.GeneratorMain.class));
        Hologram hologram = api.createHologram(location.add(0.5, 3, 0.5));
        hologram.getLines().insertItem(0, new ItemStack(mat));
        hologram.getLines().insertText(1, generator.name.replace("&", "§")+"§a - Level "+ level);
        hologram.getLines().insertText(2, "§d§L JOBB KATTINTÁS - §e§lGENERÁTOR MENÜ MEGNYITÁSA");
        hologram.getLines().insertText(3, "§4§lKiüthető");
        return hologram;
    }

}
