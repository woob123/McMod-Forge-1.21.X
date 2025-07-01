package net.woob123.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.woob123.tutorialmod.item.ModItems;

public class MagicBlock extends Block {

    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        Level world = pLevel;


        pLevel.playSound(pPlayer, pPos, SoundEvents.ENDER_DRAGON_DEATH, SoundSource.BLOCKS, 4.0f, 0.2f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {

            /* Access persistent data on the item entity itself -> persistent data = custom data that can be stored on
                                                                        various game elements (like entities, items, and blocks)
                                                                        and remains accessible even after server restarts or player
                                                                        disconnects.
               compound tag -> holds multiple tags, like a folder holds files kind of
            */
            CompoundTag data = itemEntity.getPersistentData();
            if (!data.getBoolean("SoundPlayed")) {

                ItemStack stack = itemEntity.getItem();

                if (stack.getItem() == ModItems.ALEXANDRITE.get()) {
                    itemEntity.setItem(new ItemStack(Items.DIAMOND, stack.getCount()));
                }

                if (stack.getItem() == Items.DIRT) {
                    itemEntity.setItem(new ItemStack(Items.NETHERITE_BLOCK, 256));
                }

                level.playSound(entity, pos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 4.0f, 0.2f);

                data.putBoolean("SoundPlayed", true); // mark the sound as played
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
