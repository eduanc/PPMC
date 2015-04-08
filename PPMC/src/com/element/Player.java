package com.element;

import static com.util.PropertyUtil.getIntProperty;

import java.awt.Image;

import com.context.Context;
import com.util.ImageUtil;

public class Player extends GenericElement {
	
	public static final int MOVE_UP = 0;
	public static final int MOVE_LEFT = 1;
	public static final int MOVE_RIGHT = 2;
	public static final int MOVE_DOWN = 3;
	
	private final int movementLenght = 5;
	private final int borderLenght = 20;
	
	private int imageIndex = 0;
	
	Image[] imgL = new Image[] {
			ImageUtil.loadImage("pl0.png"),
			ImageUtil.loadImage("pl0.png"),
			ImageUtil.loadImage("pl0.png"),
			ImageUtil.loadImage("pl1.png"),
			ImageUtil.loadImage("pl1.png"),
			ImageUtil.loadImage("pl1.png"),
			ImageUtil.loadImage("pl2.png"),
			ImageUtil.loadImage("pl2.png"),
			ImageUtil.loadImage("pl2.png")
	};
	
	Image[] imgR = new Image[] {
			ImageUtil.loadImage("pr0.png"),
			ImageUtil.loadImage("pr0.png"),
			ImageUtil.loadImage("pr0.png"),
			ImageUtil.loadImage("pr1.png"),
			ImageUtil.loadImage("pr1.png"),
			ImageUtil.loadImage("pr1.png"),
			ImageUtil.loadImage("pr2.png"),
			ImageUtil.loadImage("pr2.png"),
			ImageUtil.loadImage("pr2.png")
	};
	
	Image[] imgU = new Image[] {
			ImageUtil.loadImage("pu0.png"),
			ImageUtil.loadImage("pu0.png"),
			ImageUtil.loadImage("pu0.png"),
			ImageUtil.loadImage("pu1.png"),
			ImageUtil.loadImage("pu1.png"),
			ImageUtil.loadImage("pu1.png"),
			ImageUtil.loadImage("pu2.png"),
			ImageUtil.loadImage("pu2.png"),
			ImageUtil.loadImage("pu2.png")
	};
	
	Image[] imgD = new Image[] {
			ImageUtil.loadImage("pd0.png"),
			ImageUtil.loadImage("pd0.png"),
			ImageUtil.loadImage("pd0.png"),
			ImageUtil.loadImage("pd1.png"),
			ImageUtil.loadImage("pd1.png"),
			ImageUtil.loadImage("pd1.png"),
			ImageUtil.loadImage("pd2.png"),
			ImageUtil.loadImage("pd2.png"),
			ImageUtil.loadImage("pd2.png")
	};
	

	public Player() {
		super(getIntProperty("window_width") / 2, getIntProperty("window_height") / 2, "pd0.png");
	}
	
	public void move(int direction) {
		updateImageIndex();
		
		switch(direction) {
		case MOVE_UP:
			
			setImage(imgU[imageIndex]);
			
			if (getY() < borderLenght) {
				Context.getInstance().getBackground().moveY(movementLenght);
			} else {
				setY(getY()-movementLenght);
			}
			break;
		case MOVE_LEFT:
			
			setImage(imgL[imageIndex]);
			
			if (getX() < borderLenght) {
				Context.getInstance().getBackground().moveX(movementLenght);
			} else {
				setX(getX()-movementLenght);
			}
			break;
		case MOVE_RIGHT:
			
			setImage(imgR[imageIndex]);
			
			if (getX() > getIntProperty("window_width") - borderLenght - getWidth()) {
				Context.getInstance().getBackground().moveX( - movementLenght);
			} else {
				setX(getX()+movementLenght);
			}
			break;
		case MOVE_DOWN:
			
			setImage(imgD[imageIndex]);
			
			if (getY() > getIntProperty("window_height") - borderLenght - getHeight()) {
				Context.getInstance().getBackground().moveY( - movementLenght);
			} else {
				setY(getY()+movementLenght);
			}
			break;
		}
	}
	
	private void updateImageIndex() {
		imageIndex++;
		if (imageIndex >= imgL.length) {
			imageIndex = 0;
		}
	}
	
	public void upd8() {
		if (Context.getInstance().getPressed().contains('a')) {
			move(MOVE_LEFT);
		}
		
		if (Context.getInstance().getPressed().contains('w')) {
			move(MOVE_UP);
		}
		
		if (Context.getInstance().getPressed().contains('s')) {
			move(MOVE_DOWN);
		}
		
		if (Context.getInstance().getPressed().contains('d')) {
			move(MOVE_RIGHT);
		}
	}
}