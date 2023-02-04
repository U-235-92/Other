package com.other.exernalizable_example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExernalizeObject exernalizeOutObject = new ExernalizeObject("Lime");
		System.out.println(exernalizeOutObject);
		writeObject(exernalizeOutObject);
		ExernalizeObject exernalizeInObject = readObject();
		System.out.println(exernalizeInObject);
		
//		SerializeObject exernalizeOutObject = new SerializeObject("Lime");
//		System.out.println(exernalizeOutObject);
//		byte[] object = writeObject(exernalizeOutObject);
//		SerializeObject exernalizeInObject = readObject2(object);
//		System.out.println(exernalizeInObject);
	}
	
	private static void writeObject(ExernalizeObject exernalizeObject) {
		try(FileOutputStream baos = new FileOutputStream("src\\com\\other\\exernalizable_example\\object.ser");
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(exernalizeObject);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ExernalizeObject readObject() {
		ExernalizeObject exernalizeObject;
		try(FileInputStream bais = new FileInputStream("src\\com\\other\\exernalizable_example\\object.ser");
				ObjectInputStream ois = new ObjectInputStream(bais)) {
			exernalizeObject = (ExernalizeObject) ois.readObject();
			return exernalizeObject;
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static byte[] writeObject(SerializeObject exernalizeObject) {
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(exernalizeObject);
			return baos.toByteArray();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static SerializeObject readObject2(byte[] object) {
		SerializeObject exernalizeObject;
		try(ByteArrayInputStream bais = new ByteArrayInputStream(object);
				ObjectInputStream ois = new ObjectInputStream(bais)) {
			exernalizeObject = (SerializeObject) ois.readObject();
			return exernalizeObject;
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
