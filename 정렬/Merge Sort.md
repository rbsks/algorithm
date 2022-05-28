```java  
package Sort_hw;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 2, 5, 7, 6, 12, 17, 3 };
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	
	
	public static void mergeSort(int[] a, int low, int high) { 
		if (low < high) {	
			int middle = low + (high - low) / 2;	
			mergeSort(a, low, middle);	
			mergeSort(a, middle + 1, high);	
			merge(a, low, middle, high);	
		}
	}

	
	
	public static void merge(int[] a, int low, int middle, int high) {
		int[] sorted = new int[a.length];	
		
		for (int i = low; i <= high; i++) {	
			sorted[i] = a[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {	
			if (sorted[i] <= sorted[j]) {
				a[k] = sorted[i];
				i++;
			} else {
				a[k] = sorted[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) {
			a[k] = sorted[i];
			k++;
			i++;
		}
	}

}

```
