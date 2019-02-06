package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.items.ItemSlimeLauncher;
import net.fabricmc.example.items.armor.ItemSlimeBoots;

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
