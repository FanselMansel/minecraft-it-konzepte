package de.felix.facharbeit.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.felix.facharbeit.utils.UtilityMethods;

/**
 * @author Felix Mansel
 *
 */

public class Listener_BlockPlaceEvent implements Listener {

	@EventHandler
	public void onBuild(BlockPlaceEvent event) {
		if (UtilityMethods.isKonzeptChest(event.getPlayer().getItemInHand())) {
			event.setCancelled(true);
		}
	}
}
