package stage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.GamePanel;
import objetos.Bola;
import objetos.Pala;

public class Stage{
	
	private Bola ball;
	private Pala pala;
	private Pala palaComputer;
	private JPanel jpanel;
	private int marcadorPlayer1;
	private int marcadorPlayer2;
	
	public Stage(JPanel jpanel) {;
		this.pala = new Pala(false);
		this.palaComputer = new Pala(true);
		this.ball = new Bola();
		this.jpanel = jpanel;
		this.marcadorPlayer1 = 0;
		this.marcadorPlayer2 = 0;
	}

	public void draw(Graphics g) {
		jpanel.setBackground(Color.black);
		g.setColor(Color.WHITE);
		g.drawRect(GamePanel.WIDTH, 0, 5, GamePanel.HEIGHT*GamePanel.SCALE);
		g.fillRect(GamePanel.WIDTH, 0, 5, GamePanel.HEIGHT*GamePanel.SCALE);
		g.setFont(new Font("Purisa", Font.PLAIN, 35));
		g.drawString(String.valueOf(marcadorPlayer1), GamePanel.WIDTH-30, 30);
		g.drawString(String.valueOf(marcadorPlayer2), GamePanel.WIDTH+18, 30);
		ball.draw(g);
		pala.draw(g);
		palaComputer.draw(g);
		
		if(ball.getX()==0) {
			marcadorPlayer2++;
			reset();
		}else if(ball.getX()==620){
			marcadorPlayer1++;
			reset();
		}
	}
	
	public void reset() {
		ball.init();
		palaComputer.init();
		pala.init();
	}

	public void updateScene() {
		pala.update();
		ball.setPalaX(pala.getX());
		ball.setPalaY(pala.getY());
		ball.setPalaX2(palaComputer.getBolaPosX());
		ball.setPalaY2(palaComputer.getBolaPosY());
		ball.update();
		palaComputer.setBolaPosX(ball.getX());
		palaComputer.setBolaPosY(ball.getY());
		palaComputer.update();
	}
	
	public void updatePlayer(boolean rightMove, boolean leftMove) {
			
			if(rightMove==true && leftMove==false)
				pala.setMovementRight(true);
			else if(rightMove==false && leftMove==true)
				pala.setMovementLeft(true);
	}
	
}
