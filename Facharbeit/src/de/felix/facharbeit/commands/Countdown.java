package de.felix.facharbeit.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.felix.facharbeit.main.Facharbeit;
import de.felix.facharbeit.utils.UtilityMethods;
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
public class Countdown implements CommandExecutor {
	public static int task;
	private int seconds = Values.seconds;

	@Override

    /**
     * Diese Methode wird ausgeführt wenn der Spieler den hier erstellten Command ausführt und startet einen Countdown in der Levelbar aller Spieler, wenn zurzeit kein anderes Konzept getestet wird.
     * Für den Fall das die Sekunden im Countdown 60,30,15,10,5,3,2 und 1 betragen wird im Chat eine Nachricht ausgegeben und ein Ton abgespielt.
     */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!UtilityMethods.checkCountdown() && Facharbeit.getPlugin().testingActive.isEmpty()) {
				Facharbeit.getPlugin().testingActive.add(Values.woolSwitchStatements);
				task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Facharbeit.getPlugin(), new Runnable() {

					@Override
					public void run() {
						seconds--;

						for (Player a : Bukkit.getOnlinePlayers()) {
							a.setExp((float) seconds / 60);
							a.setLevel(seconds);
						}

						switch (seconds) {
						case 60:
						case 30:
						case 15:
						case 10:
						case 5:
						case 3:
						case 2:
							for (Player a : Bukkit.getOnlinePlayers()) {
								a.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
							}
							Bukkit.broadcastMessage(
									Values.prefix + "§aDer Countdown läuft in §6" + seconds + "§a Sekunden ab!");
							Bukkit.broadcastMessage("");

							break;
						case 1:
							Bukkit.broadcastMessage(
									Values.prefix + "§aDer Countdown läuft in §6" + seconds + "§a Sekunde ab!");
							Bukkit.broadcastMessage("");
							for (Player a : Bukkit.getOnlinePlayers()) {
								a.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
							}
							break;
						case 0:
							seconds = Values.seconds;
							Bukkit.broadcastMessage(Values.prefix + "§aDer Countdown ist abgelaufen!");
							Bukkit.broadcastMessage("");
							Facharbeit.getPlugin().testingActive.remove(Values.woolSwitchStatements);
							Bukkit.getScheduler().cancelTask(task);

						default:
							break;

						}

					}

				}, 0, 20 * 1);
			}

		}

		return false;

	}

}
