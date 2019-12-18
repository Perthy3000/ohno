package battle;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class HitAnimation extends AnimationTimer {
	GraphicsContext gContext;
	int posX;
	int posY;
	
	public HitAnimation(GraphicsContext gc, int posX, int posY) {
		gContext = gc;
		this.posX = posX;
		this.posY = posY;
	}
	
	final int WIDTH = 1024;
	final int HEIGHT = 1024;
	final int nWIDTH = WIDTH/8;
	final int nHEIGHT = HEIGHT/8;
	
	final Image hitImage = new Image(ClassLoader.getSystemResource("hit-yellow.png").toString(), WIDTH/2, 0, true, false);
	int frameNum = 0;
	int frameX;
	int frameY;
	int x = 0;
	int y = 0;
	boolean reverse = false;

	@Override
	public void handle(long currentNanoTime) {
		
		
		frameX = frameNum%4;
		frameY = frameNum/4;
		x = frameX*nWIDTH;
		y = frameY*nHEIGHT;
		
		if(frameNum > 15) this.stop();
		frameNum++;			
		
		gContext.clearRect(posX, posY, nWIDTH, nHEIGHT);
		gContext.drawImage(hitImage, x, y, nWIDTH, nHEIGHT, posX, posY, nWIDTH, nHEIGHT);
		
	}
}
