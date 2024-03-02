package com.other.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(Main.class.getName());
		logger.setLevel(Level.FINE);
		logger.warning("++++WARNING++++");
		logger.info("++++INFO++++");
		logger.finer("++++FINER++++");
	}

}
