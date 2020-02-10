package com.baob.game.object;

import java.awt.Graphics;
import java.awt.Image;

import com.baob.game.util.PhotoUtil;

public class Explode {

	private double x , y;
	
	static Image[] images = new Image[16];
	static {
		for (int i = 0; i < images.length; i++) {
			images[i] = PhotoUtil.getImage("com/baob/images/explode/e"+(i+1)+".gif");
			images[i].getWidth(null);
		}
	}
	int count;
	
	public void draw(Graphics g) {
		if(count <= 15) {
			g.drawImage(images[count], (int)x,(int) y , null);
			count++;
		}
	}
	
	public Explode(double x , double y) {
		this.x = x;
		this.y = y;
	}
}
