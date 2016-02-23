package com.stex.resomancy.gui.researchpapers;

public enum EnumTopicTrigger
{
	/**
	 * Does nothing; used for independent topics or already triggered ones
	 */
	NONE,
	
	/**
	 * Closes the Research Pages GUI
	 */
	CLOSEGUI,
	
	/**
	 * Unlocks a new topic; target topic will still be locked if there are other parent topics locking it
	 */
	UNLOCKTOPIC,
	TOPIC,
	
	/**
	 * Unlocks a new page
	 */
	UNLOCKPAGE,
	PAGE;
}
