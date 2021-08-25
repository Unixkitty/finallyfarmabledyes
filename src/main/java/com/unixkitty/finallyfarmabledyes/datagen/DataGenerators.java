package com.unixkitty.finallyfarmabledyes.datagen;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FinallyFarmableDyes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators
{
    /*@SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer())
        {
            generator.addProvider(new ModLootTables(generator));
            generator.addProvider(new CraftingTableRecipes(generator));
        }
    }*/
}
