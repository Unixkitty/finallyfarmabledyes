package com.unixkitty.finallyfarmabledyes.init;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.finallyfarmabledyes.block.BlockDyeCrop;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FinallyFarmableDyes.MODID);

    /*
            WHITE           Lily of the Valley
            ORANGE          Orange Tulip
            MAGENTA         Allium
            LIGHT_BLUE      Blue Orchid
            YELLOW          Dandelion
            PINK            Pink Tulip
            LIGHT_GRAY      White Tulip
            BLUE            Cornflower
            BLACK           Wither Rose

         */

    public static final RegistryObject<Block> WHITE = registerCrop(DyeColor.WHITE);
    public static final RegistryObject<Block> ORANGE = registerCrop(DyeColor.ORANGE);
    public static final RegistryObject<Block> MAGENTA = registerCrop(DyeColor.MAGENTA);
    public static final RegistryObject<Block> LIGHT_BLUE = registerCrop(DyeColor.LIGHT_BLUE);
    public static final RegistryObject<Block> YELLOW = registerCrop(DyeColor.YELLOW);
    public static final RegistryObject<Block> PINK = registerCrop(DyeColor.PINK);
    public static final RegistryObject<Block> LIGHT_GRAY = registerCrop(DyeColor.LIGHT_GRAY);
    public static final RegistryObject<Block> BLUE = registerCrop(DyeColor.BLUE);
    public static final RegistryObject<Block> BLACK = registerCrop(DyeColor.BLACK);

    private static RegistryObject<Block> registerCrop(DyeColor color)
    {
        return BLOCKS.register(color.toString(), () -> new BlockDyeCrop(color));
    }
}
