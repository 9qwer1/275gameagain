package model;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.util.ArrayList;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void testLevelUp() {
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getLevel(), 1);
		game1.levelUp();
		assertEquals(game1.getLevel(), 2);
	}
	@Test
	public void testSetPossibleHazards(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		PossibleHazards ph = new PossibleHazards(25);
		ph.generateHazards(d, 1);
		Game game1 = new Game(d);
		assertNotEquals(game1.getPossibleHazards(), ph);
		game1.setPossibleHazards(ph);
		assertEquals(game1.getPossibleHazards(), ph);
	}
	@Test
	public void testGetHazardNum(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getHazardNum(), 75);
	}
	@Test
	public void testGetPoints(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getPoints(), 0);
	}
	@Test
	public void testLevelGetter(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.levelGetter(), "Level: 1");
	}
	@Test
	public void testGetLevel(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getLevel(), 1);
	}
	@Test
	public void testGetWind(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getWind(), Wind.NEUTRAL);
	}
	@Test
	public void testSetWind(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getWind(), Wind.NEUTRAL);
		game1.setWind(Wind.NORTH);
		assertEquals(game1.getWind(), Wind.NORTH);
	}
	@Test
	public void testSetPoints(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getPoints(), 0);
		game1.setPoints(50);
		assertEquals(game1.getPoints(), 50);
	}
	@Test
	public void testSetPlayer(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		Player p = new Player(0, 0, 0, 0, 0, 0, 0, 0, null, null);
		assertNotEquals(game1.getPlayer(), p);
		game1.setPlayer(p);
		assertEquals(game1.getPlayer(), p);
	}
	@Test
	public void testIsGameOver(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertFalse(game1.isGameOver());
		game1.getPlayer().setLife(0);
		assertTrue(game1.isGameOver());
		game1.getPlayer().setLife(3);
		assertFalse(game1.isGameOver());
		game1.getPlayer().setSalinity(-30);
		assertTrue(game1.isGameOver());
		game1.getPlayer().setSalinity(10);
		assertFalse(game1.isGameOver());
		game1.getPlayer().setSalinity(2000);
		assertTrue(game1.isGameOver());
	}
	@Test
	public void testGetBoard(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.getBoard(), game1.board);
	}
	@Test
	public void testMakeXPos(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals((int)game1.makeXpos().get(0), 30);
	}
	@Test
	public void testMakeYPos(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals((int)game1.makeYpos().get(0), 40);
	}
	@Test
	public void testMakeXBounds(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals((int)game1.makeXbounds().get(0), 50);
	}
	@Test
	public void testMakeYBounds(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals((int)game1.makeYbounds().get(0), 50);
	}
	@Test
	public void testMakeNames(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		assertEquals(game1.makeNames().get(0), "bluecrab_0.png");
	}
	@Test
	public void testOnNextLevel(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		game1.setPossibleHazards(new PossibleHazards(0));
		game1.onNextLevel(d);
		assertEquals(game1.getLevel(),2);
		assertEquals(game1.getHazardNum(), 85);
	}
	@Test
	public void testOnOffScreen(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d, "horsebutton");
		Hazard hazard1 = game1.getPossibleHazards().getHazardsList().get(5);
		game1.getPossibleHazards().getHazardsList().get(5).setXpos(-1);
		game1.onOffScreen(d);
		assertNotEquals(game1.getPossibleHazards().getHazardsList().get(5), hazard1);
	}
	@Test
	public void testSaltOnMovement(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		int sal1 = game1.getPlayer().getSalinity();
		game1.getPlayer().setXpos(15);
		game1.getPlayer().setYpos(15);
		game1.saltOnMovement(d);
		assertTrue(game1.getPlayer().getSalinity()<sal1);
	}
	@Test
	public void testHandleWind(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		game1.setWind(Wind.NEUTRAL);
		game1.handleWind();
		assertEquals(game1.getBoard().getTile(20, 14), -1);
		game1.setWind(Wind.NORTH);
		game1.handleWind();
		assertEquals(game1.getBoard().getTile(20, 14), 1);
		game1.setWind(Wind.SOUTH);
		game1.handleWind();
		assertEquals(game1.getBoard().getTile(20, 14), -1);
	}
	@Test
	public void testGetPoint(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		game1.getPoint();
		assertEquals(game1.getPoints(), 1);
	}
	@Test
	public void testStop(){
		Dimension d = new Dimension();
		d.setSize(40, 40);
		Game game1 = new Game(d);
		game1.stop();
		assertEquals(game1.getPlayer(), null);
		assertEquals(game1.getPossibleHazards(), null);
	}

	
}
