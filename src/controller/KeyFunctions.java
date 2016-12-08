package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyFunctions extends KeyAdapter {
	static boolean[] keys = new boolean[1000];

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
