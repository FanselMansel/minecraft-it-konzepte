package de.felix.facharbeit.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.felix.facharbeit.utils.UtilityMethods;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public class Listener_DropEvent implements Listener {

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if (UtilityMethods.isKonzeptChest(event.getItemDrop().getItemStack())) {
			event.getPlayer().sendMessage(Values.cantDropItem);
			event.setCancelled(true);
		}

	}

}
