package com.unixkitty.finallyfarmabledyes.init;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FinallyFarmableDyes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModRegistry
{
//    private static final List<ItemStack> chickenFoodList = new ArrayList<>();

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final List<ItemStack> chickenFoodList = new ArrayList<>(Arrays.stream(Chicken.FOOD_ITEMS.getItems()).toList());

        // BlockItem seeds for all blocks
        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
        {
            Item item = new ItemNameBlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)).setRegistryName(Objects.requireNonNull(block.getRegistryName()));

            event.getRegistry().register(item);

            ComposterBlock.COMPOSTABLES.putIfAbsent(item, ComposterBlock.COMPOSTABLES.getOrDefault(Items.WHEAT_SEEDS, 0.3f));

            chickenFoodList.add(new ItemStack(item));
        });

        Chicken.FOOD_ITEMS = Ingredient.of(chickenFoodList.stream());
    }
}
