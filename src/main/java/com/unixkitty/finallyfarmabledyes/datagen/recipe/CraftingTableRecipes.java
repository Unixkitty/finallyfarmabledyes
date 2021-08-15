package com.unixkitty.finallyfarmabledyes.datagen.recipe;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.finallyfarmabledyes.block.BlockDyeCrop;
import com.unixkitty.gemspork.lib.HelperUtil;
import com.unixkitty.gemspork.lib.datagen.recipe.CraftingTableRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Consumer;

public class CraftingTableRecipes extends CraftingTableRecipeProvider
{
    public CraftingTableRecipes(DataGenerator generator)
    {
        super(FinallyFarmableDyes.MODID, generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (FinallyFarmableDyes.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                BlockDyeCrop crop = (BlockDyeCrop) block;
                IItemProvider seed = crop.getBaseSeedId();
                IItemProvider flower = crop.getFlowerItem();

                ShapelessRecipeBuilder.shapeless(seed, 2)
                        .requires(flower)
                        .requires(flower)
                        .unlockedBy("has_item", has(flower))
                        .save(consumer);
            }
        }

        ShapedRecipeBuilder.shaped(Items.WITHER_ROSE, 8)
                .define('r', Items.POPPY)
                .define('s', Items.WITHER_SKELETON_SKULL)
                .pattern("rrr")
                .pattern("rsr")
                .pattern("rrr")
                .unlockedBy("has_item", has(Items.WITHER_SKELETON_SKULL))
                .save(consumer, HelperUtil.prefixResource(FinallyFarmableDyes.MODID, "wither_rose"));
    }
}