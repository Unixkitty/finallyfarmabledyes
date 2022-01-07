package com.unixkitty.finallyfarmabledyes.block;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockDyeCrop extends BeetrootBlock
{
    private final IItemProvider flowerItem;
    private final LazyValue<IItemProvider> seeds;

    public BlockDyeCrop(IItemProvider flowerItem, DyeColor color)
    {
        super(Block.Properties.copy(Blocks.BEETROOTS));

        this.flowerItem = flowerItem;
        this.seeds = new LazyValue<>(() ->
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(FinallyFarmableDyes.MODID, color.toString()))
        );
    }

    //Seed
    @Override
    public IItemProvider getBaseSeedId()
    {
        return seeds.get();
    }

    //Not seed?
    @Override
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state)
    {
        return new ItemStack(getFlowerItem());
    }

    /*public IItemProvider getFlowerItem()
    {
        switch (this.color)
        {
            case WHITE:
                return Items.LILY_OF_THE_VALLEY;
            case ORANGE:
                return Items.ORANGE_TULIP;
            case MAGENTA:
                return Items.ALLIUM;
            case LIGHT_BLUE:
                return Items.BLUE_ORCHID;
            case YELLOW:
                return Items.DANDELION;
            case PINK:
                return Items.PINK_TULIP;
            case LIGHT_GRAY:
                return Items.WHITE_TULIP;
            case BLUE:
                return Items.CORNFLOWER;
            case RED:
                return Items.POPPY;
            case BLACK:
                return Items.WITHER_ROSE;
            default:
                return Items.BEEF;
        }
    }*/

    public IItemProvider getFlowerItem()
    {
        return this.flowerItem;
    }
}
