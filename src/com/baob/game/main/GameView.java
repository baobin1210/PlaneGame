package com.baob.game.main;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author baobin
 * 主窗口
 */
public class GameView extends Frame{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIN_X = 500;
	public static final int WIN_Y = 500;

	/**
	 * 初始化窗口
	 */
	protected void lanchFrame(){
		this.setTitle("飞机游戏");
		this.setVisible(true);
		this.setSize(WIN_X,WIN_Y);
		this.setLocation(100,100);
		
		//添加关闭监听
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//双缓冲解决闪烁
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(GameView.WIN_X,GameView.WIN_Y);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}   

}
