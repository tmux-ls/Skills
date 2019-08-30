package gg.loski.skills.abilities.type;

import gg.loski.skills.abilities.Abilities;

import gg.loski.skills.utils.Constants;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class JellyLegsAbility extends Abilities {

    public JellyLegsAbility() {
        setName("Jelly Legs");
        setItemStack(new ItemStack(Material.FEATHER));
    }

    @Override
    public void excute(PlayerInteractEvent e) {
    }

    @Override
    public void excuteFall(EntityDamageEvent e) {
        Player player = (Player) e.getEntity();

        if (Constants.jellyLegs.contains(player.getUniqueId())) {
            if (!(e.getEntity() instanceof Player)) {
                return;
            }

            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setCancelled(true);
            }
        }
    }
    //
}
