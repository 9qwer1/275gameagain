package model;

import java.awt.Color;
/**
 * Trash Model Object
 * <p>
 * Trash object represents trash hazard. Unique attributes include:
 * <ul>
 * <li> Tool type - The type of tool to use to pick up the trash
 * <li> Color color - The color of the trash
 * </ul>
 * @author Group 1
 *
 */
public class Trash extends Hazard {
	Tool type;
	Color color;
	/**
	 * Constructor
	 * @param xpos The x position of the trash
	 * @param ypos The y position of the trash
	 * @param xvel the x velocity of the trash
	 * @param yvel The y velocity of the trash
	 * @param spawntime When the trash will spawn on the screen
	 * @param type The type of tool to use
	 */
	public Trash(int xpos, int ypos, int xvel, int yvel, int spawntime, Tool type) {
		super(xpos, ypos, xvel, yvel, spawntime, MovementType.LEFT, "");
		this.setType(HazardType.TRASH);
		this.type = type;
		switch (type) {
		case TRASH:
			this.color = color.LIGHT_GRAY;
			this.setImageType("trashbag");
			break;

		case RECYCLE:
			this.color = color.DARK_GRAY;
			this.setImageType("soda");
			break;

		case COMPOST:
			this.color = color.GREEN;
			this.setImageType("banana");
			break;
		}
	}
	/**
	 * Returns the tool type attribute
	 * @return type (The Tool)
	 */
	public Tool getToolType() {
		return type;
	}
	/**
	 * Sets the tool type to a given type (Tool)
	 * @param type (Tool)
	 */
	public void setType(Tool type) {
		this.type = type;
	}

	/**
	 * Returns color attribute
	 * @return color (Color)
	 */
	@Override
	public Color getColor() {
		return this.color;
	}

}
