package net.sqdmc.murderousmobs.mobs.ai;

//import org.bukkit.Bukkit;
//import org.bukkit.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityChangeBlockEvent;

/**
 * Created by Matt on 11/21/2014.
 */
public class EntityBlockInteract {

    public static boolean entityBreakBlock(LivingEntity ent, Block b) {
        EntityChangeBlockEvent event = new EntityChangeBlockEvent(ent, b, Material.AIR);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if(!event.isCancelled()){
            b.setType(Material.AIR);
            return true;
        }
        return false;
    }

    public static boolean entityPlaceBlock(LivingEntity ent, Block b, Material newMat){
        EntityChangeBlockEvent event = new EntityChangeBlockEvent(ent, b, newMat);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled()) {
            b.setType(newMat);
            return true;
        }
        return false;
    }
}
