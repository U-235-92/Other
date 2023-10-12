package com.other.network.udp.msg.server;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPEchoMessageServerMain {

	public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
		UDPEchoMessageServer server = new UDPEchoMessageServer();
		server.listenMessage();
	}

}
