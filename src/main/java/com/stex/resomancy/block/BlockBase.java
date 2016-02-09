package com.stex.resomancy.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block
{

	public BlockBase(String unlocalizedName, Material material, float hardness, float resistance)
	{
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        //TODO: Create custom creative tab
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BlockBase(String unlocalizedName, float hardness, float resistance)
    {
        this(unlocalizedName, Material.rock, hardness, resistance);
    }

    public BlockBase(String unlocalizedName)
    {
        this(unlocalizedName, 2.0f, 10.0f);
    }

}
