package me.grinsnir.megamod.block.shipmod.entity;

import me.grinsnir.megamod.MegaMod;
import me.grinsnir.megamod.block.shipmod.ShipModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ShipModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MegaMod.MOD_ID);


    //EntityBlockRegister
    public static final Supplier<BlockEntityType<SteeringWheelBlockEntity>> STEERING_WHEEL_BE =
            BLOCK_ENTITIES.register("steering_wheel_be", () -> BlockEntityType.Builder.of(
                    SteeringWheelBlockEntity::new, ShipModBlocks.STEERING_WHEEL.get()).build(null));



    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
