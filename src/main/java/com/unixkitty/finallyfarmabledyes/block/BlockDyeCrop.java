package com.unixkitty.finallyfarmabledyes.block;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.gemspork.lib.HelperUtil;
import net.minecraft.block.*;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockDyeCrop extends BeetrootBlock
{
    private final DyeColor color;
    private final LazyValue<IItemProvider> seeds;

    public BlockDyeCrop(DyeColor color)
    {
        super(Block.Properties.from(Blocks.BEETROOTS));

        this.color = color;
        this.seeds = new LazyValue<>(() ->
                ForgeRegistries.ITEMS.getValue(HelperUtil.prefixResource(FinallyFarmableDyes.MODID, color.toString()))
        );
    }

/*    public DyeColor getColor()
    {
        return this.color;
    }*/

    //Seed
    @Override
    public IItemProvider getSeedsItem()
    {
        return seeds.getValue();
    }

    //Not seed?
    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
    {
        return new ItemStack(getFlowerItem());
    }

    public IItemProvider getFlowerItem()
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
            case BLACK:
                return Items.WITHER_ROSE;
            default:
                return Items.BEEF;
        }
    }
}
