package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.PossibleHazards;
import model.Tool;
import model.Wind;

public class Painter extends JPanel{
	
	BufferedImage trash = createImage("images/net.png");
 	BufferedImage recycle = createImage("images/recycle.png");
	BufferedImage compost = createImage("images/compost.png");
	BufferedImage fresh = createImage("images/water_tile.png");
    BufferedImage salt = createImage("images/salt_tile.png");
    BufferedImage heart = createImage("images/fullHeart.png");
    BufferedImage meter = createImage("images/meter.png");
    BufferedImage nowind = createImage("images/neutral_cloud.png");
    BufferedImage northwind = createImage("images/north_cloud.png");
    BufferedImage southwind = createImage("images/south_cloud.png");
    BufferedImage catfish = createImage("images/catfish.png");
    BufferedImage mittencrab = createImage("images/mittencrab.png");
    BufferedImage snakehead= createImage("images/eel.png");
    BufferedImage speedup= createImage("images/speedup.png");
    BufferedImage star= createImage("images/star.png");
    BufferedImage atom= createImage("images/atom.png");
	
	ArrayList<String> names;
	ArrayList<Integer> xpos;
	ArrayList<Integer> ypos;
	ArrayList<Integer> xbounds;
	ArrayList<Integer> ybounds;
	int[][] board;
	int lives;
	int level;
	int salinity;
	int score;
	int saltmax;
	Wind wind;
	int FRAMEWIDTH;
	int FRAMEHEIGHT;
	Tool net;
	boolean gameover;
	Map<String, BufferedImage> images = new HashMap<>();
	
