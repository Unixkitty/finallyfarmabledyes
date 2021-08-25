package com.unixkitty.finallyfarmabledyes.datagen.recipe;

public class CraftingTableRecipes// extends CraftingTableRecipeProvider
{
    /*public CraftingTableRecipes(DataGenerator generator)
    {
        super(FinallyFarmableDyes.MODID, generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer)
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (FinallyFarmableDyes.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                BlockDyeCrop crop = (BlockDyeCrop) block;
                ItemLike seed = crop.getBaseSeedId();
                ItemLike flower = crop.getFlowerItem();

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
    }*/
}