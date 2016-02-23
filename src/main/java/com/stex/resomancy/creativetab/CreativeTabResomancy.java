package com.stex.resomancy.creativetab;

import com.stex.resomancy.item.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabResomancy extends CreativeTabs
{

	public CreativeTabResomancy(int id, String unlocalizedName)
	{
		super(id, unlocalizedName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return net.minecraft.init.Items.comparator;
	}

}
