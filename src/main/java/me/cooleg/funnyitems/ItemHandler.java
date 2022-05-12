package me.cooleg.funnyitems;

import me.cooleg.funnyitems.Items.ItemInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ItemHandler implements Listener {
    private List<ItemInterface> list;
    public ItemHandler(List<ItemInterface> list) {
        this.list = list;
    }

    @EventHandler
    public void damage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();
            if (attacker.getInventory().getItemInMainHand() == null) {return;}
            for (ItemInterface item : list) {
                if (item.isItem(attacker.getInventory().getItemInMainHand())) {
                    item.runFunction(victim);
                }
            }
        }
    }
}
