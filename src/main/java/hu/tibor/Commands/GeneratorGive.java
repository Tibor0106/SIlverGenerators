package hu.tibor.Commands;

import hu.tibor.Generator.Generator;
import hu.tibor.Generator.Objects.GeneratorLoader;
import hu.tibor.GeneratorMain;
import hu.tibor.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorGive implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = Bukkit.getPlayer(sender.getName());
        if(args.length != 3){
            sender.sendMessage("§cSyntax error! Usage: §b/generator-give §e<generator id> §3<player> §6<amount>");
            return false;
        }
        if(!Utils.generatorExist(args[0])){
            sender.sendMessage("§cGenerator does not exist!");
        }
        Player target;
        try{
            target = Bukkit.getPlayer(args[1]);
            target.getName();
        }catch (Error err){
            sender.sendMessage("§cPlayer not found!");
            return false;
        }
        int amount = 1;
        try{
            amount = Integer.parseInt(args[2]);
        }catch (NumberFormatException err){
            sender.sendMessage("§cIncorrect number format.");
            return false;
        }
        Generator generator;
        try{
            generator = Utils.getGeneratorById(args[0]);
            for (int i = 0; i < amount; i++){
                p.getInventory().addItem(generator.generatorItem);
            }
            target.sendMessage("§aSuccessful get a §e"+amount+"x "+generator.name.replace("&", "§")+"");
            sender.sendMessage("§aYou successful gived "+amount+"x "+generator.name.replace("&", "§"));
        }catch (NullPointerException err){
            sender.sendMessage("§cError while giving item!");
            return false;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            ArrayList<String> items = new ArrayList<String>();
            for(Generator g : GeneratorMain.generators){
                items.add(g.id);
            }
            return items;
        }
        return null;
    }
}
