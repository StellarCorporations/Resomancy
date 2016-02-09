package com.stex.resomancy.block.tileentity.tesr;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class SpecialRendererCrystal extends TileEntitySpecialRenderer
{

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		GlStateManager.pushMatrix();
	    GlStateManager.translate(x, y, z);

	    //Your rendering code goes here

	    GlStateManager.popMatrix();
	}

}
