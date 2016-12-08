package model;

import java.awt.Rectangle;
import java.lang.Math;
/**
 * Enemy1 Model Object
 * <p>
 * Enemy1 represents the Catfish. Enemy1's attributes are the same as all hazards
 * 
 * @author Group 1
 * @see Hazard
 */
public class Enemy1 extends Hazard {
	/**
	 * Constructor
	 * @param xpos X position of hazard
	 * @param ypos Y position of hazard
	 * @param xvel X velocity of hazard
	 * @param yvel Y velocity of hazard
	 * @param spawntime integer representing when the enemy will spawn.
	 */
	public Enemy1(int xpos, int ypos, int xvel, int yvel, int SCREENHEIGHT, int spawntime) {
		super(xpos, ypos, xvel, yvel, spawntime, MovementType.ENEMYMOVE, SCREENHEIGHT, "catfish");
		this.setType(HazardType.ENEMY1);
	}
	
	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle(xpos, ypos, 80, 40);
		return r;
	}
}