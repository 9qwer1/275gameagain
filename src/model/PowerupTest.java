package model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PowerupTest {

	@Test
	public void testGetPowerupType() {
		Powerup pu = new Powerup(0, 0, 0, 0, 0, PowerupType.ADDLIFE);
		assertEquals(pu.getPowerupType(), PowerupType.ADDLIFE);
	}
	@Test
	public void testGetColor(){
		Powerup pu = new Powerup(0, 0, 0, 0, 0, PowerupType.CLEAR);
		assertEquals(pu.getColor(), Color.ORANGE);
	}

}
