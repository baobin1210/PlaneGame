package com.baob.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import com.baob.game.object.Explode;
import com.baob.game.object.Plane;
import com.baob.game.object.Shell;
import com.baob.game.util.PhotoUtil;

/**
 * @author baobin
 * 窗口绘制
 */
public class PaintView extends GameView{

	private static final long serialVersionUID = 1L;
	Image bg = PhotoUtil.getImage("com/baob/images/bg.jpg");
	Plane plane = new Plane("com/baob/images/plane2.jpg", 250, 250, 5 );
	Shell[] shells = new Shell[50];
	long startTime;
	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		Font f = g.getFont();
		
/*		g.setColor(Color.RED);
		g.drawLine(100, 100, 300, 300);
		g.setFont(new Font("宋体", Font.BOLD , 50));
		g.drawString("shabi", 100, 100);
		g.setColor(Color.BLUE);
		g.draw3DRect(100, 100, 100, 100, true);
		g.setColor(Color.YELLOW);
		g.drawOval(100, 100, 100, 100);*/
		
		g.drawImage(bg, 0, 0, WIN_X, WIN_Y, null);
		plane.drawSelf(g);
		g.setColor(Color.RED);
		g.drawString((String.format("%.2f", (double)(System.currentTimeMillis() - startTime)/1000))+" 秒", 460, 50);
		start = !plane.isIntersect(); //飞机消失后在停止线程
		for (int i = 0; i < shells.length; i++) {
			shells[i].drawSelf(g);
			if(shells[i].getRect().intersects(plane.getRect())) {//碰撞检测
				plane.setIntersect(true);
				Explode explode = new Explode(plane.getX()-plane.getWidth(),plane.getY()-plane.getHeight());
				explode.draw(g);
			}
		}
		
		g.setColor(c);
		g.setFont(f);
	}

	/**
	 * @author baobin
	 * 内部类，线程,repaint
	 */
	private boolean start = true;
	class PaintThread extends Thread{
		@Override
		public void run() {
			while(start) {
				repaint();
				try {
					Thread.sleep(40); //1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
		
	@Override
	protected void lanchFrame() {
		super.lanchFrame();
		new PaintThread().start();//启动重画窗口的线程
		this.addKeyListener(new KeyMonitor()); //添加键盘监听
		double x = (GameView.WIN_X-100)*Math.random()+50;
		double y = (GameView.WIN_Y-100)*Math.random()+50;
		for (int i = 0; i < shells.length; i++) { //初始化
			shells[i] = new Shell(x,y);
		}
		startTime =  System.currentTimeMillis();
	}

	/**
	 * @author baobin
	 * 键盘按下抬起事件
	 */
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				main(null);
			}
			plane.keyPress(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			plane.keyRelease(e);
		}
	}

	public static void main(String[] args) {
		PaintView view= new PaintView();
		view.lanchFrame();
	}
}
