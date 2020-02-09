package de.felix.facharbeit.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import de.felix.facharbeit.utils.ItemBuilder;
import de.felix.facharbeit.utils.Values;

/**
 * @author Felix Mansel
 *
 */

public class KonzeptInventoryBuilder {
	public Inventory konzepteTesten;

	private void befuelleInventar() {
		konzepteTesten.setItem(0,new ItemBuilder(Material.WOOL, 1, 8).setDisplayName(Values.woolSwitchStatements).build());
		konzepteTesten.setItem(3, new ItemBuilder(Material.WOOL, 1, 3).setDisplayName(Values.woolDoppelteWhileSchleife).build());
		//konzepteTesten.setItem(2, new ItemBuilder(Material.WOOL, 1, 4).setDisplayName(Values.woolExterneMethodenAufrufe).build());
	//	konzepteTesten.setItem(3, new ItemBuilder(Material.WOOL, 1, 5).setDisplayName(Values.woolVererbung).build());
		konzepteTesten.setItem(5, new ItemBuilder(Material.WOOL, 1, 6).setDisplayName(Values.woolForEach).build());
	//	konzepteTesten.setItem(7, new ItemBuilder(Material.WOOL, 1, 9).setDisplayName(Values.woolRueckgabe).build());
	//	konzepteTesten.setItem(8, new ItemBuilder(Material.WOOL, 1, 10).setDisplayName(Values.woolSingelton).build());
		konzepteTesten.setItem(8,new ItemBuilder(Material.WOOL, 1, 11).setDisplayName(Values.woolHashmap).build());

	}

	public Inventory build() {
		konzepteTesten = Bukkit.createInventory(null,9 * 1, Values.konzeptInventory);
		befuelleInventar();
		return konzepteTesten;
	}
}
