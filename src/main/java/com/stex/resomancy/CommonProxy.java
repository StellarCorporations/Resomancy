package com.stex.resomancy;

import com.stex.resomancy.block.Blocks;
import com.stex.resomancy.item.Items;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent e)
    {
    	Items.createItems();
    	Blocks.createBlocks();
    	Blocks.registerTileEntities();
    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
