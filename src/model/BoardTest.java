package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testGetTile() {
		Board board1 = new Board();
		assertEquals(board1.getTile(0, 0), 1);
	}
	
	@Test
	public void testSouthWind(){
		Board board1 = new Board();
		assertEquals(board1.getTile(20, 15), 1);
		board1.southWind();
		assertEquals(board1.getTile(20, 15), -1);
	}
	@Test
	public void testNorthWind(){
		Board board1 = new Board();
		assertEquals(board1.getTile(20, 14), -1);
		board1.northWind();
		assertEquals(board1.getTile(20, 14), 1);
	}
	@Test
	public void testGetArr(){
		Board board1 = new Board();
		assertEquals(board1.getArr(), board1.arr);
	}
	@Test
	public void testSetArr(){
		Board board1 = new Board();
		int[][] newarr = new int[40][20];
		assertEquals(board1.getTile(20, 15), 1);
		board1.setArr(newarr);
		assertEquals(board1.getTile(20, 15), 0);
	}
	

}
