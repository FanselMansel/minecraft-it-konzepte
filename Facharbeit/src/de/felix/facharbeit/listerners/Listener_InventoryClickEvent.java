package de.felix.facharbeit.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.felix.facharbeit.utils.Hilfsmethoden;

/**
 * @author Felix Mansel
 *
 */

public class Listener_InventoryClickEvent implements Listener {
	
	@EventHandler 
	public void onClick(InventoryClickEvent event) {
		if(Hilfsmethoden.isKonzeptChest(event.getCurrentItem())) {
			event.setCancelled(true);
		}
	}
}

