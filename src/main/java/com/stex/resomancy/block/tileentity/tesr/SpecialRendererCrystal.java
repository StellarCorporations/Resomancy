package com.stex.resomancy.block.tileentity.tesr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.vecmath.Vector3d;

import org.lwjgl.opengl.GL11;

import com.sun.istack.internal.logging.Logger;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.tileentity.TileEntity;
import scala.Console;

public class SpecialRendererCrystal extends TileEntitySpecialRenderer
{

	//CrystalConstruct
	
	//OriginPoint
	public float origPointX, origPointZ;
	public List<float[]> origPoints;
	public float[] shiftRange = {-0.16f, 0.16f};
	
	public float[] sectionRange = {0.2f, 0.3f}; 
	
	public float[] distRange = {0.13f, 0.23f};
	
	public int sides = 3;
	
	List<Vector3d> verts = new ArrayList<Vector3d>();
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		Console.println("("+(x)+", "+(y)+", "+(z)+")");
		//Generate vertices for processing 
		int SECTIONS = 0;
		if(verts.size() == 0)
		{
			ThreadLocalRandom rand = ThreadLocalRandom.current();
			
			
			float height = 0f;
			
			while(height < 0.9f)
			{
				SECTIONS += 1;
				
				float startingAngle = rand.nextFloat() * 360;
				float jumpAngle =  -(360 / sides);
				
				origPointX = 0.5f + (float) rand.nextDouble(shiftRange[0], shiftRange[1]);
				origPointZ = 0.5f + (float) rand.nextDouble(shiftRange[0], shiftRange[1]);
				
				for(int i = 0; i < sides; ++i)
				{
					verts.add(new Vector3d((Math.cos(startingAngle) * rand.nextDouble(distRange[0], distRange[1])) + origPointX, height, (Math.sin(startingAngle) * rand.nextDouble(distRange[0], distRange[1])) + origPointZ));
					startingAngle += jumpAngle;
				}
				
				height += rand.nextDouble(sectionRange[0], sectionRange[1]);
			}
			
			//Console.println("[START VERT PRINT]");
			//for(Vector3d vert : verts)
			//{
				//Console.println("("+(x+vert.x)+", "+(y+vert.y)+", "+(z+vert.z)+")");
			//}
			//Console.println("[END VERT PRINT]");
		}
		

		
		//Render with GL11
		Tessellator tessellator = Tessellator.getInstance();
		GlStateManager.pushMatrix();
	    GlStateManager.translate(x, y, z);
	    GlStateManager.enableAlpha();
	    GlStateManager.enableBlend();
	    GlStateManager.color(1f, 0f, 0.26f, 0.5f);

	    for(int i = 0; i < SECTIONS - 1; ++i)
	    {
	    	for(int j = 0; j < sides-1; ++j)
	    	{
	    		GL11.glBegin(GL11.GL_QUADS);
	    		//tessellator.getWorldRenderer().startDrawingQuads();
	    		//GL11.glNormal3f(nx, ny, nz);
	    		
	    		Vector3d vert0 = verts.get(j + (i*3));
	    		GL11.glVertex3d(vert0.x, vert0.y, vert0.z);
	    		
	    		Vector3d vert1 = verts.get(j + (i*3) + 1);
	    		GL11.glVertex3d(vert1.x, vert1.y, vert1.z);
	    		
	    		Vector3d vert2 = verts.get(j + (i*sides + sides) + 1);
	    		GL11.glVertex3d(vert2.x, vert2.y, vert2.z);
	    		
	    		Vector3d vert3 = verts.get(j + (i*sides + sides));
	    		GL11.glVertex3d(vert3.x, vert3.y, vert3.z);
	    		
	    		GL11.glEnd();
	    	}
	    	
	    	GL11.glBegin(GL11.GL_QUADS);
    		//GL11.glNormal3f(nx, ny, nz);
    		
    		Vector3d vert0 = verts.get(2 + (i*3));
    		GL11.glVertex3d(vert0.x, vert0.y, vert0.z);
    		
    		Vector3d vert1 = verts.get(0 + (i*3) + 1);
    		GL11.glVertex3d(vert1.x, vert1.y, vert1.z);
    		
    		Vector3d vert2 = verts.get(0 + (i*sides + sides) + 1);
    		GL11.glVertex3d(vert2.x, vert2.y, vert2.z);
    		
    		Vector3d vert3 = verts.get(2 + (i*sides + sides));
    		GL11.glVertex3d(vert3.x, vert3.y, vert3.z);
    		
    		GL11.glEnd();
	    }

	    GlStateManager.disableAlpha();
	    GlStateManager.disableBlend();
	    GlStateManager.popMatrix();
	}

}
