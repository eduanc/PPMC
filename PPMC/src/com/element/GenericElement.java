package com.element;

import static com.util.ImageUtil.loadImage;

import java.awt.Graphics2D;
import java.awt.Image;

public class GenericElement {

	private int width;
	private int height;
	private int x;
	private int y;
	private Image image;
		
	public GenericElement(int x, int y, String imagePath) {
		super();
		this.x = x;
		this.y = y;
		setImage(loadImage(imagePath));
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(image, x, y, width, height, null);
	}
}