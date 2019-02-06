package net.fabricmc.example.items.armor;

import net.minecraft.entity.EquipmentSlot;

public class ItemSlimeBoots extends ArmorBase
{
    public ItemSlimeBoots()
    {
        super(CustomArmorMaterial.SLIME, EquipmentSlot.FEET, "slime_boots");
    }
}
