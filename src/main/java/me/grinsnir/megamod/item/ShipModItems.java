package me.grinsnir.megamod.item;

import me.grinsnir.megamod.MegaMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ShipModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MegaMod.MOD_ID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
