package com.ren.lumen.server.entity.goal;

import com.ren.lumen.server.entity.LumenEntity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;

import java.util.List;

public class NearestItemGoal extends Goal {
    private final LumenEntity lumenEntity;
    private final double speedModifier;
    private ItemEntity targetItem;

    public NearestItemGoal(LumenEntity lumenEntity, double speedModifier) {
        this.lumenEntity = lumenEntity;
        this.speedModifier = speedModifier;
    }

    @Override
    public boolean canUse() {
        if (!this.lumenEntity.getMainHandItem().isEmpty()) {
            return false; // Si la entidad ya tiene un objeto en la mano, no puede recoger otro
        }

        List<ItemEntity> list = this.lumenEntity.level().getEntitiesOfClass(ItemEntity.class, this.lumenEntity.getBoundingBox().inflate(16.0D, 8.0D, 16.0D), EntitySelector.ENTITY_STILL_ALIVE);
        double d0 = Double.MAX_VALUE;

        for (ItemEntity itemEntity : list) {
            double d1 = this.lumenEntity.distanceToSqr(itemEntity);
            if (d1 <= d0) {
                d0 = d1;
                this.targetItem = itemEntity;
            }
        }
        return this.targetItem != null;
    }


    @Override
    public void start() {
        if (this.lumenEntity.getMainHandItem().isEmpty()) {
            this.lumenEntity.getNavigation().moveTo(this.targetItem, this.speedModifier);
        }
    }

    @Override
    public void stop() {
        this.lumenEntity.getNavigation().stop();
        this.targetItem = null;
    }

    @Override
    public boolean canContinueToUse() {
        return !this.lumenEntity.getNavigation().isDone();
    }
}
