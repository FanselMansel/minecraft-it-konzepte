package de.felix.facharbeit.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.felix.facharbeit.commands.Countdown;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 * Hier sind alle Methoden drin, die oft gebraucht werden.
 */

public class UtilityMethods {
/**
 * Diese Methode die Anzahl alle Spieler, die zurzeit Online sind zurück
 * @return int
 */
	public static int zaehleSpielerOnline() {
		if (Bukkit.getOnlinePlayers() != null) {
			return Bukkit.getOnlinePlayers().size();
		}
		return 0;
	}
/**
 * Diese Methode testet ob es sich bei einem übergebenen ItemStack das Menue-Item handelt, über welches Funktionen getestet werden können.
 * @param itemStack
 * @return boolean
 */
	public static boolean isKonzeptChest(ItemStack itemStack) {
		boolean isItemStack = itemStack != null;
		if (!isItemStack) {
			return false;
		}
		boolean isChest = itemStack.getType().equals(Material.CHEST);
		boolean isKonzeptChest = itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()
				&& itemStack.getItemMeta().getDisplayName().equals(Values.konzept_item);
		return isChest && isKonzeptChest;
	}

/**
 * Diese Methode testet, ob es sich bei den im Menue angeklicktet Items ob Knöpfe zum testen von Funktionen handelt.	
 * @param itemStack
 * @return boolean
 */
	public static boolean isKonzeptWool(ItemStack itemStack) {
		boolean isItemStack = itemStack != null;
		if (!isItemStack) {
			return false;
		}
		boolean isWool = itemStack.getType().equals(Material.WOOL);
		boolean isKonzeptWool = itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()
				&& itemStack.getItemMeta().getDisplayName().contains("§");
		return isWool && isKonzeptWool;
	}

	/**
	 * Diese Methode testet ob der Countdown bereits läuft.
	 * @return boolean
	 */
	public static boolean checkCountdown() {
		return Bukkit.getScheduler().isCurrentlyRunning(Countdown.task)
				|| Bukkit.getScheduler().isQueued(Countdown.task);
	}
}
