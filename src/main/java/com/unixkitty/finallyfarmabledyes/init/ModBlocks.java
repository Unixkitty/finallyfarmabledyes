package com.unixkitty.finallyfarmabledyes.init;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.finallyfarmabledyes.block.BlockDyeCrop;
import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

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
            RED             Poppy
            BLACK           Wither Rose

         */

    public static final RegistryObject<Block> WHITE = registerCrop(Items.LILY_OF_THE_VALLEY, DyeColor.WHITE);
    public static final RegistryObject<Block> ORANGE = registerCrop(Items.ORANGE_TULIP, DyeColor.ORANGE);
    public static final RegistryObject<Block> MAGENTA = registerCrop(Items.ALLIUM, DyeColor.MAGENTA);
    public static final RegistryObject<Block> LIGHT_BLUE = registerCrop(Items.BLUE_ORCHID, DyeColor.LIGHT_BLUE);
    public static final RegistryObject<Block> YELLOW = registerCrop(Items.DANDELION, DyeColor.YELLOW);
    public static final RegistryObject<Block> PINK = registerCrop(Items.PINK_TULIP, DyeColor.PINK);
    public static final RegistryObject<Block> LIGHT_GRAY = registerCrop(Items.WHITE_TULIP, DyeColor.LIGHT_GRAY);
    public static final RegistryObject<Block> BLUE = registerCrop(Items.CORNFLOWER, DyeColor.BLUE);
    public static final RegistryObject<Block> RED = registerCrop(Items.POPPY, DyeColor.RED);
    public static final RegistryObject<Block> BLACK = registerCrop(Items.WITHER_ROSE, DyeColor.BLACK);
    
    //Extra
    public static final RegistryObject<Block> RED_TULIP = registerExtraCrop(Items.RED_TULIP, DyeColor.RED);
    public static final RegistryObject<Block> AZURE_BLUET = registerExtraCrop(Items.AZURE_BLUET, DyeColor.LIGHT_GRAY);
    public static final RegistryObject<Block> OXEYE_DAISY = registerExtraCrop(Items.OXEYE_DAISY, DyeColor.LIGHT_GRAY);

    private static RegistryObject<Block> registerCrop(IItemProvider flowerItem, DyeColor color)
    {
        return BLOCKS.register(color.toString(), () -> new BlockDyeCrop(flowerItem, color));
    }

    private static RegistryObject<Block> registerExtraCrop(IItemProvider flowerItem, DyeColor color)
    {
        return BLOCKS.register(Objects.requireNonNull(flowerItem.asItem().getRegistryName()).getPath(), () -> new BlockDyeCrop(flowerItem, color));
    }
}
