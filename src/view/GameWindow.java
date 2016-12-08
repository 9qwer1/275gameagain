package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class GameWindow extends JPanel {
	static Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
	public static int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
	JFrame frame;
	public Controller control;
	
	public void setFrame(JFrame f){
		this.frame = f;
	}
	
	public GameWindow(String imageName){
		setLayout(new FlowLayout());
		setSize((int) (.33*FRAMEWIDTH), (int) (.5*FRAMEHEIGHT));
		control = new Controller(imageName);
	}
	
	public GameWindow(String imageName, boolean tutorial){
		if (tutorial){
			setLayout(new FlowLayout());
			control = new Controller(imageName,true);
		}
	
	}
	
}
