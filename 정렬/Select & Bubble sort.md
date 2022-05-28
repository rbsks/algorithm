```java  
package com.bit.ex;  

/**
 * overloading을 줄이기위해서 varargs를 쓴다.
 * @author bitcamp
 *
 */  
public class VararagsTest {

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

}
```  
  - 선택정렬의 오름차순 결과    
  ![image](https://user-images.githubusercontent.com/67041069/87312294-54957c00-c55b-11ea-91e0-fd2aae48c76a.png)  
  - 선택정렬의 내림차순 결과  
  ![image](https://user-images.githubusercontent.com/67041069/87312408-7abb1c00-c55b-11ea-85e4-b8878608185c.png)  
  - 버블정렬의 오름차순 결과  
  ![image](https://user-images.githubusercontent.com/67041069/87312524-a2aa7f80-c55b-11ea-9787-121b8dd955fa.png)  
  - 버블정렬의 내림차순 결과  
  ![image](https://user-images.githubusercontent.com/67041069/87312565-b1913200-c55b-11ea-9f44-265ea002d333.png)  
  #### 정렬의 오름차순과 내림차순은 if(b[j] < b[j+1]) if문 안에 관계연산자 방향에 의해서 결정된다.  
      
      
