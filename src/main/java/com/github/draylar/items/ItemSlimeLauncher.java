package com.github.draylar.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemSlimeLauncher extends ItemBase
{
    public ItemSlimeLauncher()
    {
        super("slime_launcher", 1, ItemGroup.COMBAT);
    }

    @Override
    public int getMaxUseTime(ItemStack itemStack_1)
    {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack itemStack_1)
    {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1)
    {
        playerEntity_1.setCurrentHand(hand_1);
        return super.use(world_1, playerEntity_1, hand_1);
    }

    @Override
    public void onItemStopUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1, int int_1)
    {
        if(livingEntity_1.onGround)
        {
            // get velocity modifier from the draw count
            float drawCount = Math.min(20, getMaxUseTime(itemStack_1) - int_1) + 0.1f;
            float velocityModifier = drawCount / 20f;

            // get vector of player looking direction
            Vec3d vec = livingEntity_1.getRotationVecClient();

            // apply backwards velocity
            if (livingEntity_1.onGround) livingEntity_1.addVelocity(
                    -vec.x * velocityModifier * 13,
                    0,
                    -vec.z * velocityModifier * 13
            );

            // set vertical velocity directly
            livingEntity_1.velocityY = 2.25 * velocityModifier;

            // play slimey sound
            world_1.playSound((double) livingEntity_1.getPos().getX(), (double) livingEntity_1.getPos().getY(), (double) livingEntity_1.getPos().getZ(), SoundEvents.BLOCK_SLIME_BLOCK_BREAK, SoundCategory.PLAYER, 1f, 1f, false);
        }

        super.onItemStopUsing(itemStack_1, world_1, livingEntity_1, int_1);
    }
}
