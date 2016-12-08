package model;
/**
 * MovementType is the type of movement that the hazard takes on.
 * @author Group 1
 *
 */
public enum MovementType {
	/**
	 * Move left
	 */
	LEFT, 
	/**
	 * Movement when collided with other object on north side
	 */
	COLLIDEDUP, 
	/**
	 * Movement when collided with other object on south side
	 */
	COLLIDEDDOWN, 
	/**
	 * Move right
	 */
	RIGHT, 
	/**
	 * Enemy moves
	 */
	ENEMYMOVE, 
	/**
	 * Enemy moves a second way
	 */
	ENEMY2MOVE,
	/**
	 * Enemy moves a third way
	 */
	ENEMY3MOVE
}
