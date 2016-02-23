package com.stex.resomancy.gui.researchpapers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stex.resomancy.gui.GuiResearchPapers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class ButtonTopic extends GuiButton
{
	/**
	 * Topic's Name
	 */
	public String Name;
	
	/**
	 * Topic's lock status 
	 */
	public boolean Locked;
	
	/**
	 * Object Triggered by Button's Type Methods
	 */
	public Object ITEM;
	
	
	/**
	 * What does this button do on trigger
	 */
	public EnumTopicTrigger TYPE = EnumTopicTrigger.NONE;
	
	/**
	 * This Topic's Children
	 */
	public List<ButtonTopic> Children = new ArrayList<ButtonTopic>();
	
	/**
	 * This Topic's Parents
	 */
	public Map<ButtonTopic, Boolean> Parents = new HashMap<ButtonTopic, Boolean>();
	
	/**
	 * 
	 * @param name
	 * @param buttonId
	 * @param x
	 * @param y
	 */
	public ButtonTopic(String name, int buttonId, int x, int y, boolean lock)
	{
		super(buttonId, x, y, null);
		Locked = lock;
	}
	
	/**
	 * Sets Topic to Unlock a Page
	 * @param page Page to unlock; also switches to that page
	 * @return Returns instance of itself
	 */
	public ButtonTopic setType_UNLOCKPAGE(ResearchPage page)
	{
		TYPE = EnumTopicTrigger.UNLOCKPAGE;
		ITEM = page;
		return this;
	}
	
	/**
	 * Sets Topic to Unlock a Topic
	 * @param topic Topic to unlock; also opens that topic
	 * @return Returns instance of itself
	 */
	public ButtonTopic setType_UNLOCKTOPIC(ResearchTopic topic)
	{
		TYPE = EnumTopicTrigger.UNLOCKTOPIC;
		ITEM = topic;
		return this;
	}
	
	/**
	 * Adds a Child ButtonTopic to the Children List
	 * @param child ButtonTopic to add
	 */
	public void addChild(ButtonTopic child)
	{
		Children.add(child);
	}
	public void addChildren(ButtonTopic[] children)
	{
		Children.addAll(Children);
	}
	
	/**
	 * Adds a Parent ButtonTopic to the Parents Map and sets it's lock status to true
	 * @param parent ButtonTopic to add
	 */
	public void addParent(ButtonTopic parent)
	{
		Parents.put(parent, true);
	}
	public void addParents(ButtonTopic[] parents)
	{
		for(ButtonTopic parent : parents)
		{
			Parents.put(parent, true);
		}
	}
	
	/**
	 * Adds a Parent ButtonTopic to the Parents Map and sets it's lock status
	 * @param parent ButtonTopic to add
	 * @param locked whether this ButtonTopic is locked 
	 */
	public void addParent(ButtonTopic parent, boolean locked)
	{
		Parents.put(parent, locked);
	}
	
	//Draws Button
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
        	
        }
    }
	
	/**
	 * Called externally as a trigger event
	 */
	public void trigger(GuiResearchPapers gui, EnumTopicTrigger trigger)
	{
		switch(trigger)
		{
		case PAGE:
			gui.Page = (ResearchPage)ITEM;
			break;
		case TOPIC:
			break;
		default:
			break;
		}
	}
	
	/**
	 * Used internally by ButtonTopic buttons
	 * <h1>
	 *  DO NOT CALL OUTSIDE OF A BUTTONTOPIC
	 *  </h1>
	 * @param topic ButtonTopic that called the internal trigger
	 * @return Returns whether this trigger unlocked the topic
	 */
	public boolean unlock(ButtonTopic topic)
	{
		Parents.put(topic, false);
		Collection<Boolean> array = Parents.values();
		boolean overallLocked = false;
		for(Boolean bool : array)
		{
			if(bool)
			{
				overallLocked = true;
				break;
			}
		}
		return !overallLocked;
	}

}
