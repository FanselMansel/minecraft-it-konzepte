package de.felix.facharbeit.main;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import de.felix.facharbeit.utils.InventoryBuilder;
import de.felix.facharbeit.utils.ItemBuilder;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */

public  class KonzeptInventoryBuilder {
	 public Inventory konzepteTesten;

	
 
   private void befuelleInventar(){
	   konzepteTesten.setItem(1, new ItemBuilder(Material.WOOL, 1, 3).setDisplayName("§1Doppelte While-schleife").build());
	   konzepteTesten.setItem(2, new ItemBuilder(Material.WOOL, 1, 4).setDisplayName("§2externe Methodenaufrufe").build());
	   konzepteTesten.setItem(3, new ItemBuilder(Material.WOOL, 1, 5).setDisplayName("§3Vererbung").build());
	   konzepteTesten.setItem(4, new ItemBuilder(Material.WOOL, 1, 6).setDisplayName("§4For-Each Schleifen").build());
	   konzepteTesten.setItem(5, new ItemBuilder(Material.WOOL, 1, 7).setDisplayName("§5Abstrakte Klassen und Interfaces").build());
	   konzepteTesten.setItem(7, new ItemBuilder(Material.WOOL, 1, 9).setDisplayName("§7Rueckgabewerte").build());
	   konzepteTesten.setItem(8, new ItemBuilder(Material.WOOL, 1, 10).setDisplayName("§8Singelton").build());
	   konzepteTesten.setItem(13, new ItemBuilder(Material.WOOL, 1, 8).setDisplayName("§6Switch-Statements").build());
   }
   

public Inventory build() {
	konzepteTesten = new InventoryBuilder(9*3,Values.konzeptInventar).build(); 
	befuelleInventar();
	return konzepteTesten;
}
}

