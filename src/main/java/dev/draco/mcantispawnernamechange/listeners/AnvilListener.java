package dev.draco.mcantispawnernamechange.listeners;

import dev.draco.mcantispawnernamechange.MCAntiSpawnerNameChange;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class AnvilListener implements Listener {

    private final String notificationMessage;
    private final String notificationMessageColor;
    public AnvilListener (MCAntiSpawnerNameChange plugin){
        notificationMessage = plugin.getConfig().getString("NotificationMessage");
        notificationMessageColor = plugin.getConfig().getString("NotificationMessageColor");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        HumanEntity p = e.getWhoClicked();
        ItemStack itemClicked = e.getCurrentItem();
        if (p instanceof Player) {
            if (e.getInventory().getType().equals(InventoryType.ANVIL)) {
                if (itemClicked != null && (itemClicked.getType().equals(Material.SPAWNER))) {
                    e.setCancelled(true);
                    ((Player) p).updateInventory();
                    p.sendMessage(ChatColor.valueOf(notificationMessageColor) + notificationMessage);
                }
            }
        }
    }
}
