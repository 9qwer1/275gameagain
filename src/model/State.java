package model;
/**
 * State Model Enum
 * <p>
 * State describes the state of your player currently
 * @author Group 1
 *
 */
public enum State {
	/**
	 * Neutral means player is in its default state
	 */
	NEUTRAL, 
	/**
	 * Invinsible means player is invinsible
	 */
	INVINCIBLE, 
	/**
	 * Speedup means player has superspeed
	 */
	SPEEDUP, 
	/**
	 * Justhit means player was just hit.
	 */
	JUSTHIT
}
