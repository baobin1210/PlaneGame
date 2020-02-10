package com.baob.game.object;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.baob.game.main.GameObject;
import com.baob.game.main.GameView;

public class Plane extends GameObject{
	
	public static final int PLANE_WIDTH = 30;
	public static final int PLANE_HEIGHT = 30;
	
	public static final int PLANE_WIDTH_MOVE = 20;
	public static final int PLANE_HEIGHT_MOVE = 20;

	private boolean left,up,right,down;
	private boolean intersect = false;
	
	@Override
	public void drawSelf(Graphics g) {
		if(!intersect) {
			g.drawImage(super.getImg(), (int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(),null);
			
			if(left) {
				super.setX((super.getX() - super.getSpeed()) > 0 ? (super.getX() - super.getSpeed()) : 0 );
				super.setWidth(PLANE_WIDTH_MOVE);
			}else
			if(right) {
					super.setX((super.getX() + super.getSpeed()) <  (GameView.WIN_X - PLANE_WIDTH) ? 
									(super.getX() + super.getSpeed()) : (GameView.WIN_X - PLANE_WIDTH));
					super.setWidth(PLANE_WIDTH_MOVE);
			}else {
				super.setWidth(PLANE_WIDTH);
			}
			
			if(up) {
				super.setY((super.getY() - super.getSpeed()) > 30 ? (super.getY() - super.getSpeed()) : 30);
				super.setHeight(PLANE_HEIGHT_MOVE);
			}else
			if(down) {
				super.setY((super.getY() + super.getSpeed()) < (GameView.WIN_Y - PLANE_HEIGHT) ?
						(super.getY() + super.getSpeed()) :  (GameView.WIN_Y - PLANE_HEIGHT));
				super.setHeight(PLANE_HEIGHT_MOVE);
			}else {
				super.setHeight(PLANE_HEIGHT);
			}
		}
    }
	
	public Plane(String path, double x, double y, int speed) {
		super.setImg(path);
		super.setX(x);
		super.setY(y);
		super.setSpeed(speed);
		super.setWidth(Plane.PLANE_WIDTH);
		super.setHeight(Plane.PLANE_HEIGHT);
	}
	
	public void keyPress(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	public void keyRelease(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}

	public boolean isIntersect() {
		return intersect;
	}
	public void setIntersect(boolean intersect) {
		this.intersect = intersect;
	}
}