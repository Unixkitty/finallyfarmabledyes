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
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (FinallyFarmableDyes.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                BlockDyeCrop crop = (BlockDyeCrop) block;
                IItemProvider seed = crop.getSeedsItem();
                IItemProvider flower = crop.getFlowerItem();

                ShapelessRecipeBuilder.shapelessRecipe(seed, 2)
                        .addIngredient(flower)
                        .addIngredient(flower)
                        .addCriterion("has_item", hasItem(flower))
                        .build(consumer);
            }
        }

        ShapedRecipeBuilder.shapedRecipe(Items.WITHER_ROSE, 8)
                .key('r', Items.POPPY)
                .key('s', Items.WITHER_SKELETON_SKULL)
                .patternLine("rrr")
                .patternLine("rsr")
                .patternLine("rrr")
                .addCriterion("has_item", hasItem(Items.WITHER_SKELETON_SKULL))
                .build(consumer, HelperUtil.prefixResource(FinallyFarmableDyes.MODID, "wither_rose"));
    }
}