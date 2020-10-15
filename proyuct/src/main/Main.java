package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main{

    public static void main(String... args) {
		JFrame window = new JFrame("Pong game");
		window.setContentPane(new GamePanel());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(dim.width/2-GamePanel.WIDTH*GamePanel.SCALE/2, dim.height/2-GamePanel.HEIGHT*GamePanel.SCALE/2);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
    }

}
