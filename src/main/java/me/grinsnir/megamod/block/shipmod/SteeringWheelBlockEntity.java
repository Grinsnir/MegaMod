package me.grinsnir.megamod.block.shipmod;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SteeringWheelBlockEntity extends BlockEntity {

    public SteeringWheelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STEERING_WHEEL.get(), pos, state);
    }

    // Beispiel: Aktiviert-Status speichern
    private boolean activated = false;

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
        setChanged(); // Markiert BlockEntity für Speicherung
    }
}
