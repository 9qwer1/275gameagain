package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import controller.Controller;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Crab Game");
		Controller control = new Controller();
		frame.add(control);
		frame.setSize(control.FRAMEWIDTH, control.FRAMEHEIGHT);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				control.update();
				if (control.getGame().getLevel()==3){
					frame.remove(control);
					Party p = new Party(frame);
					frame.add(p);
					frame.setSize((int) (control.FRAMEWIDTH ), (int) (control.FRAMEHEIGHT ));
					p.setFrame(frame);
					
				}
				if (control.getGame().isGameOver() == true){
					frame.remove(control);
					Death d = new Death(frame);
					frame.add(d);
					frame.setSize((int) (control.FRAMEWIDTH ), (int) (control.FRAMEHEIGHT ));
					d.setFrame(frame);
			
				}
			}
		};
		Timer timer = new Timer(25, taskPerformer);
		timer.start();
	}
}
