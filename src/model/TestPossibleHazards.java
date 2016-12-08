package model;

import static org.junit.Assert.*;

import java.awt.Toolkit;
import java.util.ArrayList;

import org.junit.Test;

public class TestPossibleHazards {

	@Test
	public void testIsBetweenInce() {
		assertTrue(PossibleHazards.isBetweenInc(5, 4, 6));
		assertFalse(PossibleHazards.isBetweenInc(10, 4, 5));
	}
	
	@Test
	public void testGenerateHazards(){
		PossibleHazards ph = new PossibleHazards(100);
		ph.generateHazards(Toolkit.getDefaultToolkit().getScreenSize(), 1);
		ArrayList<Hazard> hazards = ph.getHazardsList();
		assertTrue(hazards.size() > 0);
	}
	
	@Test
	public void testSetPossibleHazards(){
		PossibleHazards ph = new PossibleHazards(100);
		ArrayList<Hazard> hazards = new ArrayList<Hazard>();
		hazards.add(new Hazard(0, 0, 0, 0, 0, MovementType.COLLIDEDDOWN, ""));
		ph.setpossibleHazards(hazards);
		assertEquals(ph.getHazardsList(),hazards);
	}
	
	@Test
	public void testAddHazard(){
		PossibleHazards ph = new PossibleHazards(100);
		Hazard h = new Hazard(0, 0, 0, 0, 50, MovementType.COLLIDEDDOWN, "image");
		ph.generateHazards(Toolkit.getDefaultToolkit().getScreenSize(), 1);
		ArrayList<Hazard> hazards = ph.getHazardsList();
		ph.addHazard(h);
		assertTrue(hazards.contains(h));
	}
	
	@Test
	public void testGetHazardList(){
		PossibleHazards ph = new PossibleHazards(100);
		ArrayList<Hazard> hazards = new ArrayList<Hazard>();
		hazards.add(new Hazard(0, 0, 0, 0, 0, MovementType.COLLIDEDDOWN, ""));
		ph.setpossibleHazards(hazards);
		assertEquals(ph.getHazardsList(), hazards);
	}
	
	@Test
	public void testRemoveHazard(){
		Hazard h = new Hazard(0, 0, 0, 0, 50, MovementType.COLLIDEDDOWN, "image");
		PossibleHazards ph = new PossibleHazards(100);
		ph.addHazard(h);
		ph.removeHazard(0);
		assertEquals(ph.getHazardsList().size(),0);
	}

	@Test
	public void testSelectRandom(){
		PossibleHazards ph = new PossibleHazards(100);
		ph.generateHazards(Toolkit.getDefaultToolkit().getScreenSize(), 1);
		Hazard h = ph.selectRandom();
		assertTrue(ph.getHazardsList().contains(h));
	}
	
	@Test
	public void testClearEnemies(){
		PossibleHazards ph = new PossibleHazards(100);
		ph.generateHazards(Toolkit.getDefaultToolkit().getScreenSize(), 1);
		int enemyCount = 0;
		for (Hazard h: ph.getHazardsList()){
			if (h.getType().equals(HazardType.ENEMY1) || h.getType().equals(HazardType.ENEMY2) || 
					h.getType().equals(HazardType.ENEMY3)) {
				enemyCount += 1;
			}
		}
		int expectedSize = ph.getHazardsList().size() - enemyCount;
		ph.clearEnemies(Toolkit.getDefaultToolkit().getScreenSize());
		assertEquals(expectedSize,ph.getHazardsList().size());
	}
}
