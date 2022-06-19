### 삽입 정렬
   - 앞의 데이터를 정렬 해가면서 삽입 위치를 찾아 정렬하는 방식
   - 알고리즘 복잡도 O(N^2)
   ```java
   public static void insertionSort(int[] arr, boolean orderBy) {
	for (int i = 1; i < arr.length; i++) {
	    for (int j = i; j > 0; j--) {
		if (orderBy) {
		    if (arr[j] < arr[j - 1]) {
			int temp = arr[j];
			arr[j] = arr[j - 1];
			arr[j - 1] = temp;
		    } else {
			break; // 앞의 데이터들은 이미 정렬이 되있으므로 if에 걸리지 않으면 더이상 비교할 필요가 없으므로 break로 빠져 나감
		    }
		} else {
		    if (arr[j] > arr[j - 1]) {
			int temp = arr[j];
			arr[j] = arr[j - 1];
			arr[j - 1] = temp;
		    } else {
			break; // 앞의 데이터들은 이미 정렬이 되있으므로 if에 걸리지 않으면 더이상 비교할 필요가 없으므로 break로 빠져 나감
		    }
		}
	    }
	}
   }
   ```
