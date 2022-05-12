package me.cooleg.funnyitems;

import me.cooleg.funnyitems.Items.ItemInterface;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class itemsCommand implements CommandExecutor {
    private FunnyItems funnyItems;
    public itemsCommand(FunnyItems items) {
        this.funnyItems = items;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {return false;}
        for (ItemInterface item : funnyItems.items) {
            ((Player) sender).getInventory().addItem(item.getItem());
        }
        return false;
    }
}
