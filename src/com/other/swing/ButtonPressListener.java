package com.other.swing;

import java.util.EventListener;

public interface ButtonPressListener extends EventListener {
	
	/*
	 * —юда приходит информаци€ о событии и данный(ые) метод(ы) вызываетс€ при наступлении событи€
	 */

	public void buttonPressed(ButtonPressEvent e);
}
