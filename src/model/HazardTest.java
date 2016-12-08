package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HazardTest {

	@Test
	public void testGetSpawntime() {
		Hazard h = new Hazard(0, 0, 0, 0, 50, MovementType.COLLIDEDDOWN, "image");
		assertEquals(h.getSpawntime(),50);
	}
	
	@Test
	public void  testSetSpawntime(){
		Hazard h = new Hazard(0, 0, 0, 0, 50, MovementType.COLLIDEDDOWN, "image");
		h.setSpawntime(100);
		assertEquals(h.getSpawntime(),100);
	}
	
	@Test
	public void  testGetType(){
		Hazard h = new Enemy1(0, 0, 0, 0, 50, 0);
		assertEquals(h.getType(),HazardType.ENEMY1);
	}
	
	@Test
	public void  testSetType(){
		Hazard h = new Hazard(0, 0, 0, 0, 50, MovementType.COLLIDEDDOWN, "image");
		h.setType(HazardType.ENEMY1);
		assertEquals(h.getType(),HazardType.ENEMY1);
	}
	
	@Test
	public void testMove(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.move();
		assertEquals(h.getXpos(),21);
		h.setMovementType(MovementType.LEFT);
		h.move();
		assertEquals(h.getXpos(),20);
		h.setMovementType(MovementType.COLLIDEDUP);
		h.move();
		assertEquals(h.getXpos(),25);
		assertEquals(h.getYpos(),19);
		h.setMovementType(MovementType.COLLIDEDDOWN);
		h.move();
		assertEquals(h.getXpos(),31);
		assertEquals(h.getYpos(),20);
		h.setMovementType(MovementType.ENEMY2MOVE);
		h.move();
		assertEquals(h.getXpos(),30);
		h.setMovementType(MovementType.ENEMYMOVE);
		int x = h.getXpos() - h.getXvel();
		double y = Math.sin(h.getXpos() / 20) * (-12);
		int expectedY = ((int) y) + h.getYpos();
		h.move();
		assertEquals(h.getXpos(),x);
		assertEquals(h.getYpos(),expectedY);
		h.setMovementType(MovementType.RIGHT);
		int expectedX = h.getXpos() + 1;
		h.move();
		assertEquals(h.getXpos(), expectedX);
	}
	
	@Test
	public void testGetXpos(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		assertEquals(h.getXpos(),20);
	}
	
	public void testGetYpos(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		assertEquals(h.getYpos(),20);
	}
	
	public void testSetYpos(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.setYpos(30);
		assertEquals(h.getYpos(),30);
	}
	
	public void testSetXpos(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.setXpos(30);
		assertEquals(h.getXpos(),30);
	}
	
	@Test
	public void testGetYvel(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		assertEquals(h.getYvel(),1);
	}
	
	@Test
	public void testGetXvel(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		assertEquals(h.getXvel(),1);
	}
	
	@Test
	public void testSetYvel(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.setYvel(100);
		assertEquals(h.getYvel(),100);
	}
	
	@Test
	public void testSetXvel(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.setXvel(100);
		assertEquals(h.getXvel(),100);
	}
	
	@Test
	public void testSetMovementType(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.setMovementType(MovementType.LEFT);
		assertEquals(h.getMovementType(),MovementType.LEFT);
	}
	
	@Test
	public void testGetMovementType(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		assertEquals(h.getMovementType(),MovementType.RIGHT);
	}
	
	@Test
	public void testIncreaseXVel(){
		Hazard h = new Hazard(20,20,1,1,0,MovementType.RIGHT,"image");
		h.increasexvel(5);
		assertEquals(h.getXvel(),6);
	}
	
	@Test
	public void testGetPowerupType(){
		Hazard p = new Powerup(0, 0, 0, 0, 0, PowerupType.INVINCIBLE);
		assertEquals(p.getPowerupType(),PowerupType.INVINCIBLE);
	}
	
	@Test
	public void testGetToolType(){
		Hazard t = new Trash(0, 0, 0, 0, 0, Tool.COMPOST);
		assertEquals(t.getToolType(),Tool.COMPOST);
	}

}
