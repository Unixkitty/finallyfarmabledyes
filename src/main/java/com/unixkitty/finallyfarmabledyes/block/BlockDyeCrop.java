package com.unixkitty.finallyfarmabledyes.block;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.NonNullLazy;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BlockDyeCrop extends BeetrootBlock
{
    private final DyeColor color;
    //    private final LazyLoadedValue<ItemLike> seeds;
    private final NonNullLazy<ItemLike> seeds;

    public BlockDyeCrop(DyeColor color)
    {
        super(Block.Properties.copy(Blocks.BEETROOTS));

        this.color = color;
        this.seeds = NonNullLazy.of(() ->
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(FinallyFarmableDyes.MODID, color.toString())))
        );
    }

/*    public DyeColor getColor()
    {
        return this.color;
    }*/

    //Seed
    @Override
    public ItemLike getBaseSeedId()
    {
        return seeds.get();
    }

    //Not seed?
    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState state)
    {
        return new ItemStack(getFlowerItem());
    }


    public ItemLike getFlowerItem()
    {
        return switch (this.color)
                {
                    case WHITE -> Items.LILY_OF_THE_VALLEY;
                    case ORANGE -> Items.ORANGE_TULIP;
                    case MAGENTA -> Items.ALLIUM;
                    case LIGHT_BLUE -> Items.BLUE_ORCHID;
                    case YELLOW -> Items.DANDELION;
                    case PINK -> Items.PINK_TULIP;
                    case LIGHT_GRAY -> Items.WHITE_TULIP;
                    case BLUE -> Items.CORNFLOWER;
                    case BLACK -> Items.WITHER_ROSE;
                    default -> Items.BEEF;
                };
    }
}
