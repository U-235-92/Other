package com.other.io_nio.nio_client_server.better_version;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NIOClient {

	private static final String HOST = "localhost";
	private static final int PORT = 5082;
	private static final int BUFFER_SIZE = 256;
	private SocketChannel socketChannel;
	private InetSocketAddress connectionAddress;
	private Selector selector;
	private ByteBuffer buff;
	
	public NIOClient() {
		connectionAddress = new InetSocketAddress(HOST, PORT);
		try {
			socketChannel = SocketChannel.open(connectionAddress);
			socketChannel.configureBlocking(false);
			selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_WRITE);
		} catch (ClosedChannelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buff = ByteBuffer.allocate(BUFFER_SIZE);		
	}
	
	public void start() {
		listenToConsole();
		while(true) {
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			iterator.forEachRemaining(key -> {
				iterator.remove();
			});
		}
	}

	private void listenToConsole() {
		Thread thread = new Thread(() -> {
			while(true) {				
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please, write a message:");
				String msg = scanner.nextLine();
				buff.put(msg.getBytes());
				buff.flip();
				int bytesWritten = 0;
				try {
					bytesWritten = socketChannel.write(buff);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(bytesWritten == msg.getBytes().length) {
					System.out.println("[Written a full message]: " + msg);
					buff.clear();
				} else {
					System.out.println("[Written a partial message]: " + msg);
					buff.compact();
				}
			}
		});
		thread.start();
	}
}
