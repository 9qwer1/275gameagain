package model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
/**
 * PossibleHazards Model Object
 * <p>
 * The PossibleHazards object represents all the of the hazards that attack the player on the screen.  PossibleHazards has attributes:
 * <ul>
 * <li> int hazard_num - The number of hazards in the level
 * <li> ArrayList hazards - The ArrayList containing all the hazards
 * </ul>
 * @author Group 1
 * @see Hazard
 */
public class PossibleHazards {
	int hazard_num;
	int playery = 0;
	ArrayList<Hazard> hazards;

	/**
	 * constructor for the possible hazards class which contains all of the
	 * possible hazards that can spawn in a given round
	 * @param hazard_num The number of hazards in a round
	 * 
	 */
	public PossibleHazards(int hazard_num) {
		this.hazard_num = hazard_num;
		this.hazards = new ArrayList<Hazard>();
	}
	/**
	 * This function returns if the given num is between the given lower and upper limits, inclusively
	 * @param num The number you want compared
	 * @param lower The lower limit you specify
	 * @param upper The upper limit you specify
	 * @return true if it is between inclusively, false otherwise
	 */
	public static boolean isBetweenInc(int num, int lower, int upper){
		return lower<=num&&num<=upper;
	}
	public void generateHazardsTutorial(Dimension screenSize) {
		System.out.print("This function got called");
		int spawnWindow = 500;
		int FRAMEHEIGHT = (int) screenSize.getHeight();
		int FRAMEWIDTH = (int) screenSize.getWidth();
		int spawnInt;
		int vel = FRAMEWIDTH/100;
		hazards.add(new Enemy2(FRAMEWIDTH, FRAMEHEIGHT/2+FRAMEHEIGHT/5, -5, 0, 25));
		hazards.get(0).setMovementType(MovementType.COLLIDEDDOWN);
		hazards.add(new Trash(FRAMEWIDTH, FRAMEHEIGHT/4, 5, 0, 300, Tool.TRASH));
		hazards.add(new Trash(FRAMEWIDTH, FRAMEHEIGHT/2, 5, 0, 600, Tool.RECYCLE));
		hazards.add(new Enemy1(FRAMEWIDTH, FRAMEHEIGHT/3, 5, 0, FRAMEHEIGHT, 900));
		hazards.add(new Enemy2(FRAMEWIDTH, FRAMEHEIGHT/2, 5, 3, 1200));
		hazards.add(new Enemy3(FRAMEWIDTH, FRAMEHEIGHT/2, 5, 0, 1500));		
		hazards.add(new Powerup(FRAMEWIDTH, FRAMEHEIGHT/2, 5, 0, 1800, PowerupType.ADDLIFE));
		hazards.add(new Powerup(FRAMEWIDTH, FRAMEHEIGHT/2 + FRAMEHEIGHT/4, 5, 0, 2100, PowerupType.SPEED));
		hazards.add(new Powerup(FRAMEWIDTH, FRAMEHEIGHT/2 - 15, 5, 0, 2400, PowerupType.CLEAR));
		hazards.add(new Powerup(FRAMEWIDTH, FRAMEHEIGHT/2 + 30, 5, 0, 2700, PowerupType.INVINCIBLE));
		hazards.add(new Enemy2(FRAMEWIDTH, FRAMEHEIGHT/2+FRAMEHEIGHT/5, -5, 0, 3000));		
		hazards.get(10).setMovementType(MovementType.COLLIDEDDOWN);
		hazards.add(new Enemy2(FRAMEWIDTH, FRAMEHEIGHT/2+FRAMEHEIGHT/5, -5, 0, 3300));
		hazards.get(11).setMovementType(MovementType.COLLIDEDDOWN);
		//System.out.print(hazards);
}
	/**
	 * This method generates hazards based on which level it is
	 * @param screenSize - The dimensions of the screen
	 * @param level - the level it is in the game
	 */
	public void generateHazards(Dimension screenSize, int level) {
		Random gen = new Random();
		int spawnwindow = 750;
		int FRAMEHEIGHT = (int) screenSize.getHeight();
		int FRAMEWIDTH = (int) screenSize.getWidth();
		int spawnInt;
		int speednum;
		int invinciblenum;
		int wipenum;
		int enemy1num;
		int enemy2num;
		int enemy3num;
		int lifenum;
		int vel = FRAMEWIDTH/300;
		switch(level){
		default: 
			hazard_num = 25;
			speednum = 3;
			lifenum = 3;
			//vel = FRAMEWIDTH/300;
			for (int i = 0; i < hazard_num; i++) {
				spawnInt = gen.nextInt(spawnwindow);
				//System.out.println("Spawn: " + spawnInt);
				int x = gen.nextInt(10);
				if(isBetweenInc(x, 0, 3))
					//hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 3, spawnInt));
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				else if(isBetweenInc(x, 4, 7))
					//hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, -3, spawnInt));
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				else if(x==8){
					if(speednum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, PowerupType.SPEED));
						speednum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				}
				else if(x==9){
					if(lifenum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.ADDLIFE));;
						lifenum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
					}
				}
			}
			break;
			
		case 2: 
			hazard_num = 35;
			speednum = 3;
			lifenum = 3;
			enemy1num = 5;
			for (int i = 0; i < hazard_num; i++) {
				//vel = FRAMEWIDTH/200;
				spawnInt = gen.nextInt(spawnwindow);
				int x = gen.nextInt(14);
				if(isBetweenInc(x, 0, 3))
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				else if(isBetweenInc(x, 4, 7))
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				else if(isBetweenInc(x, 8, 10))
					if(enemy1num > 0){
						hazards.add(new Enemy1(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, FRAMEHEIGHT, spawnInt));
						enemy1num--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
					}
				else if(x==11)
					if(speednum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, PowerupType.SPEED));
						speednum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				else if(isBetweenInc(x, 12, 13))
					if(lifenum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.ADDLIFE));;
						lifenum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				
			}
			break;
			
		case 3: 
			//vel = FRAMEWIDTH/150;
			spawnInt = gen.nextInt(spawnwindow);
			speednum = 3;
			lifenum = 3;
			invinciblenum = 1;
			wipenum = 1;
			enemy1num = 5;
			enemy2num = 5;
			hazard_num = 45;
			for (int i = 0; i < hazard_num; i++) {
				spawnInt = gen.nextInt(spawnwindow);
				System.out.println("Spawn: " + spawnInt);
				int x = gen.nextInt(19);
				if(isBetweenInc(x, 0, 3))
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				else if(isBetweenInc(x, 4, 6))
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				else if(isBetweenInc(x, 7, 10))
					if(enemy1num > 0){
						hazards.add(new Enemy1(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, FRAMEHEIGHT, spawnInt));
						enemy1num--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
					}
				else if(isBetweenInc(x, 11, 12))
					if(enemy2num > 0){
						hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 3, spawnInt));
						enemy2num--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				else if(isBetweenInc(x, 13, 14))
					if(enemy2num > 0){
						hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, -3, spawnInt));
						enemy2num--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				else if(x==15)
					if(lifenum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.ADDLIFE));;
						lifenum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				else if(x==16)
					if(speednum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, PowerupType.SPEED));
						speednum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
					}
				else if(x==17)
					if(invinciblenum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.INVINCIBLE));
						invinciblenum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
					}
				else if(x==18)
					if(wipenum > 0){
						hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.CLEAR));
						wipenum--;
					}else{
						hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
					}
			}
			break;
			
		
	case 4: 
		gen = new Random();
		spawnInt = gen.nextInt(spawnwindow);
		//vel = FRAMEWIDTH/125;
		speednum = 3;
		lifenum = 3;
		invinciblenum = 1;
		wipenum = 1;
		enemy1num = 7;
		enemy2num = 7;
		hazard_num = 60;
		for (int i = 0; i < hazard_num; i++) {
			spawnInt = gen.nextInt(spawnwindow);
			System.out.println("Spawn: " + spawnInt);
			int x = gen.nextInt(19);
			if(isBetweenInc(x, 0, 3))
				hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
			else if(isBetweenInc(x, 4, 6))
				hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
			else if(isBetweenInc(x, 7, 10))
				if(enemy1num > 0){
					hazards.add(new Enemy1(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, FRAMEHEIGHT, spawnInt));
					enemy1num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				}
			else if(isBetweenInc(x, 11, 12))
				if(enemy2num > 0){
					hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 3, spawnInt));
					enemy2num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(isBetweenInc(x, 13, 14))
				if(enemy2num > 0){
					hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, -3, spawnInt));
					enemy2num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(x==15)
				if(lifenum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.ADDLIFE));;
					lifenum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(x==16)
				if(speednum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, PowerupType.SPEED));
					speednum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				}
			else if(x==17)
				if(invinciblenum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.INVINCIBLE));
					invinciblenum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(x==18)
				if(wipenum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.CLEAR));
					wipenum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				}
		}
		break;
		
		
	case 5: 
		//vel = FRAMEWIDTH/100;
		spawnInt = gen.nextInt(spawnwindow);
		hazard_num = 80;
		speednum = 3;
		lifenum = 3;
		invinciblenum = 1;
		wipenum = 1;
		enemy1num = 7;
		enemy2num = 7;
		enemy3num = 3;
		for (int i = 0; i < hazard_num; i++) {
			spawnInt = gen.nextInt(spawnwindow);
			System.out.println("Spawn: " + spawnInt);
			int x = gen.nextInt(22);
			if(isBetweenInc(x, 0, 3))
				hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
			else if(isBetweenInc(x, 4, 6))
				hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
			else if(isBetweenInc(x, 7, 10))
				if(enemy1num > 0){
					hazards.add(new Enemy1(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, FRAMEHEIGHT, spawnInt));
					enemy1num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				}
			else if(isBetweenInc(x, 11, 12))
				if(enemy2num > 0){
					hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 3, spawnInt));
					enemy2num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(isBetweenInc(x, 13, 14))
				if(enemy2num > 0){
					hazards.add(new Enemy2(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, -3, spawnInt));
					enemy2num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(x==15)
				if(lifenum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.ADDLIFE));;
					lifenum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(x==16)
				if(speednum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, PowerupType.SPEED));
					speednum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				}
			else if(x==17)
				if(invinciblenum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.INVINCIBLE));
					invinciblenum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
			else if(x==18)
				if(wipenum > 0){
					hazards.add(new Powerup(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT)+1, vel, 0, spawnInt, PowerupType.CLEAR));
					wipenum--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.RECYCLE));
				}
			else if(isBetweenInc(x, 19, 21))
				if(enemy3num > 0){
					hazards.add(new Enemy3(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt));
					enemy3num--;
				}else{
					hazards.add(new Trash(FRAMEWIDTH, gen.nextInt(FRAMEHEIGHT) + 1, vel, 0, spawnInt, Tool.TRASH));
				}
		}
		break;
		
		}
	}
		
	

	/** Sets possibleHazards attribute to a given ArrayList of hazards
	 * @param hazards hazards are an array of all possible hazards Sets the array
	 *            containing all of the possible hazards
	 */

	public void setpossibleHazards(ArrayList<Hazard> hazards) {
		this.hazards = hazards;
	}

	/**
	 * Returns the hazards attribute of PossibleHazards object
	 * @return hazards The hazards attribute of this object
	 */
	public ArrayList<Hazard> getHazardsList() {
		return this.hazards;
	}
	/**
	 * This method moves all the hazards in the hazards attribute left
	 */
	public void moveLeft() {
		for (int i = 0; i < hazard_num; i++) {
			hazards.get(i).move();
		}
	}

	/** This method adds a given hazard to the ArrayList of hazards attribute
	 * @param hazard
	 *            an array of all possible hazards adds a single hazard to the
	 *            array
	 * 
	 */
	public void addHazard(Hazard hazard) {
		hazards.add(hazard);
	}

	/** This method removes the hazard from the hazards attribute at a given index.
	 * @param index
	 *            index is an int that represents the position we want in the
	 *            array Removes a hazard from the array at the given index
	 */
	public void removeHazard(int index) {
		hazards.remove(index);
	}

	/**
	 * select a random hazard in array
	 * @return Hazard
	 */
	public Hazard selectRandom() {
		Random gen = new Random();
		return hazards.get(gen.nextInt(hazards.size()));
	}
	
	public void updatePlayerY(int playery){
		System.out.println(playery);
		this.playery = playery;
	}

	/**
	 * This method clears all enemies and trash off the screen
	 * @param screenSize - Dimensions of screen size (Dimension)
	 * @see Dimension
	 */
	public void clearEnemies(Dimension screenSize) {
		ArrayList<Hazard> removeThese = new ArrayList<Hazard>();
		for (Hazard h : hazards) {
			if (h.getType().equals(HazardType.ENEMY1)) {
				if (h.getXpos() < (int) screenSize.getWidth()) {
					removeThese.add(h);
				}
			} else if (h.getType().equals(HazardType.ENEMY2)) {
				if (h.getXpos() < (int) screenSize.getWidth()) {
					removeThese.add(h);
				}
			} else if (h.getType().equals(HazardType.ENEMY3)) {
				if (h.getXpos() < (int) screenSize.getWidth()) {
					removeThese.add(h);
				}
			} else if (h.getType().equals(HazardType.TRASH)) {
				if (h.getXpos() < (int) screenSize.getWidth()) {
					removeThese.add(h);
				}
			}
		}
		for (Hazard h : removeThese) {
			hazards.remove(h);
		}
	}
}