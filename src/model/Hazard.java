package model;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
/**
 * Hazard object
 * <p>
 * Hazard is a subclass of Movers.  It has the following attributes:
 * <ul>
 * <li> int xpos - The X position of the enemy
 * <li> int ypos - The Y position of the enemy
 * <li> int xvel - The X velocity of the enemy
 * <li> int yvel - The Y velocity of the enemy
 * <li> int spawntime - The time the enemy spawns on the screen
 * <li> MovementType movementType - The type of movement the enemy takes on
 * <li> String imageType - The image this hazard takes on
 * </ul>
 * 
 * @author Group 1
 * @see Movers
 */
public class Hazard extends Movers {
	int spawntime;
	String imageType;
	HazardType type;
	MovementType movementType;
	int playery;
	int SCREENHEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	/**
	  * Constructor.
	  * 
	  * @param xpos The X position of the enemy
	  * @param ypos The Y position of the enemy
	  * @param xvel The X velocity of the enemy
      * @param yvel The Y velocity of the enemy
      * @param spawntime The time the enemy spawns on the screen
      * @param hazardMovementType The type of movement the enemy takes on
	  * @param imageType - The image this hazard takes on (String)
	  */
	public Hazard(int xpos, int ypos, int xvel, int yvel, int spawntime, MovementType hazardMovementType, String imageType) {
		super(xpos, ypos, xvel, yvel, imageType);
		this.spawntime = spawntime;
		this.movementType = hazardMovementType;
		color = Color.BLACK;
	}
	
	/**
	  * Constructor.
	  * 
	  * @param xpos The X position of the enemy
	  * @param ypos The Y position of the enemy
	  * @param xvel The X velocity of the enemy
     * @param yvel The Y velocity of the enemy
     * @param spawntime The time the enemy spawns on the screen
     * @param hazardMovementType The type of movement the enemy takes on
	  * @param imageType - The image this hazard takes on (String)
	  * @param int playery The y position of the player
	  */
	public Hazard(int xpos, int ypos, int xvel, int yvel, int spawntime, MovementType hazardMovementType, String imageType, int playery) {
		super(xpos, ypos, xvel, yvel, imageType);
		this.spawntime = spawntime;
		this.movementType = hazardMovementType;
		color = Color.BLACK;
	}
	
	/**
	  * Constructor.
	  * 
	  * @param xpos The X position of the enemy
	  * @param ypos The Y position of the enemy
	  * @param xvel The X velocity of the enemy
     * @param yvel The Y velocity of the enemy
     * @param spawntime The time the enemy spawns on the screen
     * @param hazardMovementType The type of movement the enemy takes on
     * @param SCREENHEIGHT The height of the screen
	  * @param imageType - The image this hazard takes on (String)
	  */
	public Hazard(int xpos, int ypos, int xvel, int yvel, int spawntime, MovementType hazardMovementType, int SCREENHEIGHT, String imageType) {
		super(xpos, ypos, xvel, yvel, imageType);
		this.SCREENHEIGHT = SCREENHEIGHT;
		this.spawntime = spawntime;
		this.movementType = hazardMovementType;
		color = Color.BLACK;
	}
	
	/** Return spawntime passed to the constructor.  */
	public int getSpawntime() {
		return spawntime;
	}
	/**
	 * Returns a 40x40 rectangle at the location passed to the constructor
	 * @see Rectangle
	 */
	public Rectangle getBounds() {
		Rectangle r = new Rectangle(xpos, ypos, 40, 40);
		return r;
	}
	/** Sets spawntime attribute.  */
	public void setSpawntime(int spawntime) {
		this.spawntime = spawntime;
	}
	/** Return HazardType passed to the constructor.  */
	public HazardType getType() {
		return this.type;
	}
	/** Sets HazardType attribute.
	 * @param hazardType
	 * @see HazardType  */
	public void setType(HazardType hazardType) {
		this.type = hazardType;
	}

	/**
	 * This method moves this hazard depending on it's movementType attribute.
	 * 
	 */
	public void move() {
		switch (movementType) {
		case ENEMYMOVE:
			this.xpos = xpos - xvel;
			double y = Math.sin(xpos / 20) * (-(SCREENHEIGHT/30));
			this.ypos = ((int) y) + ypos;
			break;
		case LEFT:
			this.xpos = xpos - xvel;
			break;
		case COLLIDEDUP:
			this.xpos = xpos + 5;
			this.ypos = ypos - 1;
			break;
		case COLLIDEDDOWN:
			this.xpos = xpos + 5;
			this.ypos = ypos + 1;
			break;
		case RIGHT:
			this.xpos = xpos + xvel;
			break;
		case ENEMY2MOVE:
			this.xpos = xpos - xvel;
			if(ypos <= 1 || ypos >= SCREENHEIGHT-1)
				yvel = yvel*(-1);
			this.ypos = ypos + yvel;
			break;
		case ENEMY3MOVE:
			this.xpos = xpos - xvel;
			if(ypos<playery)
				ypos+=3;
			if(ypos>playery)
				ypos-=3;
			break;
		}
	}
	/** Return x position passed to the constructor.  */
	public int getxpos() {
		return xpos;
	}
	/** Sets x position attribute.  */
	public void setxpos(int xpos) {
		this.xpos = xpos;
		super.setXpos(xpos);
	}
	/** Return y position passed to the constructor.  */
	public int getypos() {
		return ypos;
	}
	/** Sets y position attribute.  */
	public void setypos(int ypos) {
		this.ypos = ypos;
		super.setYpos(ypos);
	}
	/** Return x velocity passed to the constructor.  */
	public int getxvel() {
		return xvel;
	}
	/** Sets x velocity attribute.  */
	public void setxvel(int xvel) {
		this.xvel = xvel;
	}
	/** Return y velocity passed to the constructor.  */
	public int getyvel() {
		return yvel;
	}
	/** Sets y velocity attribute.  */
	public void setyvel(int yvel) {
		this.yvel = yvel;
	}

	/**
	 * Increase the xvel of the hazard by the specified integer increment.
	 * 
	 * @param increment
	 *            the amount the velocity is increased
	 */
	public void increasexvel(int increment) {
		xvel = xvel + increment;
	}
	/** Return MovementType passed to the constructor.  */
	public MovementType getMovementType() {
		return this.movementType;
	}
	/** Sets MovementType attribute.
	 * @param newMovementType
     */
	public void setMovementType(MovementType newMovementType) {
		this.movementType = newMovementType;
	}
	/** Return null  */
	public PowerupType getPowerupType() {
		// TODO Auto-generated method stub
		return null;
	}
	/** Return null  */
	public Object getToolType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPlayerY(int playery) {
		this.playery = playery;
		System.out.println(playery);
		
	}

}
