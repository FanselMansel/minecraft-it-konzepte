package de.felix.facharbeit.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.felix.facharbeit.main.KonzeptInventoryBuilder;
import de.felix.facharbeit.utils.Hilfsmethoden;

/**
 * @author Felix Mansel
 *
 */

public class Listener_InteractEvent implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		boolean isRightClick = event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK;
		if (Hilfsmethoden.isKonzeptChest(event.getItem()) && isRightClick) {
			event.getPlayer().openInventory(new KonzeptInventoryBuilder().build());
		}
	}
}
