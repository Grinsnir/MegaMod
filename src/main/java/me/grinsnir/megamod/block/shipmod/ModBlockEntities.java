package me.grinsnir.megamod.block.shipmod;

import me.grinsnir.megamod.MegaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MegaMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SteeringWheelBlockEntity>> STEERING_WHEEL =
            BLOCK_ENTITIES.register("steering_wheel",
                    () -> BlockEntityType.Builder.of(SteeringWheelBlockEntity::new, ShipModBlocks.STEERING_WHEEL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
