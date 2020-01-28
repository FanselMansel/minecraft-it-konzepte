package de.felix.facharbeit.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.felix.facharbeit.main.Facharbeit;

/**
 * @author Felix Mansel
 *
 */

public class Listener_LeaveEvent implements Listener {

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Facharbeit.getPlugin();
		if (Facharbeit.getPlugin().hashSet.contains(event.getPlayer())) {
			Facharbeit.getPlugin().hashSet.remove(event.getPlayer());

		}

	}

}
