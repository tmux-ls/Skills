package gg.loski.skills.abilities;

import gg.loski.skills.Skills;
import gg.loski.skills.abilities.type.JellyLegsAbility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.MetadataValue;
import sun.management.counter.perf.PerfLongArrayCounter;

import java.util.HashMap;
import java.util.Map;

public class AbilitiesHandler implements Listener {

    private Map<String, Abilities> skills = new HashMap<>();

    public AbilitiesHandler() {
        skills.put("JellyLegs", new JellyLegsAbility());

        Bukkit.getPluginManager().registerEvents(this, Skills.getInstance());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (!e.getAction().name().contains("RIGHT")) return;
        if (!player.hasMetadata("abilities")) return;

        MetadataValue metadataValue = player.getMetadata("abilities").get(0);

        Abilities abilities = getFromName(metadataValue.asString());

        if (abilities == null) return;

        abilities.excute(e);
        player.sendMessage(ChatColor.YELLOW + "You have used " + abilities.getName().toUpperCase());
    }

    public Abilities getFromName(String name) {
        return skills.get(name);
    }

    public Map<String, Abilities> getSkills() {
        return skills;
    }
}
