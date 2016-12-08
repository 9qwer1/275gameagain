package controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JPanel{
	static Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
	public static int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
	JButton back = new JButton();
	JFrame frame;
	
	public void setFrame(JFrame aframe){
		this.frame = aframe;
	}
	public Help(JFrame aframe){
		frame = aframe;
		frame.setSize((int) (.8*FRAMEWIDTH), (int) (.8*FRAMEHEIGHT));
		ImageIcon imgi = null;
		try {
			imgi = new ImageIcon(ImageIO.read(new File("Images/back.png")));
		} catch (IOException e) {
			System.out.println(e);
		}
		Image img = imgi.getImage();
		Image newimg = img.getScaledInstance(200, 80, Image.SCALE_SMOOTH);
		ImageIcon backimg= new ImageIcon(newimg);
		back.setIcon(backimg);
		Help h = this;
		back.setBounds((int)(.47*FRAMEWIDTH), (int)(.39*FRAMEHEIGHT), 200, 80);
		back.setBackground(null);
		back.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				h.setVisible(false);
				StartMenu sm = new StartMenu(frame);
				frame.add(sm);
				frame.remove(h);
				frame.remove(back);
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
		back.setBounds((int)(.47*FRAMEWIDTH), (int)(.39*FRAMEHEIGHT), 200, 80);
		frame.add(back);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage backg = null;
        try {
			backg = ImageIO.read(new File("Images/tutorial.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
        g.drawImage(backg, 0, 0, getWidth(), getHeight(), this);
    }
}
