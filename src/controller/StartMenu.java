package controller;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartMenu extends JPanel{
	static Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
	public static int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
	JButton play = new JButton();
	JButton help = new JButton();
	JFrame frame;
	
	public StartMenu(JFrame aframe){
		this.frame = aframe;
		setLayout(new FlowLayout());
		frame.setSize((int) (FRAMEWIDTH), (int) (FRAMEHEIGHT));
		try{
			Image p = ImageIO.read(new File("images/play.png"));
			Image h = ImageIO.read(new File("images/help.png"));
			play.setIcon(new ImageIcon(p));
			help.setIcon(new ImageIcon(h));
		} catch (Exception ex){
			System.out.println(ex);
		}
		play.setBackground(null);
		help.setBackground(null);
		add("Play", play);
		add("Help", help); 
		setBackground(Color.BLUE);
		StartMenu sm = this;
		play.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent event) {
				sm.setVisible(false);
				CharacterSelect cs = new CharacterSelect();
				cs.setFrame(frame);
				frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
				frame.add(cs);
				frame.remove(sm);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		help.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent event) {
				Help h = new Help(frame);
				frame.add(h);
				frame.remove(sm);
			} 
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}

	public static void main(String[] args){
		JFrame frame = new JFrame("CrabGame");
		StartMenu sm = new StartMenu(frame);
		frame.setSize((int)(FRAMEWIDTH), (int)(FRAMEHEIGHT));
		frame.add(sm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
