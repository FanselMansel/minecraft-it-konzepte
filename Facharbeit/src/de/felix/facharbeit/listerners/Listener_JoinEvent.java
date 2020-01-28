package de.felix.facharbeit.listerners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.felix.facharbeit.utils.Hilfsmethoden;
import de.felix.facharbeit.utils.ItemBuilder;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public class Listener_JoinEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		// Informiere alle Spieler §ber Join des Spielers.
		event.setJoinMessage(Values.prefix + "§8Der Spieler §a" + event.getPlayer().getDisplayName()
				+ " §8hat den lokalen Server betreten! §4(" + Hilfsmethoden.zaehleSpielerOnline() + "/"
				+ Values.maxSpieleranzahl + ")");
		// Setze Konzept-Kiste in den Inventar des joinenden Spielers.
		event.getPlayer().getInventory().setItem(0,
				new ItemBuilder(Material.CHEST, 1, 0).setDisplayName(Values.konzept_item).build());
		event.getPlayer().setLevel(0);
		event.getPlayer().setExp(0);
	}
}
