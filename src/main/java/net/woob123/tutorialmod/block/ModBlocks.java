package net.woob123.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.woob123.tutorialmod.TutorialMod;
import net.woob123.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    /// A list of our blocks basically
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

     public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
             () -> new Block(BlockBehaviour.Properties.of()
                     .strength(4F)
                     .requiresCorrectToolForDrops()
                     .sound(SoundType.AMETHYST)));
     public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
             () -> new Block(BlockBehaviour.Properties.of()
                     .strength(4F)
                     .requiresCorrectToolForDrops()
                     .sound(SoundType.STONE)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
