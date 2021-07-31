package com.other.collection_null;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Collector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue = new LinkedList<>();
		queue.add(null);
		queue.add("A");
		
		Iterator<String> it = queue.iterator();
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
		
		Deque<String> deque = new LinkedList<>();
		deque.add(null);
		deque.add("B");
		
		Iterator<String> it2 = deque.iterator();
		
		while(it2.hasNext()) {
			
			System.out.println(it2.next());
		}
		
		ArrayDeque<String> arrDeque = new ArrayDeque<>();
		
		arrDeque.push(null);
		arrDeque.push("A");
		
		Iterator<String> it3 = arrDeque.iterator();
		
		while(it3.hasNext()) {
			
			System.out.println(it3.next());
		}
	}

}
