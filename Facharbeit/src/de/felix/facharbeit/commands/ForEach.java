package de.felix.facharbeit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.felix.facharbeit.main.Facharbeit;
import de.felix.facharbeit.utils.Values;

/**
 * @author Felix Mansel
 *
 */

public class ForEach implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if (sender instanceof Player) {
			if (Facharbeit.getPlugin().testingActive.isEmpty()) {
				Facharbeit.getPlugin().testingActive.add(Values.woolForEach);
				for(Player aktueller:Bukkit.getOnlinePlayers()) {
					aktueller.sendMessage(Values.prefix + "§aDas ist eine individuelle Nachricht!");
					aktueller.sendMessage(Values.prefix + "§aDein Name lautet §4"+aktueller.getDisplayName());
					aktueller.sendMessage(Values.prefix +"§aZurzeit hälst du folgendes Item in der Hand: "+aktueller.getItemInHand().getType().name());
					
				}
				Facharbeit.getPlugin().testingActive.remove(Values.woolForEach);				
				
				
			}
			}
		return false;
	}

}

