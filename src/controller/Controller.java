package controller;

import javax.swing.JPanel;

import view.Death;
import view.Painter;
import model.Game;
import model.Hazard;
import model.HazardType;
import model.MovementType;
import model.Player;
import model.PossibleHazards;
import model.PowerupType;
import model.State;
import model.Tool;
import model.Wind;

import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;

public class Controller extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	KeyFunctions k = new KeyFunctions();
	Game game;
	String name;
	Painter painter;
	int count = 0;
	int powerupCount = 0;
	Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
	public int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
	Color color;
	boolean up;
	boolean down;
	boolean isTutorial = false;
	boolean left;
	boolean right;
	int alpha = 0; // makes transparent
	Color myColor = new Color(255, 60, 50, alpha);

	public Controller() {
		game = new Game(SCREENSIZE);
		painter = new Painter();
		count = 0;
		addKeyListener(this);
		name = game.getPlayer().getImageType();
		name = name.replace(".png", "");
		up = false;
		down = false;
		left = false;
		right = false;
	}
	public Controller(String imageName,boolean tutorial) {
		game = new Game(SCREENSIZE, imageName, true);
		painter = new Painter();
		count = 0;
		addKeyListener(this);
		up = false;
		down = false;
		left = false;
		right = false;
		this.isTutorial = tutorial;
	}

	public Controller(String imageName) {
		game = new Game(SCREENSIZE, imageName);
		painter = new Painter();
		count = 0;
		addKeyListener(this);
		name = game.getPlayer().getImageType();
		name = name.replace(".png", "");
		up = false;
		down = false;
		left = false;
		right = false;
	}

	@Override
	public void paint(Graphics g) {
		if (isTutorial){
			painter.tutorialPaint(g,game.getPossibleHazards());
		}
		else{
		painter.paint(g);
		}
	}


	public void update() {
		count++;
		game.update();
		keyUpdate();
		painter.updateView(game.makeNames(), game.makeXpos(), game.makeXbounds(), game.makeYbounds(), game.makeYpos(),
				game.getBoard().getArr(), game.getPlayer().getLife(), game.getLevel(), game.getPlayer().getSalinity(),
				game.getPoints(), game.getPlayer().getSalmax(), FRAMEWIDTH, FRAMEHEIGHT, game.getWind(), game.getPlayer().getTool(),
				game.isGameOver());
		repaint();
	}


	public Game getGame() {
		return this.game;
	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public void keyUpdate() {
		if (down) {

			game.getPlayer().setYpos(game.getPlayer().getYpos() + game.getPlayer().getYvel());
			if (game.getPlayer().getYpos() < 0) {
				game.getPlayer().setYpos(0);
			} else if (game.getPlayer().getYpos() + 30 > getHeight()) {
				game.getPlayer().setYpos(getHeight() - 30);
			}
		}
		if (up) {
			game.getPlayer().setYpos(game.getPlayer().getYpos() - game.getPlayer().getYvel());
			if (game.getPlayer().getYpos() < 0) {
				game.getPlayer().setYpos(0);
			} else if (game.getPlayer().getYpos() + 30 > getHeight()) {
				game.getPlayer().setYpos(getHeight() - 30);
			}
		}
		if (left) {

			game.getPlayer().setXpos(game.getPlayer().getXpos() - game.getPlayer().getXvel());
			if (game.getPlayer().getXpos() < 0) {
				game.getPlayer().setXpos(0);
			} else if (game.getPlayer().getXpos() + 30 > getWidth()) {
				game.getPlayer().setXpos(getWidth() - 30);
			}
		}

		if (right) {

			game.getPlayer().setXpos(game.getPlayer().getXpos() + game.getPlayer().getXvel());
			if (game.getPlayer().getXpos() < 0) {
				game.getPlayer().setXpos(0);
			} else if (game.getPlayer().getXpos() + 30 > getWidth()) {
				game.getPlayer().setXpos(getWidth() - 30);
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (code == KeyEvent.VK_UP) {
			up = true;

		}
		if (code == KeyEvent.VK_LEFT) {

			left = true;
		}

		if (code == KeyEvent.VK_RIGHT) {

			right = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_DOWN) {
			down = false; // removing velx = 0 allows us to go vertically and
							// horizontlly at the same time

		}
		if (code == KeyEvent.VK_UP) {
			up = false;

		}
		if (code == KeyEvent.VK_LEFT) {

			left = false;
		}

		if (code == KeyEvent.VK_RIGHT) {

			right = false;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ') {
			game.getPlayer().SwitchTool();
		}

	}
}
