package de.felix.facharbeit.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.felix.facharbeit.main.Facharbeit;
import de.felix.facharbeit.utils.ItemBuilder;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

/**
 * 
 * Diese Klasse erstellt einen neuen im Spiel anwendbaren Command
 *
 */
public class Hashmap implements CommandExecutor {
    /**
     * Diese Methode wird ausgeführt wenn der Spieler den hier erstellten Command ausführt.
     * Für den Fall , dass die Argumentenlänge 0 ist und kein anderes Konzept getestet wird
     *  gibt diese Methode dem Spieler Gegenstände, die zum testen der Funktionalität der Klasse
     *   Listener_Hashmap benötight werden
     *   Für den Fall , dass die Argumentenlänge 1 ist und "clear" lautet und kein anderes Konzept getestet wird
     *   werden alle Items entfernt und das Testen der Hashmap abgebrochen.
     */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				Facharbeit.getPlugin().testingActive.add(Values.woolHashmap);
				p.getInventory().setItem(1,
						new ItemBuilder(Material.IRON_BLOCK, 1, 0).setDisplayName("§aTestobjekt").build());
				p.getInventory().setItem(2, new ItemBuilder(Material.IRON_BLOCK, 1, 0).build());
				p.getInventory().setItem(3,
						new ItemBuilder(Material.IRON_PICKAXE, 1, 0).setDisplayName("§aObjekt abbauen").build());
				p.getInventory().setItem(4,
						new ItemBuilder(Material.LAVA_BUCKET, 1, 0).setDisplayName("§4Testen abschließen").build());
			} else if (args.length == 1) {
				if (args[0].equals("clear")) {
					p.getInventory().remove(Material.IRON_BLOCK);
					p.getInventory().remove(Material.IRON_PICKAXE);
					p.getInventory().remove(Material.LAVA_BUCKET);
					Facharbeit.getPlugin().testingActive.remove(Values.woolHashmap);
				}

			}

		}
		return false;

	}
}
