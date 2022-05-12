package me.cooleg.funnyitems.Items.Items;

import me.cooleg.funnyitems.FunnyItems;
import me.cooleg.funnyitems.Items.ItemInterface;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class LifeSteal implements ItemInterface {

    private FunnyItems funnyItems;
    public LifeSteal(FunnyItems funnyItems) {
        this.funnyItems = funnyItems;
    }

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("LifeSteal Sword");
        PersistentDataContainer contain = meta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(funnyItems, "type");
        contain.set(key, PersistentDataType.STRING, "LifeSword");
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void runFunction(Player p) {
        AttributeInstance att = p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        att.setBaseValue(att.getBaseValue()-2.0);
    }

    @Override
    public void sendInfo(Player p) {
        p.sendMessage("Hey there!");
        p.sendMessage("This item takes away a heart from whoever it hits.");
        p.sendMessage("Thanks for reading.");
    }

    @Override
    public void register(Object obj) {
        Bukkit.getLogger().info("Custom LifeSteal Item Loaded");
       ((ArrayList<ItemInterface>) obj).add(this);
    }

    @Override
    public boolean isItem(ItemStack item) {
        PersistentDataContainer contain = item.getItemMeta().getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(funnyItems, "type");
        String result = contain.get(key, PersistentDataType.STRING);
        if (result.equals("LifeSword")) {
            return true;
        }
        return false;
    }
}
