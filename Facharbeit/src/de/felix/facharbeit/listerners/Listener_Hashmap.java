package de.felix.facharbeit.listerners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.felix.facharbeit.utils.LocationHashmap;
import de.felix.facharbeit.utils.Values;



/**
 * @author Felix Mansel
 *
 */

public class Listener_Hashmap implements Listener {
	LocationHashmap data = new LocationHashmap();
	
	
	
    @EventHandler
    public void onPlaced(BlockPlaceEvent event) {
        if (event.getItemInHand() != null && event.getItemInHand().hasItemMeta()) {
            if (event.getItemInHand().getItemMeta().hasDisplayName() && event.getItemInHand().getType() == Material.IRON_BLOCK) {
                data.put(event.getBlock().getLocation(), event.getItemInHand());
                event.getPlayer().sendMessage(Values.prefix+"§aOrt und Name wurden in der Hashmap abgespeichert");
                event.getPlayer().sendMessage(data.toString());
                
            }
        }
    }
    @EventHandler
    public void blockBroke(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.IRON_BLOCK && data.containsKey(event.getBlock().getLocation())) {
            event.getPlayer().sendMessage(Values.prefix+"§aOrt und Name wurden aus der Hashmap entfernt");
        	data.toString();
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            ItemStack item = data.get(event.getBlock().getLocation());
            item.setAmount(1);
            event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation().add(0.5, 0.5, 0.5), item);
            data.remove(event.getBlock().getLocation());
        }
    }
    
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		boolean isRightClick = event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK;
		if (event.getItem() != null ) {
			if(event.getItem().getType() == Material.LAVA_BUCKET && isRightClick) {
			event.getPlayer().performCommand("hashmap clear");
			event.setCancelled(true);
		}
		}

	}
	
}
 

	