	public Painter(){
		File folder = new File("images");
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  System.out.println(listOfFiles[i].getName());
		        images.put(listOfFiles[i].getName(), this.getImage(listOfFiles[i].getName()));
		      } 
		    }
	}
	
	public void updateView(ArrayList<String> names, ArrayList<Integer> xpos, ArrayList<Integer> xbounds, ArrayList<Integer> ybounds, ArrayList<Integer> ypos, int[][] board, int lives, int level, int salinity, int score,int saltmax, int FRAMEWIDTH, int FRAMEHEIGHT, Wind wind, Tool net, boolean gameover){
		this.names = names;
		this.xpos = xpos;
		this.ypos = ypos;
		this.board = board;
		this.xbounds = xbounds;
		this.ybounds = ybounds;
		this.lives = lives;
		this.level = level;
		this.salinity = salinity;
		this.score = score;
		this.saltmax=saltmax;
		this.wind = wind;
		this.FRAMEWIDTH = FRAMEWIDTH;
		this.FRAMEHEIGHT = FRAMEHEIGHT;
		this.net = net;
		this.gameover = gameover;
	}
	

	 private BufferedImage createImage(String filename){
	    	BufferedImage bufferedImage;
	    	try {
	    		bufferedImage = ImageIO.read(new File(filename));
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	 }
	 
	 private BufferedImage getImage(String name){
		 BufferedImage image;
		 try {
			 image = ImageIO.read(new File("images/" + name));
			 return image;
     		} 
		 catch (IOException e) {
			e.printStackTrace();
		 }
		 return null;
	}
	 public void tutorialPaint(Graphics g, PossibleHazards ph) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			int xsaltindex = 0;
			int ysaltindex = 0;
			for(int i = 0; i<40; i++){
				for(int j = 0; j<20; j++){
					if(board[i][j] == 1){
						g2d.setColor(Color.BLUE);
					    g2d.drawImage(salt,i*(FRAMEWIDTH/40), j*(FRAMEHEIGHT/20), FRAMEWIDTH/40,FRAMEHEIGHT/20, null);
					}else{
						g2d.setColor(Color.CYAN);
					    g2d.drawImage(fresh,i*(FRAMEWIDTH/40), j*(FRAMEHEIGHT/20), FRAMEWIDTH/40,FRAMEHEIGHT/20, null);

					}

				}

			}
			switch (net) {
			case TRASH:
		       g2d.drawImage(trash, xpos.get(0)+27, ypos.get(0)-25, xbounds.get(0), ybounds.get(0), null);
			 break;
			case RECYCLE:
				g2d.drawImage(recycle, xpos.get(0)+29, ypos.get(0)-25, xbounds.get(0), ybounds.get(0), null);				
				break;
			case COMPOST:
			    g2d.drawImage(compost, xpos.get(0)+27, ypos.get(0)-25, xbounds.get(0), ybounds.get(0), null);
			
				break;
			}
		    g2d.drawImage(meter,-100,-30, 280, 230, null);
			String saltstring = "";
			String scorestring = "Points: ";
			String levelstring = "Level: ";
			saltstring = saltstring + salinity;
			scorestring = scorestring + score;
			levelstring = levelstring + level;

			Font d = new Font("monospaced", Font.BOLD, 30);
			g2d.setFont(d);
			if (salinity <  saltmax/5 ||salinity > saltmax - saltmax/5 ) {
				g2d.setColor(Color.RED);
			}
			else {
				g2d.setColor(Color.GREEN);
			}

			g2d.drawString(saltstring, 20, 90);
			int size = 20;
			Font p = new Font("comic sans ms", Font.BOLD, size);
			g2d.setFont(p);
			g2d.setColor(Color.BLACK);
			g2d.drawString(scorestring, 100, 25);
			g2d.drawString(levelstring, (int)(FRAMEWIDTH/2), 20);
			g2d.setColor(Color.WHITE);
			Font n = new Font("comic sans ms", Font.BOLD, 40);
			g2d.setFont(n);
			if (ph.getHazardsList().size() == 12) {
				g2d.drawString("Welcome to Estuary Invasion!", (int) (FRAMEWIDTH / 3), FRAMEHEIGHT / 2);
				g2d.drawString("Use the Arrow Keys to Move.", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)+50);
				g2d.drawString("Go inbetween Fresh and Salt Water", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)+100);
				g2d.drawString("to keep your estuary friend at a happy salt level.", (int) (FRAMEWIDTH / 4), (FRAMEHEIGHT / 2)+150);
				g2d.drawString("Keep an eye on that Refractometer of yours!", (int) (FRAMEWIDTH / 4), (FRAMEHEIGHT / 2)+200);
	
			}
			else if (ph.getHazardsList().size() == 11) {
				g2d.drawImage(trash, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),null);
				g2d.drawString("Use your picker to collect trash!", (int) (FRAMEWIDTH / 2), FRAMEHEIGHT / 2);
			}
			else if (ph.getHazardsList().size() == 10){
				g2d.drawImage(recycle, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),null);
				g2d.drawString("Press space to switch between your pickers!", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("Green is for Recyclables", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("White is for Non-Recyclables", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("Don't make a mistake or you'll", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
				g2d.drawString("lose a heart!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)+50);
			}
			else if (ph.getHazardsList().size() == 9){
				g2d.drawImage(catfish, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),null);
				g2d.drawString("This enemy is a Blue Catfish!", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("He is an invasive species to the estuary", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("and will harm its residents!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("Avoid him or you'll lose a heart!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
			}
			else if (ph.getHazardsList().size() == 8){
				g2d.drawImage(mittencrab, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5), (FRAMEHEIGHT/5), (FRAMEHEIGHT/5), null);
				g2d.drawString("This enemy is a Mitten Crab!", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("He is also an invasive species to the estuary", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("and will harm its residents!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("Avoid his evil bouncing or you'll lose a heart!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
			}
			else if (ph.getHazardsList().size() == 7){
				g2d.drawImage(snakehead, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),null);
				g2d.drawString("This enemy is a Northern Snakehead!", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("He is also an invasive species to the estuary", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("and will harm its residents!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("He will try to hunt you down!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
				g2d.drawString("Avoid him at all costs!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)+50);
			}
			else if (ph.getHazardsList().size() == 6){
				g2d.drawImage(heart, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5), (FRAMEHEIGHT/5), (FRAMEHEIGHT/5),null);
				g2d.drawString("Saving the estuary may be", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("sounding pretty hard, but don't worry!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("There are plenty of powerups to help you.", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("For instance, this heart will heal you 1 heart", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
			}
			else if (ph.getHazardsList().size() == 5){
				g2d.drawImage(speedup, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),  (FRAMEHEIGHT/5), (FRAMEHEIGHT/5),null);
				g2d.drawString("This powerup will increase you speed", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("use it to zip around the screen super fast!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
			}
			else if (ph.getHazardsList().size() == 4){
				g2d.drawImage(atom, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),  (FRAMEHEIGHT/5), (FRAMEHEIGHT/5),null);
				g2d.drawString("This powerup will clear all", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("of the trash and invasive species", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("from the estuary!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("It's pretty rare though.", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
			}
			else if (ph.getHazardsList().size() == 3){
				g2d.drawImage(star, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),  (FRAMEHEIGHT/5), (FRAMEHEIGHT/5),null);
				g2d.drawString("This powerup make you invulnerable", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("to invasive species and able to", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("pick up any trash!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("Go wild when you have it!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
			}
			else if (ph.getHazardsList().size() == 2){
				g2d.drawImage(nowind, (FRAMEWIDTH/2),3*(FRAMEHEIGHT/5),  (FRAMEHEIGHT/5), (FRAMEHEIGHT/5),null);
				g2d.drawString("Mr. Cloud will be at the top", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("of the screen and change the", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("direction of the wind.", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
				g2d.drawString("This will change the size of the", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2));
				g2d.drawString("fresh and saltwater zones depending on ", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)+50);
				g2d.drawString("whether he's blowing inland or out to sea", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)+100);
			}
			else if (ph.getHazardsList().size() == 1){
				g2d.setColor(Color.RED);
				g2d.drawString("Looks like your all ready to play!", (int) (FRAMEWIDTH / 3),(FRAMEHEIGHT / 2)-150);
				g2d.drawString("Can't wait to see you in the real game buddy!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-100);
				g2d.drawString("Now go on and get to saving the estuary!", (int) (FRAMEWIDTH / 3), (FRAMEHEIGHT / 2)-50);
			}
			BufferedImage image;
			for (int i = 0; i < xpos.size(); i++) {
				if(images!=null){
				image = images.get(names.get(i));
				g2d.drawImage(image, xpos.get(i), ypos.get(i),xbounds.get(i), ybounds.get(i), null);
				}
				else{
					g2d.drawImage(heart, xpos.get(i), ypos.get(i),xbounds.get(i), ybounds.get(i), null);
				}
			}
			int x = 100;
			for (int i = 0; i < lives; i++) {
				g2d.drawImage(heart,x, 35, 30,25, null);
	            x += 40;
			}
			g2d.setColor(Color.BLACK);
			if (gameover) {
				int fontSize = 60;
				Font f = new Font("Arial Black", Font.BOLD, fontSize);
				Font s = new Font("Comic Sans MS", Font.PLAIN, 20);
				g2d.setFont(f);
				g2d.setColor(Color.RED);
				//g2d.drawString("You are now ready to play!", (int) (FRAMEWIDTH / 2.5), FRAMEHEIGHT / 2);
			}
		}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		int xsaltindex = 0;
		int ysaltindex = 0;
		for(int i = 0; i<40; i++){
			for(int j = 0; j<20; j++){
				if(board[i][j] == 1){
					g2d.setColor(Color.BLUE);
				    g2d.drawImage(salt,i*(FRAMEWIDTH/40), j*(FRAMEHEIGHT/20), FRAMEWIDTH/40,FRAMEHEIGHT/20, null);

					
				}else{
					g2d.setColor(Color.CYAN);
				    g2d.drawImage(fresh,i*(FRAMEWIDTH/40), j*(FRAMEHEIGHT/20), FRAMEWIDTH/40,FRAMEHEIGHT/20, null);

				}

			}

		}
		switch (net) {
		case TRASH:
	       g2d.drawImage(trash, xpos.get(0)+27, ypos.get(0)-25, xbounds.get(0), ybounds.get(0), null);
		 break;
		case RECYCLE:
			g2d.drawImage(recycle, xpos.get(0)+29, ypos.get(0)-25, xbounds.get(0), ybounds.get(0), null);				
			break;
		case COMPOST:
		    g2d.drawImage(compost, xpos.get(0)+27, ypos.get(0)-25, xbounds.get(0), ybounds.get(0), null);
		
			break;
		}
		
		
	
		
	    g2d.drawImage(meter,-100,-30, 280, 230, null);
	    String saltstring = "";
		String scorestring = "Points: ";
		String levelstring = "Level: ";
		String windstring = "";
		saltstring = saltstring + salinity/10;
		scorestring = scorestring + score;
		levelstring = levelstring + level;
		windstring = windstring + wind;

		Font d = new Font("monospaced", Font.BOLD, 30);
		g2d.setFont(d);
		if (salinity <  saltmax/5 ||salinity > saltmax - saltmax/5 ) {
			g2d.setColor(Color.RED);
		}
		else {
			g2d.setColor(Color.GREEN);
		}

		g2d.drawString(saltstring, 20, 90);
		int size = 20;
		Font p = new Font("comic sans ms", Font.BOLD, size);
		g2d.setFont(p);
		g2d.setColor(Color.BLACK);
		g2d.drawString(scorestring, 100, 25);
		g2d.drawString(levelstring, (int)(FRAMEWIDTH/2), 20);
		switch(wind){
		case NEUTRAL:
			g2d.drawImage(nowind, (int)(FRAMEWIDTH/4)+(FRAMEWIDTH/2), 0, 100, 100, null);
			break;
		case SOUTH:
			g2d.drawImage(southwind, (int)(FRAMEWIDTH/4)+(FRAMEWIDTH/2), 0, 100, 100, null);
			break;
		case NORTH:
			g2d.drawImage(northwind, (int)(FRAMEWIDTH/4)+(FRAMEWIDTH/2), 0, 100, 100, null);
			break;
		}
		g2d.drawString(windstring, (int)(FRAMEWIDTH/4)+(FRAMEWIDTH/2)+20, 115);
		BufferedImage image;
		for (int i = 0; i < xpos.size(); i++) {
			if(images!=null){
			image = images.get(names.get(i));
			g2d.drawImage(image, xpos.get(i), ypos.get(i),xbounds.get(i), ybounds.get(i), null);
			}
			else{
				g2d.drawImage(heart, xpos.get(i), ypos.get(i),xbounds.get(i), ybounds.get(i), null);
			}
		}
		int x = 100;
		for (int i = 0; i < lives; i++) {
			g2d.drawImage(heart,x, 35, 30,25, null);
            x += 40;
		}
		g2d.setColor(Color.BLACK);
	}
}
