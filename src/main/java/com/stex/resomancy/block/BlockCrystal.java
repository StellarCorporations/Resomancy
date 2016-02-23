package com.stex.resomancy.block;

import com.stex.resomancy.block.tileentity.TileEntityCrystal;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockCrystal extends BlockContainer
{

	protected BlockCrystal(String unlocalizedName)
	{
        super(Material.iron);
        this.setUnlocalizedName(unlocalizedName);
        this.setHardness(2.0f);
        this.setResistance(6.0f);
        this.setHarvestLevel("pickaxe", 2);

	}
	
	@Override
	public boolean isOpaqueCube() {
	    return false;
	}

	@Override
	public int getRenderType() {
	    return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityCrystal();
	}
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
}