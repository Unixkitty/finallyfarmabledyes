package com.unixkitty.finallyfarmabledyes.datagen;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.finallyfarmabledyes.datagen.recipe.CraftingTableRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

//This gets called directly by Forge?
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FinallyFarmableDyes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer())
        {
            generator.addProvider(new ModLootTables(generator));
            generator.addProvider(new CraftingTableRecipes(generator));
        }
    }
}
