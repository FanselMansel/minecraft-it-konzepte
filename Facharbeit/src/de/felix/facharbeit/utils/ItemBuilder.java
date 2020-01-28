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
 * ItemBuilder is a Class to create ItemStack or Skull-Heads.
 */

public class ItemBuilder {

	ItemStack item;
	ItemMeta itemMeta;

	/**
	 * Create the Standard Item
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
	 * Set a displayname for the Item
	 * 
	 * @param displayname
	 * @return this
	 */
	public ItemBuilder setDisplayName(String displayname) {
		this.itemMeta.setDisplayName(displayname);
		return this;
	}

	/**
	 * Add the Item a Enchantment with level
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
	 * Set a lore for the Item
	 * 
	 * @param list
	 * @return
	 */
	public ItemBuilder setLore(List<String> list) {
		this.itemMeta.setLore(list);
		return this;
	}

	/**
	 * Build a ItemStack with the Values of ItemBuilder. If exists displayname and
	 * lore.
	 * 
	 * @return ItemStack
	 */
	public ItemStack build() {
		this.item.setItemMeta(this.itemMeta);
		return this.item;
	}

	
}

