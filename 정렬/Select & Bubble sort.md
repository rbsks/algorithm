### 버블 정렬
   - 인접한 데이터를 비교하여 자리를 바꾸는 방식
   - 알고리즘 복잡도 O(n^2)
   ```java
    // Ascending bubble sort
    public void AsbubbleSort(int ...b) {
        int size = b.length;
        for(int i=size-1; i>0; i--) {
            System.out.printf("\n버블 정렬 %d 단계 : ", size-i);
            for(int j=0; j<i; j++) {
                if(b[j] > b[j+1]) { // 오름차순
                    int temp = b[j];
        	    b[j] = b[j+1];
        	    b[j+1] = temp;
                 }
                System.out.printf("\n\t");
                for(int v : b) {
                    System.out.printf("%3d ", v);
                }
             }            
          }
          System.out.println();
    }
    
    // Descending bubble sort
    public void DebubbleSort(int ...b) {
        int size = b.length;
        for(int i=size-1; i>0; i--) {
            System.out.printf("\n버블 정렬 %d 단계 : ", size-i);
            for(int j=0; j<i; j++) {
                if(b[j] < b[j+1]) { // 내림차순
                    int temp = b[j];
        	    b[j] = b[j+1];
        	    b[j+1] = temp;
                }
                System.out.printf("\n\t");
                for(int v : b) {
                    System.out.printf("%3d ", v);
                }
             }            
        }
        System.out.println();
    }
   ```
   
### 선택 정렬
   - 최소 또는 최대 값을 찾아서 가장 앞 또는 뒤부터 정렬하는 방식
   - 알고리즘 복잡도 O(n^2)
   ```java
   // Ascending select sort
   public void AsselectionSort(int ...a) {
        
        for(int i=0; i<a.length-1; i++) {
            int min = i;
            for(int j=i+1; j<a.length; j++) { 
                if(a[j] < a[min]) { // 오름차순 
                    min = j;
                }
            }
            int temp = a[min];
	    a[min] = a[i];
	    a[i] = temp;
            System.out.printf("\n선택 정렬 %d 단계 : ", i+1);
            for(int v : a) {
                System.out.printf("%3d ", v);
            }         
        }
        System.out.println();
    }
	
    // Descending select sort
    public void DeselectionSort(int ...a) {
	        
	 for(int i=0; i<a.length-1; i++) {
	     int min = i;
	     for(int j=i+1; j<a.length; j++) { 
	         if(a[j] > a[min]) { // 내림차순 
	                    min = j;
	         }
	     }
             int temp = a[min];
	     a[min] = a[i];
	     a[i] = temp;
	     System.out.printf("\n선택 정렬 %d 단계 : ", i+1);
             for(int v : a) {
                 System.out.printf("%3d ", v);
             }         
	  }
	  System.out.println();
      }
	
    
	
    public static void main(String[] args) {
        VararagsTest test = new VararagsTest();
        System.out.println("=====[오름선택정렬]=====");
        test.AsselectionSort(50,60,80,11,123,455,124,1411,13);
        System.out.println();
	System.out.println("=====[내림선택정렬]=====");
	test.DeselectionSort(50,60,80,11,123,455,124,1411,13);
		
	System.out.println();
	System.out.println("=====[오름버블정렬]=====");
	test.AsbubbleSort(50,60,80,11,123,455,124,1411,13);
        System.out.println();
        System.out.println("=====[내림버블정렬]=====");
	test.DebubbleSort(50,60,80,11,123,455,124,1411,13);    
		
		
     }
   ```
