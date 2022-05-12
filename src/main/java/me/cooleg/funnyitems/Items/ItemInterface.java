package me.cooleg.funnyitems.Items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ItemInterface {

    ItemStack getItem();

    void runFunctionLeft(Player p);

    void runFunctionRight(Player p);


    void sendInfo(Player p);

    ItemInterface register();

    boolean isItem(ItemStack item);

}
