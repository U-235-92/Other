package com.other.json_test.simple_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainSimpleJSON {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("https://github.com/U-235-92");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			String inputLine = "";
			while((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
		}
	}

}
