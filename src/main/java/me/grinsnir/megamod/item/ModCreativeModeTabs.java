package me.grinsnir.megamod.item;


import me.grinsnir.megamod.MegaMod;
import me.grinsnir.megamod.block.shipmod.ShipModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MegaMod.MOD_ID);

    //ShipModTab
    public static final Supplier<CreativeModeTab> SHIPMOD_TAB = CREATIVE_MODE_TAB.register("shipmod_tab",
            () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ShipModBlocks.FLOATER.get()))
            .title(Component.translatable("creativetab.megamod.shipmod_tab"))
            .displayItems((itemDisplayParameters,output ) -> {
        output.accept(ShipModBlocks.FLOATER);
        output.accept(ShipModBlocks.STEERING_WHEEL);

    })
            .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
