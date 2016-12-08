package model;

import java.lang.Math;
/**
 * Enemy2 Model Object
 * <p>
 * Enemy2 represents the Pickerel. Enemy2's attributes are the same as all hazards
 * 
 * @author Group 1
 * @see Hazard
 */
public class Enemy2 extends Hazard {
	/**
	 * Constructor
	 * @param xpos X position of hazard
	 * @param ypos Y position of hazard
	 * @param xvel X velocity of hazard
	 * @param yvel Y velocity of hazard
	 * @param spawntime integer representing when the enemy will spawn.
	 */
	public Enemy2(int xpos, int ypos, int xvel, int yvel, int spawntime) {
		super(xpos, ypos, xvel, yvel, spawntime, MovementType.ENEMY2MOVE, "mittencrab");
		this.setType(HazardType.ENEMY2);
	}
}