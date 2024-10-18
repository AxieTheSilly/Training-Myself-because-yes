package net.Axie.TurtorialMod.CreativeModeTabs;

import net.Axie.TurtorialMod.Axie;
import net.Axie.TurtorialMod.Item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Axie.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENDERITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("enderite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERITE.get()))
                    .title(Component.translatable("creativetab.Axie.enderite_items"))
                    .displayItems((itemDisplayParaments, output) -> {
                        output.accept(ModItems.ENDERITE.get());
                        output.accept(ModItems.ENDERITE_INGOT.get());
                    })

                    .build());


    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }

}
