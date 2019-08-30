package gg.loski.skills.abilities;

import gg.loski.skills.abilities.type.JellyLegsAbility;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class AbilitiesHandler implements Listener {

    private Map<String, Abilities> skills = new HashMap<>();

    public AbilitiesHandler() {
        skills.put("JellyLegs", new JellyLegsAbility());
    }

    public Abilities getFromName(String name) {
        return skills.get(name);
    }

    public Map<String, Abilities> getSkills() {
        return skills;
    }
}
