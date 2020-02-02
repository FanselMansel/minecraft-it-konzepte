package de.felix.facharbeit.listerners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.felix.facharbeit.utils.UtilityMethods;
import de.felix.facharbeit.main.Facharbeit;
import de.felix.facharbeit.utils.ItemBuilder;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public class Listener_JoinQuitEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
		// Informiere alle Spieler §ber Join des Spielers.
		event.setJoinMessage(Values.prefix + "§8Der Spieler §a" + event.getPlayer().getDisplayName()
				+ " §8hat den lokalen Server betreten! §4(" + UtilityMethods.zaehleSpielerOnline() + "/"
				+ Values.maxPlayers + ")");
		// Setze Konzept-Kiste in den Inventar des joinenden Spielers.
		event.getPlayer().getInventory().clear();
		event.getPlayer().getInventory().setItem(0,
				new ItemBuilder(Material.CHEST, 1, 0).setDisplayName(Values.konzept_item).build());
		event.getPlayer().getInventory().setItem(8, new ItemBuilder(Material.REDSTONE_COMPARATOR, 1, 0)
				.setDisplayName(Values.konzept_itemkonzeptEinstellungen).build());
		if (Facharbeit.getPlugin().testingActive.contains(Values.woolHashmap)) {
			event.getPlayer().performCommand("hashmap");
		}
		event.getPlayer().setLevel(0);
		event.getPlayer().setExp(0);
		event.getPlayer().sendTitle("§4Facharbeit", "Konzepte der Informatik");

	}
}
