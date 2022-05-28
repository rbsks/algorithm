```java  
package Sort_hw;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = { 2, 12, 7, 6, 5, 17, 3 };
		insertSort(true, a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void insertSort(boolean isAscending, int... num) {
		int temp;
		if (isAscending) {	
			for (int i = 0; i < num.length - 1; i++) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[i] > num[j]) {	
						temp = num[i];	
						num[i] = num[j];	
						num[j] = temp;	
					}
				}
			}
		} else {	
			for (int i = 0; i < num.length - 1; i++) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[i] < num[j]) {
						temp = num[i];
						num[i] = num[j];
						num[j] = temp;
					}
				}
			}
		}
	}
}

```  
