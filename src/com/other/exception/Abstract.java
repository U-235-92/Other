package com.other.exception;

public abstract class Abstract {

	public abstract void event() throws StormExcwption;
	
	public Abstract() throws StormExcwption {
		
		
	}
	
	public Abstract(int p) {}
	
	public void storm() throws StormExcwption {
		
		throw new StormExcwption();
	}
	
	public void rain() throws RainException {
		
		throw new RainException();
	}
}
