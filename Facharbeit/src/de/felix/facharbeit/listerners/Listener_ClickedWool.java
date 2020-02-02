package de.felix.facharbeit.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.felix.facharbeit.commands.Countdown;
import de.felix.facharbeit.main.Facharbeit;
import de.felix.facharbeit.utils.UtilityMethods;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public class Listener_ClickedWool implements Listener {
	Countdown countdown = new Countdown();
	String testingWhat;

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		String name = null;
		Player p = (Player) event.getWhoClicked();
		boolean isNotNull = event.getClickedInventory() != null;
		if (isNotNull) {

			if (event.getClickedInventory().getTitle().equals(Values.konzeptInventory)) {
				if (UtilityMethods.isKonzeptWool(event.getCurrentItem())) {
					event.setCancelled(true);
					name = event.getCurrentItem().getItemMeta().getDisplayName();
					if (Facharbeit.getPlugin().testingActive.isEmpty()) {
						switch (name) {

						case (Values.woolSwitchStatements):
							p.closeInventory();
							p.sendMessage(Values.testingSwitch);
							p.sendMessage("");
							p.performCommand("countdown");
							name = null;
							break;

						case (Values.woolHashmap):
							p.closeInventory();
							p.sendMessage(Values.testingHashmap);
							p.sendMessage("");
							p.performCommand("hashmap");
							name = null;
							break;

						default:
							p.closeInventory();

						}
					} else {
						// Eckige Klammern entfernen
						testingWhat = Facharbeit.getPlugin().testingActive.toString();
						testingWhat = testingWhat.replace('[', ' ').replace(']', ' ');
						p.sendMessage(Values.prefix + "§aZurzeit wird das Konzept" + testingWhat + "§agetestet!");
					}

				}
			}
		}

	}

}
