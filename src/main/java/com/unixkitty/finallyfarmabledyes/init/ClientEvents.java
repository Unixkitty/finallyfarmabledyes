package com.unixkitty.finallyfarmabledyes.init;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FinallyFarmableDyes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents
{
    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (FinallyFarmableDyes.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                RenderTypeLookup.setRenderLayer(block, RenderType.cutout());
            }
        }
    }

}
