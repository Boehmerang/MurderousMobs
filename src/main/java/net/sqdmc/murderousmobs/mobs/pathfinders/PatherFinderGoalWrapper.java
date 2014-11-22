package net.sqdmc.murderousmobs.mobs.pathfinders;

import net.minecraft.server.v1_7_R4.PathfinderGoal;
import net.sqdmc.murderousmobs.mobs.ai.MmAi;

/**
 * Created by Matt on 11/22/2014.
 */
public class PatherFinderGoalWrapper extends PathfinderGoal {
    private MmAi ai;

    public PatherFinderGoalWrapper(MmAi ai) {
        this.ai = ai;
        a(ai.a);
    }
    @Override
    public boolean a() {
        return ai.canStart();
    }

    @Override
    public void c() {
        ai.start();
    }

    @Override
    public void e() {
        ai.tick();
    }

    @Override
    public void d() {
        ai.end();
    }
}
