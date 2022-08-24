package com.github.coda1552.dragonsscourge.common.entity;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class DragonArrowEntity extends AbstractArrow {
    
    public DragonArrowEntity(EntityType<? extends AbstractArrow> entity, Level level) {
        super(entity, level);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        Direction dir = result.getDirection();
        BlockPos pos = result.getBlockPos().relative(dir);

        level.addParticle(new DustParticleOptions(new Vector3f(0.65F, 0.0F, 0.95F), 0.5F), pos.getX(), pos.getY(), pos.getX(), 0.0, 0.0, 0.0);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
