package net.sqdmc.murderousmobs.mobs.ai;

import net.sqdmc.murderousmobs.mobs.MurderZombie;
import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftZombie;
import org.bukkit.entity.Entity;


/**
 * Created by Matt on 11/22/2014.
 */
public class MmCraftZombie extends CraftZombie {

    public MmCraftZombie(CraftServer server, MurderZombie zombie) {
        super(server, zombie);
    }

    public MurderZombie getHandle() {
        return (MurderZombie) super.getHandle();
    }
}
