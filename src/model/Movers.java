package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Movers Model Object
 * <p>
 * Movers class is superclass to everything that moves in the game. Attributes include:
 * <ul>
 * <li> int xpos - The x position of the mover.
 * <li> int ypos - the y position of the mover.
 * <li> int xvel - the x velocity of the mover.
 * <li> int yvel - the y velocity of the mover.
 * <li> String imageType - the name of the image corresponding to the mover.
 * <li> Color color - Which color the mover is
 * <li> BufferedImage image - The actual image of the mover.
 * </ul>
 * @author Group 1
 *
 */
public class Movers {
	int xpos;
	int ypos;
	int xvel;
	int yvel;
	String imageType;
	Color color;
	BufferedImage image;
	/**
	 * Constructor.
	 * 
	 * @param xpos The x position of the mover (int)
	 * @param ypos the y position of the mover (int)
	 * @param xvel the x velocity of the mover (int)
	 * @param yvel the y velocity of the mover (int)
	 * @param imageType the name of the image corresponding to the mover (String)
	 */
	Movers(int xpos, int ypos, int xvel, int yvel, String imageType) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.xvel = xvel;
		this.yvel = yvel;
		this.imageType = imageType+".png";
	}
	/** Return x position passed to constructor */
	public int getXpos() {
		return xpos;
	}
	/**
	 * Sets x position of mover.
	 * @param xpos The X position of the mover.
	 */
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	/**
	 * Returns the y position of the mover passed to the constructor.
	 */
	public int getYpos() {
		return ypos;
	}
	/**
	 * Sets y position of mover
	 * @param ypos The y position you want to move to be in.
	 */
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	/**
	 * Returns the x velocity passed to the constructor of the mover.
	 */
	public int getXvel() {
		return xvel;
	}
	/** Sets the x velocity of the mover 
	 * @param xvel The X velocity of the mover*/
	public void setXvel(int xvel) {
		this.xvel = xvel;
	}
	/** Returns the Y velocity of the mover.*/
	public int getYvel() {
		return yvel;
	}
	/** Sets the y velocity attribute to the given yvel 
	 * @param yvel The Y velocity of the mover*/
	public void setYvel(int yvel) {
		this.yvel = yvel;
	}
	/**Sets the color attribute to the given Color 
	 * @param color The color of the mover*/
	public void setColor(Color color) {
		this.color = color;
	}
	/** Returns the color attribute of this mover */
	public Color getColor() {
		return this.color;
	}
	/** Returns the ImageType passed into the constructor of this mover */
	public String getImageType() {
		return imageType;
	}
	/** Sets the ImageType of this mover to the given imageType (String)
	 * @param imageType The string name of the image*/
	public void setImageType(String imageType) {
		this.imageType = imageType+".png";
	}

	/** Returns the BufferedImage passed into the constructor of this mover */
	public BufferedImage getImage() {
		return image;
	}
	/** Sets the Image attribute of this mover to the given BufferedImage 
	 * @param image The BufferedImage to set to the Mover*/
	public void setImage(BufferedImage image) {
		this.image = image;
		
	}

	/**
	 * moveX updates the x position with the given velocity
	 * @param vel the velocity to move at.
	 */
	public void moveX(int vel) {
		xpos += vel;
	}

	/**
	 * moveY updates the Y position with the given velocity
	 * 
	 * @param vel an int that represents the velocity that you want the Y
	 *            position to move at

	 */
	public void moveY(int vel) {
		ypos += vel;
	}

}
