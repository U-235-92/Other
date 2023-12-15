package com.other.sort;

public class Sort {
	
	public void sort(int[] arr) {
		
		sort(arr, 0, arr.length - 1);
	}
	
	private void sort(int[] arr, int left, int right) {
		
		int i = left, j = right;
		int p = (i + j) / 2;
		int mid = arr[p];
		
		while(i <= j) {
			
			while(arr[i] < mid) {
				
				i++;
			}
			while(arr[j] > mid) {
				
				j--;
			}
			
			if(i <= j) {
				
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++; j--;
			}
		}
		
		if(i < right) {
			
			sort(arr, i, right);
		}
		
		if(j > left) {
			
			sort(arr, left, j);
		}
	}
}
