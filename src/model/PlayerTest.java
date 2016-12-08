package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testGetSaltDelta() {
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		assertEquals(p.getSaldelta(),20);
	}
	
	@Test
	public void testSetSaltDelta() {
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.setSaldelta(30);
		assertEquals(p.getSaldelta(),30);
	}

	@Test
	public void testGetXPos() {
		Player p = new Player(10,10, 0, 0, 0, 20, 0, 0, null, null);
		assertEquals(p.getXpos(),10);
	}
	
	@Test
	public void testSetXPos() {
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.setXpos(30);
		assertEquals(p.getXpos(),30);
	}
	
	@Test
	public void testGetYPos() {
		Player p = new Player(10,10, 0, 0, 0, 20, 0, 0, null, null);
		assertEquals(p.getYpos(),10);
	}
	
	@Test
	public void testSetYPos() {
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.setYpos(10);
		assertEquals(p.getYpos(),10);
	}
	
	@Test
	public void testSetLife(){
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.setLife(7);
		assertEquals(p.getLife(),7);
	}
	
	@Test
	public void testGetLife(){
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		assertEquals(p.getLife(),3);
	}
	
	@Test
	public void testLoseLife(){
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.loseLife();
		assertEquals(p.getLife(),2);
	}
	
	@Test
	public void testGetYvel(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 0, 0, null, null);
		assertEquals(p.getYvel(),1);
	}
	
	@Test
	public void testGetXvel(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 0, 0, null, null);
		assertEquals(p.getXvel(),1);
	}
	
	@Test
	public void testSetYvel(){
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.setYvel(100);
		assertEquals(p.getYvel(),100);
	}
	
	@Test
	public void testSetXvel(){
		Player p = new Player(0, 0, 0, 0, 0, 20, 0, 0, null, null);
		p.setXvel(100);
		assertEquals(p.getXvel(),100);
	}
	
	@Test
	public void testGetSalinity(){
		Player p = new Player(0, 0, 1, 1, 10, 20, 0, 0, null, null);
		assertEquals(p.getSalinity(),10);
	}
	
	@Test
	public void testSetSalinity(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 0, 0, null, null);
		p.setSalinity(30);
		assertEquals(p.getSalinity(),30);
	}
	
	@Test
	public void testGetSalMax(){
		Player p = new Player(0, 0, 1, 1, 10, 20, 0, 100, null, null);
		assertEquals(p.getSalmax(),100);
	}
	
	@Test
	public void testSetSalMax(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 0, 0, null, null);
		p.setSalmax(30);
		assertEquals(p.getSalmax(),30);
	}
	
	@Test
	public void testGetSalMin(){
		Player p = new Player(0, 0, 1, 1, 10, 20, 20, 100, null, null);
		assertEquals(p.getSalmin(),20);
	}
	
	@Test
	public void testSetSalMin(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 20, 100, null, null);
		p.setSalmin(30);
		assertEquals(p.getSalmin(),30);
	}
	
	@Test
	public void testSpeedUp(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 20, 100, null, null);
		p.SpeedUp();
		assertEquals(p.getXvel(),20);
		assertEquals(p.getYvel(),20);
		assertEquals(p.getState(),State.SPEEDUP);
	}
	
	@Test
	public void testSwitchTool(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 20, 100, Tool.COMPOST, State.NEUTRAL);
		p.SwitchTool();
		assertEquals(p.getTool(),Tool.TRASH);
	}
	
	@Test
	public void testInvincibility(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 20, 100, null, State.NEUTRAL);
		p.Invincibility();
		assertEquals(p.getState(),State.INVINCIBLE);
	}
	
	@Test
	public void testIsSalOver(){
		Player p = new Player(0, 0, 1, 1, 110, 20, 20, 100, null, null);
		assertTrue(p.isSalOver());
		p.setSalinity(90);
		assertFalse(p.isSalOver());
	}
	
	@Test
	public void testIsSalUnder(){
		Player p = new Player(0, 0, 1, 1, 10, 20, 20, 100, null, null);
		assertTrue(p.isSalUnder());
		p.setSalinity(30);
		assertFalse(p.isSalUnder());
	}
	
	@Test
	public void testSetState(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 20, 100, null, null);
		p.setState(State.NEUTRAL);
		assertEquals(p.getState(),State.NEUTRAL);
	}
	
	@Test
	public void testGetState(){
		Player p = new Player(0, 0, 1, 1, 0, 20, 20, 100, null, State.JUSTHIT);
		assertEquals(p.getState(),State.JUSTHIT);
	}
	
	
}
