package gg.loski.skills;

import gg.loski.skills.abilities.AbilitiesHandler;

import lombok.Getter;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Skills extends JavaPlugin implements Listener {

    @Getter private static Skills instance;
    @Getter private AbilitiesHandler abilitiesHandler;

    @Override
    public void onEnable() {
        instance = this;

        this.abilitiesHandler = new AbilitiesHandler();
    }
}
