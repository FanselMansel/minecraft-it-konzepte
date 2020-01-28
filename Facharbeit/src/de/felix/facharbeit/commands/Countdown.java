package de.felix.facharbeit.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.felix.facharbeit.main.Facharbeit;

/**
 * @author Felix Mansel
 *
 */

public class Countdown implements CommandExecutor {
	private int seconds = 11;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!Facharbeit.getPlugin().hashSet.contains(p)) {
				Facharbeit.getPlugin().hashSet.add(p);
				Bukkit.getScheduler().scheduleSyncRepeatingTask(Facharbeit.getPlugin(), new Runnable() {

					@Override
					public void run() {
						seconds--;
						p.setExp((float) seconds / 60);
						p.setLevel(seconds);

						switch (seconds) {
						case 60:
						case 30:
						case 15:
						case 10:
						case 5:
						case 3:
						case 2:
							Bukkit.broadcastMessage("§a Der Countdown läuft in §6" + seconds + "§a Sekunden ab!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
							break;
						case 1:
							Bukkit.broadcastMessage("§a Der Countdown läuft in §6" + seconds + "§a Sekunde ab!");
							p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
							break;
						case 0:
							Bukkit.broadcastMessage("§a Der Countdown ist abgelaufen!");
							Facharbeit.getPlugin().hashSet.remove(p);
							if (!Facharbeit.getPlugin().hashSet.contains(p)) {
							}
							break;

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
