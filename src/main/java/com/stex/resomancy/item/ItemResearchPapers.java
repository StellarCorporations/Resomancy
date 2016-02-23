package com.stex.resomancy.item;

import com.stex.resomancy.ResomancyMod;
import com.stex.resomancy.gui.GuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemResearchPapers extends ItemBase
{

	public ItemResearchPapers(String unlocalizedName)
	{
		super(unlocalizedName);
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(!worldIn.isRemote)
		{
			if(playerIn.isSneaking())
			{
				playerIn.openGui(ResomancyMod.instance, GuiHandler.GUI_RESEARCHPAPERS, worldIn, (int)hitX, (int)hitY, (int)hitZ);
			}
		}
        return false;
    }
	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) 
	{
		
	}
}
