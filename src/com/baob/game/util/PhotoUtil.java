package com.baob.game.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class PhotoUtil {

	/**
	 * 工具类最好将构造器私有化
	 */
	private PhotoUtil() {
		
	}
	
	/**
	 * @param path
	 * @return
	 * @throws IOException
	 * 制定路径的图片家在
	 */
	public static Image getImage(String path){		
		BufferedImage bi = null;
		URL u = PhotoUtil.class.getClassLoader().getResource(path);
		try {
			bi = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
