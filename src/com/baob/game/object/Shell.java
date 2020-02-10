package com.baob.game.object;

import java.awt.Color;
import java.awt.Graphics;

import com.baob.game.main.GameObject;
import com.baob.game.main.GameView;

public class Shell extends GameObject{
	
	private double degree;

	@Override
	public void drawSelf(Graphics g) {
		Color c = g.getColor();
		
		g.setColor(Color.YELLOW);
		g.fillOval((int)super.getX(), (int)super.getY(), super.getHeight(), super.getWidth());
		
		super.setX(super.getX()+Math.cos(degree)*super.getSpeed());
		super.setY(super.getY()+Math.sin(degree)*super.getSpeed());
		
		if(super.getX()<0 || super.getX() > GameView.WIN_X - 10) {
			degree = Math.PI - degree;
		}
		if(super.getY() < 30 || super.getY() > GameView.WIN_Y - 10) {
			degree = -degree;
		}
		
		g.setColor(c);
	}
	
	public Shell(double x , double y) {
		super.setX(x);
		super.setY(y);
		super.setHeight(10);
		super.setWidth(10);	
		super.setSpeed(3);	
		degree = Math.random()*Math.PI*2;
	}
	
	

	
}
