package me.cooleg.funnyitems;

import me.cooleg.funnyitems.Items.ItemInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemHandler implements Listener {
    private List<ItemInterface> list;
    public ItemHandler(List<ItemInterface> list) {
        this.list = list;
    }

    @EventHandler
    public void damage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();
            if (attacker.getInventory().getItemInMainHand() == null) {return;}
            for (ItemInterface item : list) {
                if (item.isItem(attacker.getInventory().getItemInMainHand())) {
                    item.runFunctionLeft(victim);
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void rightClick(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player)) {return;}
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (item == null) {return;}
        for (ItemInterface i : list) {
            if (i.isItem(event.getPlayer().getInventory().getItemInMainHand())) {
                i.runFunctionRight((Player) event.getRightClicked());
                event.setCancelled(true);
            }
        }
    }


}
