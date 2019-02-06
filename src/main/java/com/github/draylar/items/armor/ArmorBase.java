package com.github.draylar.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class ArmorBase extends ArmorItem
{
    public ArmorBase(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1, String name)
    {
        super(armorMaterial_1, equipmentSlot_1, new Item.Settings().itemGroup(ItemGroup.COMBAT));
        registerItem(this, name);
    }

    /**
     * Registers this item. Called in super constructor so all items are automatically registered.
     * @param item 'this'
     * @param name name of the item
     */
    private void registerItem(Item item, String name)
    {
        Registry.register(Registry.ITEM, "slime-launcher:" + name, item);
    }
}
