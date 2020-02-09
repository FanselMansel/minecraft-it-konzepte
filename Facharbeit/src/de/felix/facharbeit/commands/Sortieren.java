package de.felix.facharbeit.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.felix.facharbeit.utils.ItemBuilder;
import de.felix.facharbeit.utils.Values;

/**
 * @author Felix Mansel
 *
 */
public class Sortieren implements CommandExecutor {
	public static Inventory sortierInventar = Bukkit.createInventory(null, 9 * 2, Values.sortierInventar);
	private static ItemStack sortedItems[] = new ItemStack[10];
	private static int[] array;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			arrayBefuellen();
			inventarBefuellen();
			randomizeInventory();
			p.openInventory(sortierInventar);
		}
		return false;
	}

	private void inventarBefuellen() {
		sortierInventar.setItem(17,
				new ItemBuilder(Material.ENDER_PEARL, 1, 0).setDisplayName(Values.sortierInventar_BubbleSort).build());
		sortierInventar.setItem(13, new ItemBuilder(Material.MELON_SEEDS, 1, 0)
				.setDisplayName(Values.sortierInventar_randomizeArray).build());
		sortierInventar.setItem(15,
				new ItemBuilder(Material.DEAD_BUSH, 1, 0).setDisplayName(Values.sortierInventar_quickSort).build());
		sortierInventar.setItem(16,
				new ItemBuilder(Material.DIAMOND, 1, 0).setDisplayName(Values.sortierInventar_selectionSort).build());
	}

	private void arrayBefuellen() {
		sortedItems[0] = new ItemBuilder(Material.WOOL, 1, 1).setDisplayName("§41").build();
		sortedItems[1] = new ItemBuilder(Material.WOOL, 1, 2).setDisplayName("§c2").build();
		sortedItems[2] = new ItemBuilder(Material.WOOL, 1, 3).setDisplayName("§63").build();
		sortedItems[3] = new ItemBuilder(Material.WOOL, 1, 4).setDisplayName("§e4").build();
		sortedItems[4] = new ItemBuilder(Material.WOOL, 1, 5).setDisplayName("§25").build();
		sortedItems[5] = new ItemBuilder(Material.WOOL, 1, 6).setDisplayName("§a6").build();
		sortedItems[6] = new ItemBuilder(Material.WOOL, 1, 7).setDisplayName("§b7").build();
		sortedItems[7] = new ItemBuilder(Material.WOOL, 1, 8).setDisplayName("§38").build();
		sortedItems[8] = new ItemBuilder(Material.WOOL, 1, 9).setDisplayName("§19").build();
		sortedItems[9] = new ItemBuilder(Material.WOOL, 1, 10).setDisplayName("§110").build();

	}

	public static void randomizeInventory() {
		int size = 9;
		Random random = new Random();

		List<Integer> leftoverPositions = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			leftoverPositions.add(i);
		}

		// iterate over items (0,1,2,3,4,5,6,7,8);
		for (int i = 0; i <= size; i++) {
			// get random leftover position(key)
			int positionKey = random.nextInt(leftoverPositions.size());
			// get corresponding position
			int position = leftoverPositions.get(positionKey);

			sortierInventar.setItem(position, sortedItems[i]);

			leftoverPositions.remove(positionKey);

		}
	}

	public static void bubbleSort(Player p) {
		int n = 10;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (sortierInventar.getContents()[j].getDurability() > sortierInventar.getContents()[j + 1]
						.getDurability()) {
					// swap temp and arr[i]
					ItemStack temp = sortierInventar.getContents()[j];
					sortierInventar.setItem(j, sortierInventar.getContents()[j + 1]);
					p.updateInventory();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sortierInventar.setItem(j + 1, temp);
					p.updateInventory();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
	}

	public static void quickSort(int lowerIndex, int higherIndex, Player p) {

		int i = lowerIndex;
		int j = higherIndex;

		// calculate pivot number, I am taking pivot as middle index number
		int pivot = sortierInventar.getContents()[lowerIndex + (higherIndex - lowerIndex) / 2].getDurability();
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which is greater
			 * then the pivot value, and also we will identify a number from right side
			 * which is less then the pivot value. Once the search is done, then we exchange
			 * both numbers.
			 */
			while (sortierInventar.getContents()[i].getDurability() < pivot) {
				i++;
			}
			while (sortierInventar.getContents()[j].getDurability() > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j, p);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j, p);
		if (i < higherIndex)
			quickSort(i, higherIndex, p);

	}

	
	
	
	
	
	public static void exchangeNumbers(int i, int j, Player p) {
		ItemStack temp = sortierInventar.getContents()[i];
		sortierInventar.setItem(i, sortierInventar.getContents()[j]);
		p.updateInventory();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sortierInventar.setItem(j, temp);
		p.updateInventory();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void selectionSort(Player p) {
		for (int i = 0; i < 10; i++) {
			int min = i;
			for (int j = i + 1; j < 10; j++)
				if (sortierInventar.getContents()[j].getDurability() < sortierInventar.getContents()[min]
						.getDurability())
					min = j;
			ItemStack temp = sortierInventar.getContents()[i];
			sortierInventar.setItem(i, sortierInventar.getContents()[min]);
			p.updateInventory();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sortierInventar.setItem(min, temp);
			p.updateInventory();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
