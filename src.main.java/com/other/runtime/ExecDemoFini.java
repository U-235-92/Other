package com.other.runtime;

public class ExecDemoFini {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			p = r.exec("Notepad");
		}  catch(Exception e) {
			e.printStackTrace();
		}
	}

}
