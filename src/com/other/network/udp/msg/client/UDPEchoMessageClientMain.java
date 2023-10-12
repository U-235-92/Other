package com.other.network.udp.msg.client;

import java.io.IOException;

public class UDPEchoMessageClientMain {

	public static void main(String[] args) throws IOException {
		UDPEchoMessageClient client = new UDPEchoMessageClient();
		client.messageProcess();
	}

}
