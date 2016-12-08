package model;

import java.util.*;

/**
 * Board is the array in which the characters and objects are placed. Attributes
 * include:
 * <ul>
 * <li> int[][] arr The array that will represent the board
 * <li> int BOARDHEIGHT - The default height of the board
 * <li> int BOARDWIDTH - The default width of the board
 * <li> int limit - tool used to set fresh water and salt water zones
 * </ul>
 * 
 * @author Group 1
 */
public class Board {
	int[][] arr;
	int BOARDHEIGHT = 20;
	int limit;
	final int BOARDWIDTH = 40;

	/**
	 * This is a constructor for the Board class.
	 * <p>
	 * It creates a 2d array based on the boardheight and boardwidth.
	 * It initializes the values in the array to a series of 1's and -1's.
	 */
	public Board() {
		int border = -5;
		int changer = 1;
		limit = BOARDHEIGHT - (BOARDHEIGHT / 3);
		arr = new int[BOARDWIDTH][BOARDHEIGHT];
		for (int i = 0; i < BOARDWIDTH; i++) {
			border += changer;
			for (int j = 0; j < BOARDHEIGHT; j++) {
				if (j > limit) {
					arr[i][j] = 1;
				} else {
					if (i < BOARDWIDTH / 2) {

						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}
					} else {
						changer = -1;
						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}

					}
				}

			}

		}
	}

	/**
	 * This method returns a part of the array given a coordinate
	 * 
	 * @param x
	 *            the x coordinate of the specified tile
	 * @param y
	 *            The y coordinate of the specified tile
	 * @return String the specified file.
	 */
	public int getTile(int x, int y) {
		return arr[x][y];

	}
	/**
	 * This method simulates south wind on the game board.
	 * <p>
	 * This method rearranges the 2d array so that it pushes
	 * the "Fresh water" down.
	 */
	public void southWind() {
		int border = -4;
		int changer = 1;
		if(limit!=((BOARDHEIGHT / 2)-(BOARDHEIGHT/6)))
			limit+=1;
		arr = new int[BOARDWIDTH][BOARDHEIGHT];
		for (int i = 0; i < BOARDWIDTH; i++) {
			border += changer;
			for (int j = 0; j < BOARDHEIGHT; j++) {
				if (j > limit) {
					arr[i][j] = 1;
				} else {
					if (i < BOARDWIDTH / 2) {

						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}
					} else {
						changer = -1;
						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}
					}
				}
			}
		}
	}
	/**
	 * This method simulates north wind on the game board.
	 * <p>
	 * This method rearranges the 2d array so that it pushes
	 * the "Salt water" up.
	 */
	public void northWind() {
		int border = -6;
		int changer = 1;
		if(limit!=(BOARDHEIGHT / 6))
			limit-=1;
		arr = new int[BOARDWIDTH][BOARDHEIGHT];
		for (int i = 0; i < BOARDWIDTH; i++) {
			border += changer;
			for (int j = 0; j < BOARDHEIGHT; j++) {
				if (j > limit) {
					arr[i][j] = 1;
				} else {
					if (i < BOARDWIDTH / 2) {

						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}

						// System.out.println(j);
					} else {
						changer = -1;
						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}

					}
				}

			}

		}
	}
	
	/**
	 * This method simulates no wind on the game board.
	 * <p>
	 * This method rearranges the 2d array so that it pushes
	 * the "Salt water" back to a neutral position.
	 */
	public void neutralWind() {
		int border = -5;
		int changer = 1;
		if(limit>BOARDHEIGHT-(BOARDHEIGHT / 3))
			limit-=1;
		if(limit<BOARDHEIGHT-(BOARDHEIGHT / 3))
			limit+=1;
		arr = new int[BOARDWIDTH][BOARDHEIGHT];
		for (int i = 0; i < BOARDWIDTH; i++) {
			border += changer;
			for (int j = 0; j < BOARDHEIGHT; j++) {
				if (j > limit) {
					arr[i][j] = 1;
				} else {
					if (i < BOARDWIDTH / 2) {

						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}

						// System.out.println(j);
					} else {
						changer = -1;
						if (border < j) {
							arr[i][j] = 1;
						} else {
							arr[i][j] = -1;
						}

					}
				}

			}

		}
	}
	/**
	 * This method is a getter for the 2d array
	 * <p>
	 * Returns the 2d array "arr"
	 * @return     int[][] 
	 * 
	 */
	public int[][] getArr() {
		return arr;
	}
	/**
	 * This method is a setter for the 2d array
	 * <p>
	 * @param arr The array you would like to set as the board's "arr" property (int[][])
	 * 
	 */
	public void setArr(int[][] arr) {
		this.arr = arr;
	}
}