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

public class EternalFire implements ItemInterface {
    private FunnyItems funnyItems;

    public EternalFire(FunnyItems funnyItems) {
        this.funnyItems = funnyItems;
    }

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Rod of Fire");
        PersistentDataContainer contain = meta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(funnyItems, "type");
        contain.set(key, PersistentDataType.STRING, "FireRod");
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void runFunctionLeft(Player p) {
        p.setFireTicks(120000);
    }

    @Override
    public void runFunctionRight(Player p) {return;}

    @Override
    public void sendInfo(Player p) {
        p.sendMessage("Clicking a player with this item will set them on fire");
        p.sendMessage("For a very... long... time...");
    }

    @Override
    public ItemInterface register() {
        Bukkit.getLogger().info("Fire Rod Loaded");
        return this;
    }

    @Override
    public boolean isItem(ItemStack item) {
        PersistentDataContainer contain = item.getItemMeta().getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(funnyItems, "type");
        String result = contain.get(key, PersistentDataType.STRING);
        if (result.equals("FireRod")) {
            return true;
        }
        return false;
    }
}
