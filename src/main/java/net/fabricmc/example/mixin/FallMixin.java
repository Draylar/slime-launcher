package net.fabricmc.example.mixin;


import net.fabricmc.example.SlimeLauncher;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Block.class)
public abstract class FallMixin
{
    public void onLandedUpon (World world_1, BlockPos blockPos_1, Entity entity_1, float float_1)
    {
        if(entity_1 instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) entity_1;

            // require slime boots to jump
            if(playerEntity.inventory.armor.get(0).getItem().equals(SlimeLauncher.slimeBoots))
            {
                // check sneak
                if(playerEntity.isSneaking())
                {
                    playerEntity.handleFallDamage(float_1, 1.0F);
                    playerEntity.velocityY = 0;
                }

                else
                {
                    // send them back up if their current velocity is over a threshold
                    if (playerEntity.velocityY <= -0.5)
                    {
                        playerEntity.velocityY = -playerEntity.velocityY;

                        // play slimey sound
                        world_1.playSound((double) playerEntity.getPos().getX(),(double) playerEntity.getPos().getY(),(double) playerEntity.getPos().getZ(), SoundEvents.BLOCK_SLIME_BLOCK_BREAK, SoundCategory.PLAYER, 1f, 1f, false);
                    }

                    // multiply directional velocity so you don't stop as quickly
                    playerEntity.velocityX*=1.3;
                    playerEntity.velocityZ*=1.3;
                }
            }

            else
            {
                playerEntity.handleFallDamage(float_1, 1.0F);
            }
        }

        else
        {
            entity_1.handleFallDamage(float_1, 1.0F);
        }
    }

    public void onEntityLand (BlockView blockView_1, Entity entity_1)
    {
        entity_1.velocityY = Math.max(0, entity_1.velocityY);
    }
}
