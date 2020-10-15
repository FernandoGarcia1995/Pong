package objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.GamePanel;

public class Bola extends MapObject{
	
	private static int WIDTH = 12;
	private static int HEIGHT = 12;
	private int x = 0;
	private int y = 0;
	private int xMovement = -4;
	private int yMovement = 4;
	private int palaX;
	private int palaY;
	private int palaX2;
	private int palaY2;
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void update() {
		move();
	}
	
	public int move() {
		
		if(this.WIDTH+this.x==GamePanel.WIDTH*GamePanel.SCALE) {
			xMovement = -xMovement;
		}else if(this.WIDTH+this.x==WIDTH) {
			xMovement =-xMovement;
		}else if(this.HEIGHT+this.y==HEIGHT) {
			yMovement = -yMovement;
		}else if(this.HEIGHT+this.y==GamePanel.HEIGHT*GamePanel.SCALE){
			yMovement = -yMovement;
		}
		
		if(ispaleCollapse()) {
			System.out.println("colapsa");
			xMovement = -xMovement;
		}
		
		this.x = x + xMovement;
		this.y = y + yMovement;
		
		return 0;
	}
	
	public boolean ispaleCollapse(){
		
		System.out.println(this.x);
		
		boolean hit = false;
		
		if(this.y>=this.palaY && this.y<=this.palaY+80 && this.x==12) {
			hit = true;
		}
		
		if(this.y>=this.palaY2 && this.y<=this.palaY2+80 && this.x==616) {
			hit = true;
		}
		return hit;
	}
	

	public int getPalaX() {
		return palaX;
	}

	public void setPalaX(int palaX) {
		this.palaX = palaX;
	}

	public int getPalaY() {
		return palaY;
	}

	public void setPalaY(int palaY) {
		this.palaY = palaY;
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
	

	public int getPalaX2() {
		return palaX2;
	}

	public void setPalaX2(int palaX2) {
		this.palaX2 = palaX2;
	}

	public int getPalaY2() {
		return palaY2;
	}

	public void setPalaY2(int palaY2) {
		this.palaY2 = palaY2;
	}

	@Override
	public void init() {
		x = 0;
		y = 0;
		xMovement = -4;
		yMovement = 4;
	}

	
}
