package com.other.stream;

import java.math.BigInteger;
import java.util.stream.Stream;

public class InfinityStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream.iterate(new BigInteger("0"), n -> n.add(new BigInteger("1000000"))).forEach(System.out::println);
	}

}
