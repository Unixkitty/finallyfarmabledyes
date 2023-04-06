package com.unixkitty.finallyfarmabledyes.init;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.finallyfarmabledyes.block.BlockDyeCrop;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public final class ModRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FinallyFarmableDyes.MODID);
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

    private static RegistryObject<Block> registerCrop(ItemLike flowerItem, DyeColor color)
    {
        return register(color.toString(), flowerItem, color);
    }

    private static RegistryObject<Block> registerExtraCrop(ItemLike flowerItem, DyeColor color)
    {
        return register(ForgeRegistries.ITEMS.getKey(flowerItem.asItem()).getPath(), flowerItem, color);
    }

    private static RegistryObject<Block> register(final String name, ItemLike flowerItem, DyeColor color)
    {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new BlockDyeCrop(flowerItem, color));

        ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

        return block;
    }
}
