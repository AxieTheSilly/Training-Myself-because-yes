package net.Axie.TurtorialMod.block;

import net.Axie.TurtorialMod.Axie;
import net.Axie.TurtorialMod.Item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Axie.MOD_ID);

    public static final RegistryObject<Block> ENDERITE_BLOCK = registerBlock("enderite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ENDERITE_INGOT_BLOCK = registerBlock("enderite_ingot_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f).requiresCorrectToolForDrops().explosionResistance(1000)
                    .sound(SoundType.ANCIENT_DEBRIS)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
