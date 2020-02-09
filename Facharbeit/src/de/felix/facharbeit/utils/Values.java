package de.felix.facharbeit.utils;

import org.bukkit.Bukkit;

/**
 * @author Felix Mansel
 * Diese Klasse enthält alle wichtigen Werte, die oft gebraucht werden.
 */

public class Values {

// Messages
	public static String prefix = "§a[Facharbeit] ";
	public static String testingSwitch = Values.prefix + "§aDas Konzept §6Switch-Statements §awird nun getestet!";
	public static String testingHashmap = Values.prefix + "§aDas Konzept §cHashmap §awird nun getestet!";
	public static String testingForEach = Values.prefix + "§aDas Konzept §4For-Each Schleifen §awird nun getestet!";
	public static String alreadyTestingSwitch = Values.prefix + "§aDas Konzept §6Switch-Statements §4werden bereits getestet!";
	public static String cantDropItem = Values.prefix + "§6Dieser Gegenstand kann nicht fallen gelassen werden!";

// UtilityMethods
	public static int maxPlayers = Bukkit.getServer().getMaxPlayers();
	// Countdown
	public static int seconds = 61;
	
// Konzept-Inventar
	public static String konzeptInventory = "§4Konzepte der Informatik testen";

	// Konzept Inventar Items
	public static String konzept_itemkonzeptEinstellungen = "§4Einstellungen";
	public static String konzept_item = "§aRechtsklick machen";
	public static String testingSortieren = Values.prefix + "§aSortiermethoden §awerden nun getestet!";

	
//Sortier-Imventar
	public static String sortierInventar_BubbleSort = "§4Bubblesort";
	public static String sortierInventar = "§4Sortiermethoden";
	public static String sortierInventar_randomizeArray = "§eZufällige Reihenfolge";
	public static String sortierInventar_quickSort = "§cQuickSort";
	public static String sortierInventar_selectionSort = "§aSelectionort";


	// Konzept-Inventar Wollblöcke
	public static final String woolSwitchStatements = "§6Switch-Statements";
	public static final String woolSingelton = "§8Singelton";
	public static final String woolRueckgabe = "§7Rueckgabewerte";
	public static final String woolAbstractAndInterfaces = "§5Abstrakte Klassen und Interfaces";
	public static final String woolForEach = "§4For-Each Schleifen";
	public static final String woolVererbung = "§3Vererbung";
	public static final String woolExterneMethodenAufrufe = "§2externe Methodenaufrufe";
	public static final String woolDoppelteWhileSchleife = "§1Sortiermethoden";
	public static final String woolHashmap = "§cHashmap";

}
