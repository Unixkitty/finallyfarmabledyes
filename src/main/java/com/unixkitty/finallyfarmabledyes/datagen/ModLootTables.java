package com.unixkitty.finallyfarmabledyes.datagen;

import com.unixkitty.finallyfarmabledyes.FinallyFarmableDyes;
import com.unixkitty.finallyfarmabledyes.block.BlockDyeCrop;
import com.unixkitty.gemspork.lib.datagen.loot.BlockLootProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.loot.ILootFunctionConsumer;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModLootTables extends BlockLootProvider
{
    /*
        Standard block drops (1 of itself) will get registered automatically if no override will be added
     */
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
                BlockStateProperty.hasBlockStateProperties(block).setProperties(
                        StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 3)
                ));
    }

    protected static LootTable.Builder droppingAndBonusWhen(IItemProvider crop, IItemProvider seed, ILootCondition.IBuilder condition)
    {
        return withExplosionDecay(
                LootTable.lootTable().withPool(
                        LootPool.lootPool().add(
                                ItemLootEntry.lootTableItem(crop).when(condition).otherwise(
                                        ItemLootEntry.lootTableItem(seed)
                                ))).withPool(
                                        LootPool.lootPool().when(condition).add(
                                                ItemLootEntry.lootTableItem(crop).apply(ApplyBonus.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))
        );
    }

    protected static <T> T withExplosionDecay(ILootFunctionConsumer<T> loot)
    {
        return loot.apply(ExplosionDecay.explosionDecay());
    }

    @Override
    public String getName()
    {
        return FinallyFarmableDyes.MODNAME + " " + this.getClass().getSimpleName();
    }
}
