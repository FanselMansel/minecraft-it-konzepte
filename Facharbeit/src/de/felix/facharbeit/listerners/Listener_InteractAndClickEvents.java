package de.felix.facharbeit.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.felix.facharbeit.commands.Sortieren;
import de.felix.facharbeit.main.KonzeptInventoryBuilder;
import de.felix.facharbeit.utils.UtilityMethods;
import de.felix.facharbeit.utils.Values;

/**
 * @author Felix Mansel
 *
 */

public class Listener_InteractAndClickEvents implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		boolean isRightClick = event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK;
		if (UtilityMethods.isKonzeptChest(event.getItem()) && isRightClick) {
			event.getPlayer().openInventory(new KonzeptInventoryBuilder().build());
		}
	}
	
	@EventHandler 
	public void onClick(InventoryClickEvent event) {
		if(UtilityMethods.isKonzeptChest(event.getCurrentItem())) {
			event.setCancelled(true);
		}
		else  {
			try {
				if(event.getClickedInventory().getName().equals(Values.sortierInventar)) {
					if(event.getCurrentItem().getItemMeta().getDisplayName().equals(Values.sortierInventar_BubbleSort)) {
						Sortieren.bubbleSort((Player)event.getWhoClicked());
					}
					else if(event.getCurrentItem().getItemMeta().getDisplayName().equals(Values.sortierInventar_randomizeArray)){
						Sortieren.randomizeInventory();
					}
					else if(event.getCurrentItem().getItemMeta().getDisplayName().equals(Values.sortierInventar_selectionSort)){
						Sortieren.selectionSort((Player) event.getWhoClicked());
					}
					else if(event.getCurrentItem().getItemMeta().getDisplayName().equals(Values.sortierInventar_quickSort)){
						Sortieren.quickSort(0, 9, (Player) event.getWhoClicked());
					}
					event.setCancelled(true);
				}
			}catch(Exception e) {
				
				
			}
			
		}
	}
	
}
