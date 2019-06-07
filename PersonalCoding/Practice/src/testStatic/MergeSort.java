package testStatic;

import java.util.Arrays;

class MergeSort {
	public static void main(String args[] ) {
		int arr[] = {8, 9 ,10, 2, 6 ,7, 9};
		
		divide(arr, 0, arr.length - 1);
		
		Arrays.stream(arr).forEach(i -> System.out.println(i) );
		
	}
	
	public static void divide(int arr[], int m, int n) {
		
		if (m < n) {
			int p = (m + n)/2;
			
			divide(arr, m, p);
			divide(arr, p+1, n);
			
			merge(arr, m,  p, n);
		}
	}
	
	public static void merge(int arr[], int m, int p, int n) {
		int i = m;
		int j = p + 1;
		
		int left[] = new int[p - m + 1];
		int right[] = new int[n - p];
		
		int k = 0;
		while (i <= p) {
			left[k++] = arr[i++];
		}
		
		k = 0;
		while (j <= n) {
			right[k++] = arr[j++];
		}
		
		i = 0;
		j = 0;
		k = m;
		
		while (k <= n) {
			if (left[i] < right[j]) {
				arr[k] = left[i++];
			} else {
				arr[k] = right[j++];
			}
			
			k++;
			
			if (i >= left.length || j >= right.length) {
				break;
			}	
		}
		
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		
		while (j < right.length) {
			arr[k++] = right[j++];
		}
	} 
}