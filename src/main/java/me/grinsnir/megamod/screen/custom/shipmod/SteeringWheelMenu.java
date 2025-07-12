package me.grinsnir.megamod.screen.custom.shipmod;

import me.grinsnir.megamod.block.shipmod.ShipModBlocks;
import me.grinsnir.megamod.block.shipmod.entity.SteeringWheelBlockEntity;
import me.grinsnir.megamod.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class SteeringWheelMenu extends AbstractContainerMenu {
    public final SteeringWheelBlockEntity blockEntity;
    private final Level level;

    public SteeringWheelMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public SteeringWheelMenu(int containerId, Inventory inv, BlockEntity blockEntity){
        super(ModMenuTypes.STEERING_WHEEL_MENU.get(), containerId);
        this.blockEntity = ((SteeringWheelBlockEntity) blockEntity);
        this.level = inv.player.level();

        //Player Inventory + Hotbar
        /**
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        **/
        //this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0, 80, 35));

    }

    //Player Inventory + Hotbar, if needed
    /**
    private void addPlayerInventory(Inventory playerInventory){
        for (int i= 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i *18, 142));
        }
    }
    **/

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        //If needed, see https://www.youtube.com/watch?v=WBeZp9MQmBE&list=PLKGarocXCE1G6CQOoiYdMVx-E1d9F_itF&index=61 around 09:00
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ShipModBlocks.STEERING_WHEEL.get());
    }
}
