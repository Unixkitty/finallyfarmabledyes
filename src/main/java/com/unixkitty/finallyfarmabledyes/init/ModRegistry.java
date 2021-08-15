package com.unixkitty.finallyfarmabledyes.init;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FinallyFarmableDyes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModRegistry
{
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        // BlockItem seeds for all blocks
        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
                event.getRegistry().register(new BlockNamedItem(block, new Item.Properties().tab(ItemGroup.TAB_MATERIALS)).setRegistryName(Objects.requireNonNull(block.getRegistryName())))
        );
    }
}
