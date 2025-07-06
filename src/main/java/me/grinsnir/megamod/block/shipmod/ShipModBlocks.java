package me.grinsnir.megamod.block.shipmod;

import me.grinsnir.megamod.MegaMod;
import me.grinsnir.megamod.item.ShipModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Locale;
import java.util.function.Supplier;

public class ShipModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MegaMod.MOD_ID);

    //Floater-Block
    public static final DeferredBlock<Block> FLOATER = registerBlock("floater",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOL)
                    .instabreak()
            )
    );

    //SteeringWheelBlock
    public static final DeferredBlock<Block> STEERING_WHEEL = registerBlock("steering_wheel",
            () -> new SteeringWheelBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2f)
                    .noOcclusion()

            )

    );




    //Register-Methods
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ShipModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
