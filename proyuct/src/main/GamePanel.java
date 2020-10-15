package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import stage.Stage;


public class GamePanel extends JPanel 
implements Runnable,KeyListener{
	
	// dimensions
		public static final int WIDTH = 320;
		public static final int HEIGHT = 240;
		public static final int SCALE = 2;
		
		// game thread
		private Thread thread;
		private boolean running;
		private int FPS = 60;
		private long targetTime = 1000 / FPS;
		
		// image
		private BufferedImage image;
		private Graphics2D g;
		
		// Stage
		private Stage stage;
		
		public GamePanel() {
			super();
			setPreferredSize(
				new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
			setFocusable(true);
			requestFocus();
			addKeyListener(this);
		}
		
		public void addNotify() {
			super.addNotify();
			if(thread == null) {
				thread = new Thread(this);
				thread.start();
			}
		}
		
		private void init() {
			
			image = new BufferedImage(
						WIDTH, HEIGHT,
						BufferedImage.TYPE_INT_RGB
					);
			g = (Graphics2D) image.getGraphics();
			
			running = true;
			
			stage = new Stage(this);
			
		}
		
		public void run() {
			
			init();		
			long start;
			long elapsed;
			long wait;
			// game loop
			while(running) {
				
				start = System.nanoTime();
				
				update();
				repaint();
				
				elapsed = System.nanoTime() - start;
				
				wait = targetTime - elapsed / 1000000;
				if(wait < 0) wait = 5;
				
				try {
					Thread.sleep(wait);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		private void update() {
			stage.updateScene();
		}
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        stage.draw(g);
	    }
		private void drawToScreen() {
			Graphics g2 = getGraphics();
			g2.drawImage(image, 0, 0,
					WIDTH * SCALE, HEIGHT * SCALE,
					null);
			g2.dispose();
		}

		public void keyTyped(KeyEvent key) {}
		public void keyPressed(KeyEvent key) {
			
			if(key.getKeyCode()==KeyEvent.VK_RIGHT)
				stage.updatePlayer(true, false);
			else if(key.getKeyCode()==KeyEvent.VK_LEFT)
				stage.updatePlayer(false, true);
		
		}
		
		public void keyReleased(KeyEvent key) {
		}

}

