package com.other.exernalizable_example;

import java.io.Serializable;

public class SerializeObject implements Serializable {

	public final int VALUE = 5;
	public final String STRING_FIELD;
	private static int st = 999;
	public SerializeObject(String sTRING_FIELD) {
		STRING_FIELD = "Ser";
	}
	@Override
	public String toString() {
		return "SerializeObject [VALUE=" + VALUE + ", STRING_FIELD=" + STRING_FIELD + "]"+st;
	}
	
	
}
