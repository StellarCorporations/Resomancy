package com.stex.resomancy;

import com.stex.resomancy.creativetab.CreativeTabResomancy;
import com.stex.resomancy.gui.GuiHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = ResomancyMod.MODID, name = ResomancyMod.NAME, version = ResomancyMod.VERSION/*, dependencies = ResomancyMod.DEPENDENCIES*/)
public class ResomancyMod
{
	public static CreativeTabs tabResomancy = new CreativeTabResomancy(CreativeTabs.getNextID(), "tabResomancy");
	public static final String MODID = "resomancy";
	public static final String NAME = "Resomancy";
    public static final String VERSION = "0.0_0";
    //public static final String DEPENDENCIES = "required-after:stexutil@0.0_0";
    
    @Instance
    public static ResomancyMod instance = new ResomancyMod();
 
    @SidedProxy(clientSide = "com.stex.resomancy.proxy.ClientProxy", serverSide = "com.stex.resomancy.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	this.proxy.preInit(e);
    }

	@EventHandler
    public void init(FMLInitializationEvent e)
    {
    	this.proxy.init(e);
    	NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) 
    {
    	this.proxy.postInit(e);
    }
}
