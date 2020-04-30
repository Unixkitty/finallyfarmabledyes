package com.unixkitty.finallyfarmabledyes;

import com.unixkitty.finallyfarmabledyes.init.ModBlocks;
import com.unixkitty.finallyfarmabledyes.init.ModRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        MinecraftForge.EVENT_BUS.register(ModRegistry.class);

        ModBlocks.BLOCKS.register(modEventBus);
    }

    public static Logger log()
    {
        return LOG;
    }
}
