package com.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import com.context.Context;
import com.element.Player;

public class KeyL implements KeyListener {

	Context context = Context.getInstance();
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		/*switch (e.getKeyChar()) {
		case 'a':
			context.getPlayer().move(Player.MOVE_LEFT);
			break;
		case 's':
			context.getPlayer().move(Player.MOVE_DOWN);
			break;
		case 'd':
			context.getPlayer().move(Player.MOVE_RIGHT);
			break;
		case 'w':
			context.getPlayer().move(Player.MOVE_UP);
			break;
		}*/
	}

	@Override
    public synchronized void keyPressed(KeyEvent e) {
        context.getPressed().add(e.getKeyChar());
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
    	context.getPressed().remove(e.getKeyChar());
    }

	

}
