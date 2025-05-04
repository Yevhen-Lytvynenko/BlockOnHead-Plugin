package org.MCS.blockOnHead;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockOnHead extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("[BlockOnHead] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("[BlockOnHead] Plugin disabled!");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;

        if (event.getSlot() == 39) {
            ItemStack clickedItem = event.getCursor();
            ItemStack helmetSlot = player.getInventory().getHelmet();

            if (clickedItem != null && !clickedItem.getType().isAir()) {
                event.setCancelled(true);

                player.getInventory().setHelmet(clickedItem);
                event.setCursor(helmetSlot != null ? helmetSlot : null);

            }
        }
    }

}

