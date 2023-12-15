package com.other.io_nio.io_client_server.echo;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IOServer server = new IOServer();
		server.start();
	}

}
