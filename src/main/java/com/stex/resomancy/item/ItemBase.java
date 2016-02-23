package com.stex.resomancy.item;

import com.stex.resomancy.ResomancyMod;

import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase(String unlocalizedName)
	{
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ResomancyMod.tabResomancy);
	}
}
