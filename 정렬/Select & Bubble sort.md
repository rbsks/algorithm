### 버블 정렬
   - 인접한 데이터를 비교하여 자리를 바꾸는 방식
   - 알고리즘 복잡도 O(n^2)
   ```java
   public static void bubbleSort(int[] arr, boolean orderBy) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (orderBy) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
   }
   ```
   
### 선택 정렬
   - 최소 또는 최대 값을 찾아서 가장 앞 또는 뒤부터 정렬하는 방식
   - 알고리즘 복잡도 O(n^2)
   ```java
   public static void selectionSort(int[] arr, boolean orderBy) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (orderBy) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                } else {
                    if (arr[j] > arr[min]) {
                        min = j;
                    }
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
   }
   ```
