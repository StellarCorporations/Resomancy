package com.stex.resomancy.block;

import com.stex.resomancy.ResomancyMod;
import com.stex.resomancy.block.tileentity.TileEntityCrystal;
import com.stex.resomancy.block.tileentity.tesr.SpecialRendererCrystal;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class Blocks
{
	//Blocks
	public static BlockCrystal crystalBlock;
	
	
	public static void createBlocks()
	{
		regBlock(crystalBlock = new BlockCrystal("crystalBlock"), "crystal");
	}
	
	//Called from CommonProxy preInit() phase
	public static void registerTileEntities()
	{
		regTE(TileEntityCrystal.class, "tileentity_crystal");
	}
	
	//Called from ClientProxy Init() phase
	public static void registerSpecialRenderers()
	{
		regSR(Blocks.crystalBlock);
		
		bindTESR(TileEntityCrystal.class, new SpecialRendererCrystal());
	}
	
	/**
	 * Registers Block to GameResitry class
	 * @param block Block class
	 * @param name to identify Block
	 */
	private static void regBlock(Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
	}
	
	/**
	 * Registers TileEntity to GameRegistry class
	 * @param te TileEntity class
	 * @param name name to identify TileEntiy
	 */
	private static void regTE(Class te, String name)
	{
		GameRegistry.registerTileEntity(te, "stex_resomancy_" + name);
	}
	
	/**
	 * Registers Special Renderer to Block
	 * @param block Block that uses SpecialRenderer
	 */
	private static void regSR(Block block)
	{
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(ResomancyMod.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	
	/**
	 * Binds TileEntity to SpecialRenderer
	 * @param te TileEntity class
	 * @param sr SpecialRenderer instance
	 */
	private static void bindTESR(Class<? extends TileEntity> te, TileEntitySpecialRenderer<? super TileEntity> sr)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(te, sr);
	}
}
