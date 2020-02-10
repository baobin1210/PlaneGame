package com.baob.game.main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.baob.game.util.PhotoUtil;

/**
 * @author baobin
 * 游戏物体根类
 */
public class GameObject {

	private Image img;
	private double x,y;
	private int speed;
	private int width,height;
	
	/**
	 * @param g
	 * 显示
	 */
	public void drawSelf(Graphics g) {
		g.drawImage(img, (int)x, (int)y, width, height,null);
	}
	
	/**
	 * @return
	 * 返回矩形，碰撞测试
	 */
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,width,height);
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public GameObject(String path, double x, double y, int speed, int width, int height) {
		super();
		this.img = PhotoUtil.getImage(path);
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}


	public GameObject() {
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public void setImg(String path) {
		this.img = PhotoUtil.getImage(path);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}	
}
