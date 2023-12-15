package com.other.simple_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getList(new ArrayList<>(Arrays.asList(1, 4, 7, 9))));
	}

	private static List<List<Integer>> getList(List<Integer> list) {
		if(list.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<List<Integer>> result = new ArrayList<>();
			for(int i = 0; i < list.size(); i++) {
				int first = list.get(i);
				result.add(Arrays.asList(first));
				List<Integer> sub = list.subList(i + 1, list.size());
				for(int j = 0; j < sub.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(first);
					tmp.add(sub.get(j));
					result.add(tmp);
				}
			}
			return result;
		}
	}
}
