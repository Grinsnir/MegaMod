package me.grinsnir.megamod.block.shipmod.entity;

import me.grinsnir.megamod.screen.custom.shipmod.SteeringWheelMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SteeringWheelBlockEntity extends BlockEntity implements MenuProvider {

    public SteeringWheelBlockEntity(BlockPos pos, BlockState blockState) {
        super(ShipModBlockEntities.STEERING_WHEEL_BE.get(), pos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Steering Wheel");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SteeringWheelMenu(i, inventory, this);
    }

    //Save- and LoadMethods for Blockdata
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        //tag.put("name", XYZ.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        //XYZ.deserializeNBT(registries, tag.getCompound("name"));
    }
}
