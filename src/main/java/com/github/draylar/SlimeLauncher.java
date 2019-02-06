package com.github.draylar;

import com.github.draylar.items.armor.ItemSlimeBoots;
import net.fabricmc.api.ModInitializer;
import com.github.draylar.items.ItemSlimeLauncher;

public class SlimeLauncher implements ModInitializer {

	public static ItemSlimeLauncher slimeLauncher;
	public static ItemSlimeBoots slimeBoots;

	@Override
	public void onInitialize()
	{
		System.out.println("[SLIME LAUNCHER] Time to get slimey!");

		slimeLauncher = new ItemSlimeLauncher();
		slimeBoots = new ItemSlimeBoots();
	}
}
