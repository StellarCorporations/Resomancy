package com.stex.resomancy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ResomancyMod.MODID, name = ResomancyMod.NAME, version = ResomancyMod.VERSION/*, dependencies = ResomancyMod.DEPENDENCIES*/)
public class ResomancyMod
{
	public static final String MODID = "resomancy";
	public static final String NAME = "Resomancy";
    public static final String VERSION = "0.0_0";
    //public static final String DEPENDENCIES = "required-after:stexutil@0.0_0";
    
    @Instance
    public static ResomancyMod instance = new ResomancyMod();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) 
    {
    	
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) 
    {
    	
    }
}
