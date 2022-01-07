package com.unixkitty.finallyfarmabledyes.block;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
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
    private final ItemLike flowerItem;
    private final NonNullLazy<ItemLike> seeds;

    public BlockDyeCrop(ItemLike flowerItem, DyeColor color)
    {
        super(Block.Properties.copy(Blocks.BEETROOTS));

        this.flowerItem = flowerItem;
        this.seeds = NonNullLazy.of(() ->
                Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(FinallyFarmableDyes.MODID, color.toString())))
        );
    }

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
        return this.flowerItem;
    }
}
