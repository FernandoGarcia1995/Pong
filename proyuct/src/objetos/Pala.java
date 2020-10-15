package objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class Pala extends MapObject{

	private int x;
	private int y;
	private boolean movementRight;
	private boolean movementLeft;
	private static int HEIGHT = 80;
	private static int WIDTH = 10;
	private boolean computerPlayer;
	private int bolaPosX;
	private int bolaPosY;

	public Pala(boolean computerPlayer) {
		this.computerPlayer = computerPlayer;
		init();
	}

	@Override
	public void update() {
		
		if(!computerPlayer) {
		
			if(isMovementLeft() && this.HEIGHT+this.y>this.HEIGHT) {
				y-=8;
			}
			if(isMovementRight() && this.HEIGHT+this.y<GamePanel.HEIGHT*GamePanel.SCALE) {
				y+=8;
			}
			movementLeft = false;
			movementRight = false;
		}else {
			
			if(getBolaPosY()<this.y || getBolaPosY()>this.y+80) {
				if(getBolaPosY()>this.y) {
					y+=8;
				}else if(getBolaPosY()<this.y){
					y-=8;
				}
			}
			
		}
		
	}
	
	public void init() {
		if(!computerPlayer) {
			x = 0;
			y = ((GamePanel.HEIGHT*GamePanel.SCALE /2)-50);
		}else {
			x = ((GamePanel.WIDTH*GamePanel.SCALE)-10);
			y = ((GamePanel.HEIGHT*GamePanel.SCALE /2)-50);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isMovementRight() {
		return movementRight;
	}

	public void setMovementRight(boolean movementRight) {
		this.movementRight = movementRight;
	}

	public boolean isMovementLeft() {
		return movementLeft;
	}

	public void setMovementLeft(boolean movementLeft) {
		this.movementLeft = movementLeft;
	}

	public int getBolaPosX() {
		return bolaPosX;
	}

	public void setBolaPosX(int bolaPosX) {
		this.bolaPosX = bolaPosX;
	}

	public int getBolaPosY() {
		return bolaPosY;
	}

	public void setBolaPosY(int bolaPosY) {
		this.bolaPosY = bolaPosY;
	}

}
