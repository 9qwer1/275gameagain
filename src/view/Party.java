package view;
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
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Party extends JPanel{
	static Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
	public static int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
	JButton backToMenu = new JButton();
	JFrame frame;
	
	
	public Party(JFrame aframe){
		this.frame = aframe;
		setLayout(new FlowLayout());
		frame.setSize((int) (FRAMEWIDTH), (int) (FRAMEHEIGHT));
		try{
			Image b = ImageIO.read(new File("images/playagain.png"));
			backToMenu.setIcon(new ImageIcon(b));
		} catch (Exception ex){
			System.out.println(ex);
		}
		backToMenu.setBackground(null);
		add("Back To Menu", backToMenu);
	
		Party p = this;
		backToMenu.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent event) {
				p.setVisible(false);
				frame.remove(p);
				StartMenu sm = new StartMenu(frame);
				frame.add(sm);
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
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage backg = null;
        try {
			backg = ImageIO.read(new File("Images/Win.jpg"));
		} catch (IOException e) {
			System.out.println(e);
		}
        g.drawImage(backg, 0, 0, getWidth(), getHeight(), this);
    }


	public void setFrame(JFrame f) {
    this.frame = f;		
	}
}
