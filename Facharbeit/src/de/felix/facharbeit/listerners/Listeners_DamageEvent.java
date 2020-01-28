package de.felix.facharbeit.listerners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * @author Felix Mansel
 *
 */

public class Listeners_DamageEvent implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onHunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

}