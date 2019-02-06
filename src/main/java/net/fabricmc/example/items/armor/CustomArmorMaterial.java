package net.fabricmc.example.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CustomArmorMaterial
{
    public static ArmorMaterial SLIME = new ArmorMaterial()
    {
        @Override
        public int getDurability(EquipmentSlot equipmentSlot)
        {
            return -1;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot equipmentSlot)
        {
            return 1;
        }

        @Override
        public int getEnchantability()
        {
            return 0;
        }

        @Override
        public SoundEvent getEquipSound()
        {
            return SoundEvents.BLOCK_SLIME_BLOCK_PLACE;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.SLIME_BALL);
        }

        @Override
        public String getName()
        {
            return "leather";
        }

        @Override
        public float getToughness()
        {
            return 0;
        }
    };
}
