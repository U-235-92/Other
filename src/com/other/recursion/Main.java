package com.other.recursion;

public class Main {

	private static void rev(int[] nums, int index) {
		if(index >= nums.length) {
			return;
		} else {
			rev(nums, ++index);
			System.out.println(nums[index - 1]);
		}
	}
	
	public static void main(String[] args) {
		rev(new int[] {1, 2, 3, 4, 5}, 0);
	}
}
