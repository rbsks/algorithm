``` java  
package com.bit.arl;

public class Quick {
	
	public static void quickSort(int[]A,int p, int r) {
		if(p<r) {
			int q = partition(A,p,r);  // q = pivot의 위치 
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}else {
			return;
		}
	}
	
	public static int partition(int[]A, int p , int r) {
		int i = p-1;
		int x = A[r];
		int tmp;
		for (int j = p; j < r ; j++) {
			if(A[j]<=x) {
				i++;
				tmp = A[i];
				A[i]=A[j];
				A[j]=tmp;

			}
		}
		tmp = A[i+1];
		A[i+1] = A[r];
		A[r]=tmp;
		return i+1;
	}
	
	public static void main(String[] args) {
		int A[]= {67,3,14,5,19,77,33};
		quickSort(A, 0, 6);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]+",");
		}

	}

}
```  
