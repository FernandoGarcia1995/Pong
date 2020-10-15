package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class MapObject {
	
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void init();
}
