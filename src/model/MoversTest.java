package model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class MoversTest {

	@Test
	public void testGetXPos() {
		Movers m = new Movers(32, 0, 0, 0, null);
		assertEquals(m.getXpos(), 32);
	}
	@Test
	public void testSetXPos(){
		Movers m = new Movers(32, 0, 0, 0, null);
		m.setXpos(50);
		assertEquals(m.getXpos(), 50);
	}
	@Test
	public void testGetYPos(){
		Movers m = new Movers(0, 14, 0, 0, null);
		assertEquals(m.getYpos(), 14);
	}
	@Test
	public void testSetYPos(){
		Movers m = new Movers(0, 0, 0, 0, null);
		m.setYpos(90);
		assertEquals(m.getYpos(), 90);
	}
	@Test
	public void testGetXVel(){
		Movers m = new Movers(0, 0, 30, 0, null);
		assertEquals(m.getXvel(), 30);
	}
	@Test
	public void testGetYVel(){
		Movers m = new Movers(0,0,0,50,null);
		assertEquals(m.getYvel(), 50);
	}
	@Test
	public void testSetXVel(){
		Movers m = new Movers(0, 0, 0, 0, null);
		m.setXvel(30);
		assertEquals(m.getXvel(), 30);
	}
	@Test
	public void testSetYVel(){
		Movers m = new Movers(0,0,0,0,null);
		m.setYvel(50);
		assertEquals(m.getYvel(), 50);
	}
	@Test
	public void testSetColor(){
		Movers m = new Movers(0, 0, 0, 0, null);
		m.setColor(Color.blue);
		assertEquals(m.getColor(), Color.blue);
	}
	

}
