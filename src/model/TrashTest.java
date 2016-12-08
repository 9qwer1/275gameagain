package model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class TrashTest {

	@Test
	public void testGetToolType() {
		Trash t = new Trash(0, 0, 0, 0, 0, Tool.TRASH);
		assertEquals(t.getToolType(), Tool.TRASH);
	}
	@Test
	public void testSetType(){
		Trash t = new Trash(0, 0, 0, 0, 0, Tool.COMPOST);
		t.setType(HazardType.ENEMY2);
		assertEquals(t.getType(), HazardType.ENEMY2);
	}
	@Test
	public void testGetColor(){
		Trash t = new Trash(0, 0, 0, 0, 0, Tool.RECYCLE);
		t.setType(HazardType.ENEMY3);
		assertEquals(t.getColor(), Color.DARK_GRAY);
	}

}
