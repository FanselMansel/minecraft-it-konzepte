package de.felix.facharbeit.main;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import de.felix.facharbeit.commands.Countdown;
import de.felix.facharbeit.listerners.*;
import de.felix.facharbeit.values.Values;

/**
 * @author Felix Mansel
 *
 */


public class Facharbeit extends JavaPlugin {

	private static Facharbeit plugin;
	public HashSet <Player> hashSet= new HashSet<Player>();
	
	/**
	 * Diese Methoden onEnable(),onDisable() und onLoad() werden immer dann aufgerufen wenn ein Plugin enabled/disabled oder neu geladen wird. 
	* Standartm§§ig wird ein Plugin automatisch die onEnable() Methode ausf§hren.
	* Deshalb ist es wichtig erst einmal zu testen ob das Plugin erfolgreich geladen wurde.
	* Hierf§r stellt die Spigot API eine Methode zur verf§gung, die uns die Arbeit abnimmt.
	* 
	* Es besteht die M§glichkeit Color-codes zu verwenden. 
	* Um Nachrichten deutlicher hervorzuheben habe ich mich f§r diese entschieden und bin auf  Color-Code Tabelle gesto§en
	* Quelle: https://minecraft.tools/en/color-code.php
	*/
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage(Values.prefix+"§4Das Plugin §aFacharbeit §4wurde erfolgreich geladen");
		loadListeners();
		loadCommands();
	}
	

	
		
	

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Values.prefix+"§4Das Plugin §aFacharbeit §4wurde deaktiviert");
	}
	
	
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage(Values.prefix+"§4Das Plugin §aFacharbeit §4wird aktiviert");
	}
	
	private void loadListeners() {
		//
		Bukkit.getPluginManager().registerEvents(new Listener_JoinEvent(), this);
		//
		Bukkit.getPluginManager().registerEvents(new Listener_DropEvent(), this);
		Bukkit.getPluginManager().registerEvents(new Listeners_DamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_BlockPlaceEvent(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_InventoryClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_InteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_ClickedWool(), this);
		Bukkit.getPluginManager().registerEvents(new Listener_LeaveEvent(), this);
		

}
	/**
	 * 
	 */
	private void loadCommands() {
	    this.getCommand("countdown").setExecutor(new Countdown() );
	}
	
 public static Facharbeit getPlugin() {
	 return plugin;
 }
}