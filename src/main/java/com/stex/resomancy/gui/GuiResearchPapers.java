package com.stex.resomancy.gui;

import java.io.IOException;

import com.stex.resomancy.gui.researchpapers.ButtonTopic;
import com.stex.resomancy.gui.researchpapers.EnumTopicTrigger;
import com.stex.resomancy.gui.researchpapers.ResearchPage;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

public class GuiResearchPapers extends GuiScreen
{
	/**
	 * Research Papers ItemStack
	 * */
	private ItemStack Papers;
	
	/**
	 * Current Page to be rendered
	 */
	public ResearchPage Page;
	
	public GuiResearchPapers(ItemStack is)
	{
		Papers = is;
	}
	
	public void initGui()
    {
		this.buttonList.clear();
		if(Page != null)
		{
			Page.initPage(this, this.buttonList);
		}
    }
	
	public void onGuiClosed()
    {
		
    }
	
	public void updateScreen()
    {
		
    }
	
	protected void actionPerformed(GuiButton button) throws IOException
    {
		ButtonTopic topic = (ButtonTopic)button;
		
		switch(topic.TYPE)
		{
		case NONE:
			break;
		case UNLOCKPAGE:
		case PAGE:
			topic.TYPE = EnumTopicTrigger.PAGE;
			topic.trigger(this, EnumTopicTrigger.PAGE);
			break;
		case UNLOCKTOPIC:
		case TOPIC:
			topic.TYPE = EnumTopicTrigger.TOPIC;
			topic.trigger(this, EnumTopicTrigger.TOPIC);
			break;
		default:
			break;
		}
    }
	
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
		this.drawDefaultBackground();
		Page.drawPage(this, mouseX, mouseY, partialTicks);
		super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
