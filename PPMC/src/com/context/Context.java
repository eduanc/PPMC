package com.context;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.element.Background;
import com.element.GenericElement;
import com.element.Player;

public class Context {
	private List<GenericElement> printElements;
	
	private Player player;
	private Background background;

	private static Context staticInstance;
	
	private final Set<Character> pressed = new HashSet<Character>();
	public Set<Character> getPressed() {
		return pressed;
	}

	public static Context getInstance() {
		if (staticInstance == null) {
			staticInstance = new Context();
		}

		return staticInstance;
	}

	public Context() {
		this.printElements = new ArrayList<GenericElement>();
		this.printElements.add(this.background = new Background());
		this.printElements.add(this.player = new Player());
	}

	public void paintElements(Graphics2D g) {
		
		player.upd8();
		
		for(GenericElement element : printElements) {
			element.paint(g);
		}
	}

	public Background getBackground() {
		return background;
	}

	public Player getPlayer() {
		return player;
	}
}