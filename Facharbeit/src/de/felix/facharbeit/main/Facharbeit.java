package de.felix.facharbeit.main;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.felix.facharbeit.commands.Countdown;
import de.felix.facharbeit.commands.ForEach;
import de.felix.facharbeit.commands.HashmapTesten;
import de.felix.facharbeit.commands.Sortieren;
import de.felix.facharbeit.listerners.Listeners;
import de.felix.facharbeit.utils.Values;
import de.felix.facharbeit.listerners.Listener_ClickedWool;
import de.felix.facharbeit.listerners.Listener_Hashmap;
import de.felix.facharbeit.listerners.Listener_InteractAndClickEvents;

/**
 * @author Felix Mansel
 *
 */

public class Facharbeit extends JavaPlugin {

	private static Facharbeit plugin;
	public HashSet<String> testingActive = new HashSet<String>();

	/**
	 * Diese Methoden onEnable(),onDisable() und onLoad() werden immer dann
	 * aufgerufen wenn ein Plugin enabled/disabled oder neu geladen wird.
	 * Standartmäßig wird ein Plugin automatisch die onEnable() Methode ausf§hren.
	 * Deshalb ist es wichtig erst einmal zu testen ob das Plugin erfolgreich
	 * geladen wurde. Hierfür stellt die Spigot API eine Methode zur verfügung, die
	 * uns die Arbeit abnimmt.
	 * 
	 * Es besteht die Möglichkeit Color-codes zu verwenden. Um Nachrichten
	 * deutlicher hervorzuheben habe ich mich für diese entschieden und bin auf
	 * Color-Code Tabelle gestoßen Quelle: https://minecraft.tools/en/color-code.php
	 */
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage(Values.prefix + "§4Das Plugin §aFacharbeit §4wurde erfolgreich geladen");
		loadListeners();
		loadCommands();
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Values.prefix + "§4Das Plugin §aFacharbeit §4wurde deaktiviert");
	}

	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage(Values.prefix + "§4Das Plugin §aFacharbeit §4wird aktiviert");
	}

	private void loadListeners() {
		//
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_ClickedWool(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_Hashmap(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_InteractAndClickEvents(), this);
		//


	}

	/**
	 * 
	 */
	private void loadCommands() {
		this.getCommand("countdown").setExecutor(new Countdown());
		this.getCommand("hashmap").setExecutor(new HashmapTesten());
		this.getCommand("foreach").setExecutor(new ForEach());
		this.getCommand("sortieren").setExecutor(new Sortieren());
	}

	public static Facharbeit getPlugin() {
		return plugin;
	}
}