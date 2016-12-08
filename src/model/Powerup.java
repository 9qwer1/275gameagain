package model;

import java.awt.Color;
import java.util.Random;
/**
 * Powerup Model Object
 * <p>
 * Powerup inherits attributes from hazard. Unique attributes include:
 * <ul>
 * <li> Powerup powerupType - Enum describing which type of powerup it is
 * <li> Color color - Which color the powerup is (Color)
 * </ul>
 * @author Group 1
 *
 */
public class Powerup extends Hazard {
	PowerupType powerupType;
	Color color;
	/**
	 * Constructor
	 * @param xpos The x position of the powerup
	 * @param ypos The y position of the powerup
	 * @param xvel The x velocity of the powerup
	 * @param yvel The y velocity of the powerup
	 * @param spawntime The time the powerup will spawn on the screen
	 */
	public Powerup(int xpos, int ypos, int xvel, int yvel, int spawntime) {
		super(xpos, ypos, xvel, yvel, spawntime, MovementType.LEFT, "");
		this.setType(HazardType.POWERUP);
		Random r = new Random();
		switch (r.nextInt(3)) {
		case 0:
			this.powerupType = PowerupType.INVINCIBLE;
			color = color.YELLOW;
			imageType = "invincible";
			break;
		case 1:
			this.powerupType = PowerupType.CLEAR;
			color = color.ORANGE;
			imageType = "clear";
			break;
		case 2:
			this.powerupType = PowerupType.SPEED;
			color = color.RED;
			imageType = "speed";
			break;
		
		case 3:
			this.powerupType = PowerupType.ADDLIFE;
			color = color.WHITE;
			imageType = "addlife";
			break;
		}
	}
		/**
		 * Constructor
		 * @param xpos The x position of the powerup
		 * @param ypos The y position of the powerup
		 * @param xvel The x velocity of the powerup
		 * @param yvel The y velocity of the powerup
		 * @param spawntime The time the powerup will spawn on the screen
		 * @param powerupType Enum describing types of powerups
		 */
		public Powerup(int xpos, int ypos, int xvel, int yvel, int spawntime, PowerupType powerupType) {
			super(xpos, ypos, xvel, yvel, spawntime, MovementType.LEFT, "recycle");
			this.setType(HazardType.POWERUP);
			switch (powerupType) {
			case INVINCIBLE:
				color = color.YELLOW;
				this.setImageType("star");
				break;
			case CLEAR:
				color = color.ORANGE;
				this.setImageType("atom");
				break;
			case SPEED:
				color = color.RED;
				this.setImageType("speedup");
				break;
			case ADDLIFE:
				color = color.WHITE;
				this.setImageType("fullHeart");
			}
			this.powerupType = powerupType;
			
	}
	/**
	 * Returns powerupType attribute
	 * @return powerupType (PowerupType)
	 */
	public PowerupType getPowerupType() {
		return this.powerupType;
	}
	/**
	 * Returns color attribute
	 * @return color (Color of the powerup)
	 */
	public Color getColor() {
		return this.color;
	}
}