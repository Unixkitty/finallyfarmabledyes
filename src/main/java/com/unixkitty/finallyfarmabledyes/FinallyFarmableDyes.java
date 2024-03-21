package com.unixkitty.finallyfarmabledyes;

import com.unixkitty.finallyfarmabledyes.init.ModRegistry;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod(FinallyFarmableDyes.MODID)
public class FinallyFarmableDyes
{
    // The MODID value here should match an entry in the META-INF/mods.toml file
    public static final String MODID = "finallyfarmabledyes";
    public static final String MODNAME = "Finally Farmable Dyes";

    private static final Logger LOG = LogManager.getLogger(MODNAME);

    public FinallyFarmableDyes()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRegistry.BLOCKS.register(modEventBus);
        ModRegistry.ITEMS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            final List<ItemStack> chickenFoodList = new ArrayList<>(Arrays.stream(Chicken.FOOD_ITEMS.getItems()).toList());

            ModRegistry.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(item ->
            {
                ComposterBlock.COMPOSTABLES.putIfAbsent(item, ComposterBlock.COMPOSTABLES.getOrDefault(Items.WHEAT_SEEDS, 0.3f));

                chickenFoodList.add(new ItemStack(item));
            });

            Chicken.FOOD_ITEMS = Ingredient.of(chickenFoodList.stream());
        });
    }
}
