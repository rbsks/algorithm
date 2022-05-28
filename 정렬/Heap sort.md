``` java  
package com.bit.arl;

public class Heap {

	private static int[] data;
	private static int number = 10;

	// 트리구조를 최대 힙구조로 바꾸는 메소드
	// 부모가 자식보다 값이 작을 경우 한마디로 최대 힙이 생성되지 않았을경우 자리를 바꿔줌으로서 최대힙을 만들어준다. 왜냐면 최대 힙이 생성되지 않았을 경우 그 자식중에서 큰값과 자기 자신을 바꿔준다.
	public static void heap(int[] data, int number) {
		for (int i = 1; i < number; i++) {
			int child = i;
			while (child > 0) {
				int parent = (child - 1) / 2; // 부모
				if (data[child] > data[parent]) {
					int temp = data[parent];
					data[parent] = data[child];
					data[child] = temp;
				}
				child = parent;
			}
		}
	}

	public static void main(String[] args) {
		data = new int[number];
		for (int i = 0; i < number; i++) {
			data[i] = (int) (Math.random() * 100);
		}

		System.out.print("정렬 전 : ");
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}

		heap(data, number);

		for (int i = number - 1; i > 0; i--) {
			// 인덱스 번호를 내려가면서 실행
			// 가장 큰 값을 맨 뒤로 보내고 
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			// 다시 힙구조를 만들고
			heap(data, i);
			
			// 이것을 반복
		}

		System.out.print("\n정렬 후 : ");
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}

	}

}
```  
