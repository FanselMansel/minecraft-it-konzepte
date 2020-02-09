package de.felix.facharbeit.utils;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

/**
 * @author Felix Mansel
 *
 */

public class LocationHashmap extends HashMap<Location, ItemStack>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		String string ="§aHashmap:\n";
		
		for(Location key: this.keySet()) {
	     string +="    §aKoordinaten["+key.getBlockX()+","+key.getBlockY()+","+key.getBlockZ()+"] > "+this.get(key).getItemMeta().getDisplayName()+"\n";
		}
		
		 
		return string;
		
	
	

}
}

