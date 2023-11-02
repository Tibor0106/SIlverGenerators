package hu.tibor.Generator.Objects;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;

public class GeneratorObject {
    public ItemStack item;
    public Entity entity;
    public float probability;

    public GeneratorObject(@Nullable ItemStack item, @Nullable Entity entity, float probability){
            this.item = item;
            this.entity = entity;
            this.probability = probability;
    }
}
