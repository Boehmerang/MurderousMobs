package net.sqdmc.murderousmobs.mobs.ai;

import net.sqdmc.murderousmobs.mobs.MurderZombie;

/**
 * Created by Matt on 11/22/2014.
 */
public abstract class MmAi {
    protected MurderZombie zombie;
    public int a;

    public abstract boolean canStart();

    public abstract void end();

    public abstract boolean shouldContinue();

    public abstract void start();

    public abstract void tick();
}
