package de.felix.facharbeit.utils;

/**
 * @author Felix Mansel
 *
 */
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * ItemBuilder-Klasse, die das leichte erstellen von Spielgegenständen möglich macht.
 */

public class ItemBuilder {

	ItemStack item;
	ItemMeta itemMeta;

	/**
	 * Konstruktor jeden Items.
	 * 
	 * @param material
	 * @param amount
	 * @param subid
	 */
	public ItemBuilder(Material material, int amount, int subid) {
		this.item = new ItemStack(material, amount, (short) subid);
		this.itemMeta = this.item.getItemMeta();
	}

	/**
	 * Setzt den Displaynamen des Items.
	 * 
	 * @param displayname
	 * @return this
	 */
	public ItemBuilder setDisplayName(String displayname) {
		this.itemMeta.setDisplayName(displayname);
		return this;
	}

	/**
	 * Fügt eine Verzauberung des Gegenstands zu.
	 * 
	 * @param enchantment
	 * @param level
	 * @return
	 */
	public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
		this.itemMeta.addEnchant(enchantment, level, true);
		return this;
	}

	/**
	 * Setzt eine Beschreibung.
	 * 
	 * @param list
	 * @return
	 */
	public ItemBuilder setLore(List<String> list) {
		this.itemMeta.setLore(list);
		return this;
	}

	/**
	 * Gibt das erstellte Item zurück.
	 * 
	 * @return ItemStack
	 */
	public ItemStack build() {
		this.item.setItemMeta(this.itemMeta);
		return this.item;
	}

}
