package net.sqdmc.murderousmobs.mobs.ai;

import net.sqdmc.murderousmobs.MurderousMobs;
import net.sqdmc.murderousmobs.mobs.MurderZombie;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.BlockIterator;

/**
 * Created by Matt on 11/22/2014.
 */
public class WallBreakAI extends MmAi {
    private int speed;
    private int ticks;
    private float maxRgSq;
    private BlockIterator blocksInPath;

    public WallBreakAI(MurderZombie zombie) {
        this.zombie = zombie;
    }
    @Override
    public boolean canStart() {
        MurderousMobs.DEBUG("WallBreakAI Start");
        return zombie.canBuild() && blocksInPath();
    }

    @Override
    public void end() {
        ticks = 0;
    }

    @Override
    public boolean shouldContinue() {
        if(!zombie.canBuild()) {
            return false;
        }
        return blocksInPath() && zombie.getTarget() != null;
    }

    @Override
    public void start() {

    }

    @Override
    public void tick() {
        if(zombie.getTarget() == null) {
            return;
        }else if (!zombie.canBuild()) {
            return;
        }else {
            ticks++;
        }

        if (ticks >=20) {
            blockRemoved(getBlocksInPath(zombie.getBukkitEntity().getLocation(), zombie.getTarget().getBukkitEntity().getLocation()));
            ticks = 0;
        }

    }

    public boolean blocksInPath() {
        if(zombie.getTarget() == null) {
            return false;
        }
        BlockIterator blocksInPath = getBlocksInPath(zombie.getBukkitEntity().getLocation(), zombie.getTarget().getBukkitEntity().getLocation());
        while(blocksInPath.hasNext()) {
            switch (blocksInPath.next().getType()) {
                case AIR:
                case TORCH:
                case REDSTONE_TORCH_ON:
                case REDSTONE_TORCH_OFF:
                case REDSTONE:
                case LONG_GRASS:
                case FIRE:
                case WATER:
                    return false;
                default:
                    return true;
            }
        }
        return false;
    }

    public boolean blockRemoved(BlockIterator bip){
        while(bip.hasNext()) {
            Location tLoc = zombie.getTarget().getBukkitEntity().getLocation();
            switch (bip.next().getType()) {
                case AIR:
                case TORCH:
                case REDSTONE_TORCH_ON:
                case REDSTONE_TORCH_OFF:
                case REDSTONE:
                case LONG_GRASS:
                case FIRE:
                case WATER:
                    break;
                default:
                    zombie.getNavigation().a(tLoc.getX(), tLoc.getY(), tLoc.getZ());
                    return EntityBlockInteract.entityBreakBlock((LivingEntity)zombie, bip.next());
            }

        }
        return false;
    }

    public BlockIterator getBlocksInPath(Location zLoc, Location targetLoc) {
        if(this.blocksInPath == null) {
            this.blocksInPath = new BlockIterator(zLoc.getWorld(), zLoc.toVector(), targetLoc.toVector().subtract(zLoc.toVector()).normalize(), 0, (int) zLoc.distance(targetLoc));
        }
        return this.blocksInPath;
    }
}
