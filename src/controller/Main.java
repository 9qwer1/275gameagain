package controller;

import javax.swing.JFrame;

import view.StartMenu;

public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame("CrabGame");
		StartMenu sm = new StartMenu(frame);
		frame.add(sm);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
