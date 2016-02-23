package com.stex.resomancy.item;

import com.stex.resomancy.ResomancyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Items
{
	public static Item researchPapers;
	
	public static final void createItems()
	{
		GameRegistry.registerItem(researchPapers = new ItemBase("researchPapers"), "researchPapers");
    }
	
	public static final void registerItemRenderer()
	{
		reg(researchPapers);
	}
	
	private static void reg(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ResomancyMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
