package model;

import java.awt.Rectangle;
import java.lang.Math;
/**
 * Enemy3 Model Object
 * <p>
 * Enemy3 represents the Trout. Enemy3's attributes are the same as all hazards
 * 
 * @author Group 1
 * @see Hazard
 */
public class Enemy3 extends Hazard {
	/**
	 * Constructor
	 * @param xpos X position of hazard
	 * @param ypos Y position of hazard
	 * @param xvel X velocity of hazard
	 * @param yvel Y velocity of hazard
	 * @param spawntime integer representing when the enemy will spawn.
	 */
	public Enemy3(int xpos, int ypos, int xvel, int yvel, int spawntime) {
		super(xpos, ypos, xvel, yvel, spawntime, MovementType.ENEMY3MOVE, "eel");
		this.setType(HazardType.ENEMY3);
	}
	
	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle(xpos, ypos, 80, 40);
		return r;
	}
}