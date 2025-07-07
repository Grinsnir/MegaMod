package me.grinsnir.megamod.block.shipmod.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SteeringWheelBlockEntity extends BlockEntity {
    public SteeringWheelBlockEntity(BlockPos pos, BlockState blockState) {
        super(ShipModBlockEntities.STEERING_WHEEL_BE.get(), pos, blockState);
    }
}
