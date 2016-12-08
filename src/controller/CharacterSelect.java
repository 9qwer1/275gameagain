	package controller;

	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Image;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.io.File;

	import javax.imageio.ImageIO;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.Timer;

	public class CharacterSelect extends JPanel{
		static Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
		public static int FRAMEHEIGHT = (int) SCREENSIZE.getHeight();
		public static int FRAMEWIDTH = (int) SCREENSIZE.getWidth();
		JButton blue = new JButton();
		JButton horseshoe = new JButton();
		JButton oyster = new JButton();
		JButton back = new JButton();
		JFrame frame;
		
		
		public void setFrame(JFrame f){
			this.frame = f;
		}
		
		public CharacterSelect(){
			CharacterSelect currentFrame = this;
			setLayout(new FlowLayout());
			setSize((int) (.33*FRAMEWIDTH), (int) (.5*FRAMEHEIGHT));
			try{
				Image b = ImageIO.read(new File("images/crabbutton.png"));
				Image h = ImageIO.read(new File("images/horsebutton.png"));
				Image o = ImageIO.read(new File("images/oysterbutton.png"));
				Image backi = ImageIO.read(new File("images/back.png"));
				blue.setIcon(new ImageIcon(b));
				horseshoe.setIcon(new ImageIcon(h));
				oyster.setIcon(new ImageIcon(o));
				back.setIcon(new ImageIcon(backi));
			} catch (Exception ex){
				System.out.println(ex);
			}

			setBackground(Color.BLUE);
			blue.setBackground(null);
			horseshoe.setBackground(null);
			oyster.setBackground(null);
			back.setBackground(null);
			
			add("Oyster", oyster);
			add("BlueCrab", blue);
			add("HorseShoe", horseshoe);
			
			add("Back", back);
			CharacterSelect cs = this;
			back.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent event) {
					currentFrame.setVisible(false);
					StartMenu sm = new StartMenu(frame);
					frame.add(sm);
					frame.remove(cs);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
			});
			blue.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent event) {
					System.out.println("Registering mouse click");
					GameWindow gw = new GameWindow("blue_crab");
					gw.setFrame(frame);
					currentFrame.setVisible(false);
					frame.add(gw);
					frame.add(gw.control);
					
					
					gw.control.getGame().getPlayer().setSalmax(800);
					gw.control.getGame().getPlayer().setSalmin(0);
					
					
					ActionListener taskPerformer = new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							if (gw.control.getGame().getLevel()==3){
								frame.remove(gw.control);
								frame.remove(gw);
								Party p = new Party(frame);
								frame.add(p);
								frame.setSize(gw.control.FRAMEWIDTH , gw.control.FRAMEHEIGHT );
								p.setFrame(frame);
								
							}
							if (gw.control.getGame().isGameOver() == true){
								frame.remove(gw.control);
								Death d = new Death(frame);
								frame.add(d);
								frame.setSize(gw.control.FRAMEWIDTH ,  gw.control.FRAMEHEIGHT );
								d.setFrame(frame);
						
							}
							
							gw.control.update();
						}
					};
					Timer timer = new Timer(25, taskPerformer);
					timer.start();
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
			});
			horseshoe.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent event) {
					System.out.println("Registering mouse click");
					GameWindow gw = new GameWindow("horseshoe_crab");
					gw.setFrame(frame);
					currentFrame.setVisible(false);
					frame.add(gw);
					frame.add(gw.control);
					

					gw.control.getGame().getPlayer().setSalmax(600);
					gw.control.getGame().getPlayer().setSalmin(0);
					
					
					ActionListener taskPerformer = new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							if (gw.control.getGame().getLevel()==3){
								frame.remove(gw.control);
								frame.remove(gw);
								Party p = new Party(frame);
								frame.add(p);
								frame.setSize(gw.control.FRAMEWIDTH , gw.control.FRAMEHEIGHT );
								p.setFrame(frame);
								
							}
							if (gw.control.getGame().isGameOver() == true){
								frame.remove(gw.control);
								Death d = new Death(frame);
								frame.add(d);
								frame.setSize(gw.control.FRAMEWIDTH ,  gw.control.FRAMEHEIGHT );
								d.setFrame(frame);
						
							}
							
							gw.control.update();
					
						}
					};
					Timer timer = new Timer(25, taskPerformer);
					timer.start();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			oyster.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent event) {
					System.out.println("Registering mouse click");
					GameWindow gw = new GameWindow("oyster");
					gw.setFrame(frame);
					currentFrame.setVisible(false);
					frame.add(gw);
					frame.add(gw.control);
					

					gw.control.getGame().getPlayer().setSalmax(1000);
					gw.control.getGame().getPlayer().setSalmin(0);
					
					ActionListener taskPerformer = new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							if (gw.control.getGame().getLevel()==3){
								frame.remove(gw.control);
								frame.remove(gw);
								Party p = new Party(frame);
								frame.add(p);
								frame.setSize(FRAMEWIDTH , FRAMEHEIGHT );
								p.setFrame(frame);
								
							}
							if (gw.control.getGame().isGameOver() == true){
								frame.remove(gw.control);
								Death d = new Death(frame);
								frame.add(d);
								frame.setSize(FRAMEWIDTH , FRAMEHEIGHT );
								d.setFrame(frame);
						
							}
							
							gw.control.update();
						}
					};
					Timer timer = new Timer(25, taskPerformer);
					timer.start();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		public static void main(String[] args){
			System.out.println("CharacterSelect main is being called");
			JFrame frame = new JFrame();
			CharacterSelect cs = new CharacterSelect();
			frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
			frame.add(cs);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}

