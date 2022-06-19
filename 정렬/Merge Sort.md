### 합병 정렬
   - 배열을 계속 분할해서 길이가 1이 되도록 만들고 인접한 부분끼리 정렬하면서 합병하는 방식
   - 알고리즘 복잡도 O(nlogn)
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
