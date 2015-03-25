package com.element;

import static com.util.PropertyUtil.getIntProperty;

public class Background extends GenericElement {

	public Background() {
		super(0, 0, "background.png");
		setY((getIntProperty("window_height") - getHeight()) / 2);
		setX((getIntProperty("window_width") - getWidth()) / 2);
	}
	
	@Override
	public void setX(int x) {
		if (x > 0 - getWidth() + getIntProperty("window_width") && x < 0) {
			super.setX(x);
		}
	}
	
	@Override
	public void setY(int y) {
		if (y > 0 - getHeight() + getIntProperty("window_height") && y < 0) {
			super.setY(y);
		}
	}
	
	public void moveX(int distance) {
		setX(getX() + distance);
	}
	
	public void moveY(int distance) {
		setY(getY() + distance);
	}

}
