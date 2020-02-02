package de.felix.facharbeit.values;

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
	// Konzept-Inventar Wollblöcke
	public static final String woolSwitchStatements = "§6Switch-Statements";
	public static final String woolSingelton = "§8Singelton";
	public static final String woolRueckgabe = "§7Rueckgabewerte";
	public static final String woolAbstractAndInterfaces = "§5Abstrakte Klassen und Interfaces";
	public static final String woolForEach = "§4For-Each Schleifen";
	public static final String woolVererbung = "§3Vererbung";
	public static final String woolExterneMethodenAufrufe = "§2externe Methodenaufrufe";
	public static final String woolDoppelteWhileSchleife = "§1Doppelte While-schleife";
	public static final String woolHashmap = "§cHashmap";

}
