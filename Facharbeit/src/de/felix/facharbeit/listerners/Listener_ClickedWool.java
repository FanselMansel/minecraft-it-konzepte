package de.felix.facharbeit.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.felix.facharbeit.main.Facharbeit;
import de.felix.facharbeit.utils.Hilfsmethoden;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public class Listener_ClickedWool implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		boolean isNotNull = event.getClickedInventory() != null;
		if (isNotNull) {
			if (event.getClickedInventory().getTitle().equals(Values.konzeptInventar)) {
				if (Hilfsmethoden.isKonzeptWool(event.getCurrentItem())) {
					event.setCancelled(true);
					String name = event.getCurrentItem().getItemMeta().getDisplayName();
					switch (name) {

					case "§6Switch-Statements":
						if (Facharbeit.getPlugin().hashSet.contains(p)) {
							p.sendMessage(Values.prefix + "§6Switch-Statements §4werden bereits getestet! ");
							p.sendMessage("");
						} else {
							p.closeInventory();
							p.sendMessage(Values.prefix + "§6Switch-Statements §awerden nun getestet! ");
							p.sendMessage("");
							p.performCommand("countdown");

						}
					default:
						p.closeInventory();

					}

				}
			}
		}

	}

}
