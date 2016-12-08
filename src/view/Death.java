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

public class Death extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public static int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
	public static int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
	JButton tryAgain = new JButton();
	JFrame frame;
	
	public void setFrame(JFrame f) {
	    this.frame = f;		
		}
	
	public Death(JFrame aframe){
		this.frame = aframe;
		setLayout(new FlowLayout());
		frame.setSize((int) (FRAMEWIDTH), (int) (FRAMEHEIGHT));
		try{
			Image b = ImageIO.read(new File("images/playagain.png"));
			tryAgain.setIcon(new ImageIcon(b));
		} catch (Exception ex){
			System.out.println(ex);
		}
		tryAgain.setBackground(null);
		add("Try Again", tryAgain);
		Death d = this;
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		tryAgain.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent event) {
				StartMenu sm = new StartMenu(frame);
				frame.add(sm);
				frame.remove(d);
				frame.remove(tryAgain);
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
			backg = ImageIO.read(new File("Images/Death.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
        g.drawImage(backg, 0, 0, getWidth(), getHeight(), this);
    }

	
}
