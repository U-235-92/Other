package com.other.network.udp.msg.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class UDPEchoMessageClient {

	private static final int SERVER_PORT = 5082;
	private static final int CLIENT_PORT = 8250;

	private DatagramPacket datagramPacket;
	private DatagramSocket datagramSocket;
	private InetAddress inetAddress;

	public UDPEchoMessageClient() throws SocketException, UnknownHostException {
		super();
		datagramSocket = new DatagramSocket(CLIENT_PORT);
		inetAddress = InetAddress.getLocalHost();
	}

	public void messageProcess() throws IOException {
		System.out.println("[Client started]\nEnter a message:");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String message = scanner.nextLine();
			switch (message) {
			case "-1": {
				datagramPacket = new DatagramPacket(message.getBytes(), message.getBytes().length, inetAddress, SERVER_PORT);
				datagramSocket.send(datagramPacket);
				System.out.println("Client off");
				scanner.close();
				return;
			}
			default:
				byte[] buff = new byte[256];
				try (ByteArrayInputStream bais = new ByteArrayInputStream(message.getBytes())) {
					while (bais.read(buff) != -1) {
						datagramPacket = new DatagramPacket(buff, buff.length, inetAddress, SERVER_PORT);
						datagramSocket.send(datagramPacket);
						Arrays.fill(buff, (byte) 0);
					}
				}
				datagramSocket.receive(datagramPacket);
				System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getData().length));
			}
		}
	}
}
