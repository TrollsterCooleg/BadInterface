package me.cooleg.funnyitems.Items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ItemInterface {

    ItemStack getItem();

    void runFunction(Player p);

    void sendInfo(Player p);

    void register(Object obj);

    boolean isItem(ItemStack item);

}
