package net.sqdmc.murderousmobs;

import org.bukkit.plugin.java.JavaPlugin;
import net.sqdmc.murderousmobs.utils.*;

import java.util.List;
import java.util.logging.Logger;

public class MurderousMobs extends JavaPlugin {
    public static MurderousMobs instance;

    public static MurderousMobs getInstance() { return instance; }
    public static Logger LOG;
    public List<String> mobNames;

    public static void DEBUG(String message) {
        LOG.info(message);
    }

    @Override
    public void onEnable(){
        instance = this;
        LOG = getLogger();
        DEBUG("The Mobs are getting Murderous!");

        this.mobNames = MobList.getList();
    }

    @Override
    public void onDisable(){

    }
}
