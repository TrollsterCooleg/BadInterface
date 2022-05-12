package me.cooleg.funnyitems.Items.Items;

import me.cooleg.funnyitems.FunnyItems;
import me.cooleg.funnyitems.Items.ItemInterface;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Extinguisher implements ItemInterface {

    private FunnyItems funnyItems;

    public Extinguisher(FunnyItems funnyItems) {
        this.funnyItems = funnyItems;
    }
    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.WATER_BUCKET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Extinguisher");
        PersistentDataContainer contain = meta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(funnyItems, "type");
        contain.set(key, PersistentDataType.STRING, "Extinguisher");
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void runFunctionLeft(Player p) {return;}

    @Override
    public void runFunctionRight(Player p) {
       p.setFireTicks(0);
    }

    @Override
    public void sendInfo(Player p) {
        p.sendMessage("Gets rid of fire on someone");
    }

    @Override
    public ItemInterface register() {
        Bukkit.getLogger().info("Custom Extinguisher Item Loaded");
        return this;
    }

    @Override
    public boolean isItem(ItemStack item) {
        PersistentDataContainer contain = item.getItemMeta().getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(funnyItems, "type");
        String result = contain.get(key, PersistentDataType.STRING);
        if (result.equals("Extinguisher")) {
            return true;
        }
        return false;
    }
}
