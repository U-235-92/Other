package com.other.swing;

import java.util.EventObject;

public class ButtonPressEvent extends EventObject {
	
	/**
	 * в данном классе хранится информация о произошедшем событии
	 */
	private static final long serialVersionUID = 5287277078309194722L;

	public ButtonPressEvent(Object source) {
		
		super(source);
	}

}
