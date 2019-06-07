package sort;


// TODO re-factoring write beautiful code.
public class HeapSort {
	public static void main(String[] args) {
		int arr[] = {10, 8, 3 , 6 , 4, 5};
		
		HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);
	}
	
	public void sort(int arr[]) {
		int n = arr.length;
		
		for (int i = n/2; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		int temp;
		for (int i = 0; i < n; i++) {
			// Swap element
			temp = arr[0];
			arr[0] = arr[n - i - 1];
			arr[n - i - 1] = temp;
			
			heapify(arr, n - i - 1, 0);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public void heapify(int arr[], int len, int index) {
		int left = 2*index + 1;
		int right = 2*index + 2;
		
		int largest = index;
		
		
		if (left < len && arr[left] > arr[index]) {
			largest = left;
		} 
		
		if (right < len && arr[right] > arr[largest]) {
			largest = right;
		}
		
		int temp;
		if (largest != index) {
			temp = arr[largest];

			arr[largest] = arr[index];
			arr[index] = temp;
			
			heapify(arr, len, largest);
		}
	}
}
