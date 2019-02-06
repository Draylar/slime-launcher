package com.github.draylar.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class ItemBase extends Item
{
    public ItemBase(final String name, final int stackSize, final ItemGroup group)
    {
        super(new Item.Settings().stackSize(stackSize).itemGroup(group));
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
