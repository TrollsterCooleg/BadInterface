package me.cooleg.funnyitems;

import me.cooleg.funnyitems.Items.ItemInterface;
import me.cooleg.funnyitems.Items.Items.LifeSteal;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class FunnyItems extends JavaPlugin {

    public List<ItemInterface> items = new ArrayList<>();
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ItemHandler(items), this);
        registerItems();
        getCommand("items").setExecutor(new itemsCommand(this));
    }

    private void registerItems() {
        items.add(new LifeSteal(this).register());
    }
}
