package com.unixkitty.finallyfarmabledyes.datagen;

public class ModLootTables// extends BlockLootProvider
{
    /*
        Standard block drops (1 of itself) will get registered automatically if no override will be added
     *//*
    public ModLootTables(DataGenerator generator)
    {
        super(FinallyFarmableDyes.MODID, generator);

        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (FinallyFarmableDyes.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                registerLoot(block, block1 -> genFlowerCrop((BlockDyeCrop) block1));
            }
        }
    }

    protected static LootTable.Builder genFlowerCrop(BlockDyeCrop block)
    {
        return droppingAndBonusWhen(
                block.getFlowerItem(),
                block.getBaseSeedId(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(
                        StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3)
                ));
    }

    protected static LootTable.Builder droppingAndBonusWhen(ItemLike crop, ItemLike seed, LootItemCondition.Builder condition)
    {
        return withExplosionDecay(
                LootTable.lootTable().withPool(
                        LootPool.lootPool().add(
                                LootItem.lootTableItem(crop).when(condition).otherwise(
                                        LootItem.lootTableItem(seed)
                                ))).withPool(
                                        LootPool.lootPool().when(condition).add(
                                                LootItem.lootTableItem(crop).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))
        );
    }

    protected static <T> T withExplosionDecay(FunctionUserBuilder<T> loot)
    {
        return loot.apply(ApplyExplosionDecay.explosionDecay());
    }

    @Override
    public String getName()
    {
        return FinallyFarmableDyes.MODNAME + " " + this.getClass().getSimpleName();
    }*/
}
