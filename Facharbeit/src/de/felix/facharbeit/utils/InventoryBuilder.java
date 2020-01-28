package de.felix.facharbeit.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * @author Felix Mansel
 *
 */

public class InventoryBuilder {
	public Inventory inventory;

	public InventoryBuilder(int groesse, String titel) {
		this.inventory = Bukkit.createInventory(null, groesse  ,titel); 
	}
	
	 	
	   

	public Inventory build() {
		return inventory;
	}

}

