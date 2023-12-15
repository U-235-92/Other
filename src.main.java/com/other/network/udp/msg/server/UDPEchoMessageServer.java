package com.other.network.udp.msg.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class UDPEchoMessageServer {

	private static final int SERVER_PORT = 5082;
	private static final int BUFF_SIZE = 256;

	private DatagramPacket datagramPacketIn;
	private DatagramSocket datagramSocket;
	private byte[] buff;
	
	public UDPEchoMessageServer() throws SocketException, UnknownHostException {
		super();
		buff = new byte[BUFF_SIZE];
		datagramSocket = new DatagramSocket(SERVER_PORT);
		datagramPacketIn = new DatagramPacket(buff, BUFF_SIZE);
	}
	
	public void listenMessage() {
		System.out.println("[Server started and is waiting for messages...]");
		while(true) {
			try {
				datagramSocket.receive(datagramPacketIn);
				if("-1".equals(new String(datagramPacketIn.getData(), 0, datagramPacketIn.getData().length).trim())) {
					break;
				}
				String echo = "[Echo]: " + new String(datagramPacketIn.getData());
				DatagramPacket datagramPacketOut = new DatagramPacket(echo.getBytes(), echo.getBytes().length, datagramPacketIn.getAddress(), datagramPacketIn.getPort());
				datagramSocket.send(datagramPacketOut);
				Arrays.fill(buff, (byte) 0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[Server turn off]");
	}
}
