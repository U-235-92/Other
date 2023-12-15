package com.other.exernalizable_example;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExernalizeObject implements Externalizable {

	public final int VALUE = 5;
	public final String STRING_FIELD;
	private static int st = 999;
	
	transient private String name;
	
	public ExernalizeObject() {
		name = "Default Name";
		STRING_FIELD = "Default String";
	}

	public ExernalizeObject(String name) {
		this.name = name;
		STRING_FIELD = "Java";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);
//		out.writeInt(st);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
//		st = in.readInt();
	}

	@Override
	public String toString() {
		return "ExernalizeObject [VALUE=" + VALUE + ", STRING_FIELD=" + STRING_FIELD + ", name=" + name + "]" + st;
	}
}
