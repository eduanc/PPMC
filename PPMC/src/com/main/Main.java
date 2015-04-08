package com.main;

import static com.util.PropertyUtil.getIntProperty;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import com.context.Context;
import com.listener.KeyL;

public class Main extends Applet implements Runnable {

	private static final long serialVersionUID = 1L;

	// variáveis para Double Buffering
	private Image i;
	private Graphics doubleG;

	@Override
	public void init() {
		super.init();

		setSize(getIntProperty("window_width"), getIntProperty("window_height"));
		addKeyListener(new KeyL());
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		super.stop();
	}

	@Override
	public void update(Graphics g) {
		// Double Buffering
		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}

		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);

		doubleG.setColor(getForeground());
		paint(doubleG);

		g.drawImage(i, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Context.getInstance().paintElements(g2d);
	}

	@Override
	public void run() {
		while (true) {
			repaint();

			try {
				Thread.sleep(24);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}