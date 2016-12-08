package model;

import java.awt.Rectangle;
/**
 * Player Model Object
 * <p>
 * The Player class represents the character the user controls.  It has attributes:
 * <ul>
 * <li> int salinity - The salinity of the player
 * <li> int salmin - The minimum salinity the player can tolerate
 * <li> int salmax - The maximum salinity the player can tolerate
 * <li> int saldelta - How fast the salinity moves
 * <li> Tool tool - The tool the player is carrying
 * <li> int life - how many lives the player has
 * <li> State state - What state the player is in at the moment
 * </ul>
 * @author Group 1
 *
 */
public class Player extends Movers {
	int salinity;
	int salmin;
	int salmax;
	int saldelta;
	Tool tool;
	int life;
	State state;
	/**
	 * Constructor
	 * @param xpos X position of the player
	 * @param ypos Y position of the player
	 * @param xvel X velocity of the player
	 * @param yvel Y Velocity of the player
	 * @param salinity The salinity level of the player
	 * @param saldelta How fast the salinity moves
	 * @param salmin The minimum salinity the player can tolerate
	 * @param salmax The maximum salinity the player can tolerate
	 * @param tool - The kind of tool the player is using
	 * @param state - The state of the player at this moment
	 */
	public Player(int xpos, int ypos, int xvel, int yvel, int salinity, int saldelta, int salmin, int salmax, Tool tool,
			State state) {
		super(xpos, ypos, xvel, yvel, "bluecrab_0");
		this.salinity = salinity;
		this.saldelta = saldelta;
		this.salmin = salmin;
		this.salmax = salmax;
		this.tool = tool;
		this.state = state;
		this.life = 3;
	}
	/**
	 * Constructor
	 * @param xpos X position of the player
	 * @param ypos Y position of the player
	 * @param xvel X velocity of the player
	 * @param yvel Y Velocity of the player
	 * @param salinity The salinity level of the player
	 * @param saldelta How fast the salinity moves
	 * @param salmin The minimum salinity the player can tolerate
	 * @param salmax The maximum salinity the player can tolerate
	 * @param tool - The kind of tool the player is using
	 * @param state - The state of the player at this moment
	 * @param imageName - The name of the image of the player (String)
	 */
	public Player(int xpos, int ypos, int xvel, int yvel, int salinity, int saldelta, int salmin, int salmax, Tool tool,
			State state, String imageName) {
		super(xpos, ypos, xvel, yvel, imageName);
		this.salinity = salinity;
		this.saldelta = saldelta;
		this.salmin = salmin;
		this.salmax = salmax;
		this.tool = tool;
		this.state = state;
		this.life = 3;
	}
	/**
	 * Returns the salDelta attribute passed to the constructor
	 * @return salDelta
	 */
	public int getSaldelta() {
		return saldelta;
	}
	/**
	 * Sets salDelta attribute to a given salDelta (int)
	 * @param saldelta
	 */
	public void setSaldelta(int saldelta) {
		this.saldelta = saldelta;
	}
	/** Returns the x position passed into the constructor
	 * @return xpos
	 */
	public int getXpos() {
		return xpos;
	}
	/**
	 * Sets x position of player to given xpos (int)
	 * @param xpos
	 */
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	/**
	 * Returns a rectangle with same xpos and ypos as player, with dimensions 50x50
	 * @return Rectangle Rectangle with x and y positions corresponding with xpos and ypos
	 */
	public Rectangle getBounds() {
		return new Rectangle(xpos, ypos, 50, 50);
	}
	/** Returns y position of player
	 * @return ypos
	 */
	public int getYpos() {
		return ypos;
	}
	/**
	 * Returns true if salinity is greater than salmax, false otherwise
	 * @return boolean
	 */
	public boolean isSalOver() {
		return salinity > salmax;
	}
	/**
	 * Returns true if salinity is less than salin, false otherwise
	 * @return boolean
	 */
	public boolean isSalUnder() {
		return salinity < salmin;
	}
	/**
	 * This method subtracts one from the player's life
	 */
	public void loseLife() {
		life -= 1;
	}
	/**
	 * This method sets the Y position of the player to the given ypos
	 * @param ypos Y position (int)
	 */
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	/** Returns the x velocity that is passed to the constructor
	 * @return xvel
	 */
	public int getXvel() {
		return xvel;
	}
	/** Sets xvel attribute to given xvel
	 * @param xvel (int)
	 */
	public void setXvel(int xvel) {
		this.xvel = xvel;
	}
	/** Returns y velocity passed to the constructor
	 * @return yvel
	 */
	public int getYvel() {
		return yvel;
	}
	/** Sets yvel attribute to given yvel
	 * @param yvel (int)
	 */
	public void setYvel(int yvel) {
		this.yvel = yvel;
	}
	/**
	 * Returns salinity level passed into constructor
	 * @return salinity
	 */
	public int getSalinity() {
		return salinity;
	}
	/** Sets salinity attribute to given salinity
	 * @param salinity (int)
	 */
	public void setSalinity(int salinity) {
		this.salinity = salinity;
	}
	/**
	 * Returns salmin level passed into constructor
	 * @return salmin (int)
	 */
	public int getSalmin() {
		return salmin;
	}
	/** Sets salmin attribute to given salmin
	 * @param salmin (int)
	 */
	public void setSalmin(int salmin) {
		this.salmin = salmin;
	}
	/**
	 * Returns salmax level passed into constructor
	 * @return salmax (int)
	 */
	public int getSalmax() {
		return salmax;
	}
	/** Sets salmax attribute to given salmax
	 * @param salmax (int)
	 */
	public void setSalmax(int salmax) {
		this.salmax = salmax;
	}
	/**
	 * Returns tool passed into constructor
	 * @return tool (Tool)
	 * @see Tool
	 */
	public Tool getTool() {
		return tool;
	}
	/** Sets tool attribute to given tool
	 * @param tool (Tool)
	 * @see Tool
	 */
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	/**
	 * Returns life passed into constructor
	 * @return life (int)
	 */
	public int getLife() {
		return life;
	}
	/** Sets life attribute to given tool
	 * @param life (int)
	 */
	public void setLife(int life) {
		this.life = life;
	}
	/**
	 * Returns state passed into constructor
	 * @return state (State)
	 * @see State
	 */
	public State getState() {
		return state;
	}
	/** Sets state attribute to given state
	 * @param state (State)
	 * @see State
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * This method updates the Salinity of the player
	 * <p>
	 * Saldelta is added to the salinity to make the new salinity.
	 */
	public void updateSalinity() {
		salinity += saldelta;
	}

	/**
	 * Subtracts 1 from Life. if Life is 0 do not subtract.
	 */
	public void LoseLife() {
		state = State.JUSTHIT;
		if (life == 0) {
			return;
		} else {
			life -= 1;
		}
	}
	
	/**
	 * Adds 1 from Life. if Life is 5 do not add.
	 */
	public void gainLife() {
		if (life == 5) {
			return;
		} else {
			life += 1;
		}
	}

	/**
	 * changes the state of the player to invincible
	 */
	public void Invincibility() {
		state = State.INVINCIBLE;
	}

	/**
	 * changes state of the player to be in speedup mode.  Also sets xvel and yvel to 20.
	 */
	public void SpeedUp() {
		state = State.SPEEDUP;
		xvel = 20;
		yvel = 20;
	}

	/**
	 * changes the tool depending on what it is, will cycle
	 *         through it.
	 */
	public void SwitchTool() {
		switch (tool) {
		case TRASH:
			tool = Tool.RECYCLE;
			break;

		case RECYCLE:
			tool = Tool.TRASH;
			break;

		case COMPOST:
			tool = Tool.TRASH;
			break;
		}
	}

}
