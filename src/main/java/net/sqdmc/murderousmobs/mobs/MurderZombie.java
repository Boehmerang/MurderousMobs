package net.sqdmc.murderousmobs.mobs;

import net.minecraft.server.v1_7_R4.*;
import net.minecraft.server.v1_7_R4.Entity;
import net.minecraft.server.v1_7_R4.World;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.block.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.util.UnsafeList;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Field;

public class MurderZombie extends EntityZombie {
    public MurderZombie(World world) {
        super(world);
        try {
            Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
            bField.setAccessible(true);
            Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
            cField.setAccessible(true);
            bField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            bField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
            cField.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.0D, false));
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntitySkeleton.class, 1.0D, true));
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntitySpider.class, 1.0D, true));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, 0, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntitySkeleton.class, 0, false));
    }

    @Override
    public void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.e).setValue(6.0D);//TODO: change to config value {Default 3}

        Block b = null;
        LivingEntity ent = null;
        EntityChangeBlockEvent event = new EntityChangeBlockEvent(ent, b, Material.AIR);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    @Override
    protected Entity findTarget() {
        EntityHuman entityhuman = this.world.findNearbyVulnerablePlayer(this, 32.0D);//TODO: change to config value {Default 16}
        Entity ent = (Entity)entityhuman;
        if(entityhuman != null) {
            return entityhuman;
        }
        return null;

        //return entityhuman != null && this.p(entityhuman) ? entityhuman : null;
    }

    public Entity getTarget() {
        return findTarget();
    }
}
