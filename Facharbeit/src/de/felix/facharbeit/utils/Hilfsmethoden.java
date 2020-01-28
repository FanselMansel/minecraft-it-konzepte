package de.felix.facharbeit.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public class Hilfsmethoden {
	
	
	public static int zaehleSpielerOnline() {
		if(Bukkit.getOnlinePlayers() != null) {
			return Bukkit.getOnlinePlayers().size();
		}
		return 0;
	}
	
	
	public static boolean isKonzeptChest(ItemStack itemStack) {
		boolean isItemStack = itemStack != null;
		if (!isItemStack) {
			return false;
		}
		boolean isChest = itemStack.getType().equals(Material.CHEST);
		boolean isKonzeptChest =  itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(Values.konzept_item);
		return  isChest && isKonzeptChest  ;   
	}
	
	public static boolean isKonzeptWool(ItemStack itemStack) {
		boolean isItemStack = itemStack != null;
		if (!isItemStack) {
			return false;
		}
		boolean isWool = itemStack.getType().equals(Material.WOOL);
		boolean isKonzeptWool =  itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().contains("§");
		return  isWool && isKonzeptWool;   
	}
}
