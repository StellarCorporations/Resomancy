package com.stex.resomancy.gui.researchpapers;

import java.util.ArrayList;
import java.util.List;

import com.stex.resomancy.gui.GuiResearchPapers;

import net.minecraft.client.gui.GuiButton;

/**The ResearchPage class is designed to hold all rendering and button code 
 * 
 * @author Ion
 *
 */
public class ResearchPage
{
	/**
	 * Research Page's Name
	 */
	public String Name;
	
	/**
	 * Research Page's Button List
	 */
	public List<GuiButton> ButtonList = new ArrayList<GuiButton>();
	
	public ResearchPage(String name)
	{
		Name = name;
	}
	
	/**
	 * Adds a GuiButton to the ButtonList to be added to the main GUI
	 * @param button GuiButton to add to ButtonList
	 * @return Instance of this ResearchPage
	 */
	public ResearchPage addButton(GuiButton button)
	{
		ButtonList.add(button);
		return this;
	}
	
	
	public void initPage(GuiResearchPapers gui, List<GuiButton> buttonList)
	{
		buttonList.addAll(this.ButtonList);
	}
	
	public void drawPage(GuiResearchPapers gui, int mouseX, int mouseY, float partialTicks)
	{
		
	}
}
