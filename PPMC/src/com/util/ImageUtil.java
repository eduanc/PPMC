package com.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {
	public static Image loadImage(String imagePath) {
		//return Toolkit.getDefaultToolkit().getImage("img/" + imagePath);
		try {
			return ImageIO.read(new File("img/"+imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
