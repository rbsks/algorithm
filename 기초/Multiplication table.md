``` java  
package com.bit.arl;

public class gogodan {

	public static void main(String[] args) {
		// 2열씩 출력하는 구구단  
		for(int i = 2; i < 10; i+=2) {
			System.out.println(i+"단\t"+ (i+1) +"단\t");
			for(int j = 1; j < 10; j++) {
				for(int k = i; k < i+2; k++) {
					System.out.print(k+"*"+j+"="+k*j+"\t");
				}
				System.out.println();
			}
			System.out.println();

		}  
		
		
		int startDan = 2;
		int endDan = 9;
		int row = 4;
		// 가변적으로 열을 출력할 수 
		for(int i = startDan; i < endDan; i+=row) {
			//System.out.println(i+"단\t"+ (i+1) +"단\t");
			for(int j = 1; j < 10; j++) {
				for(int k = i; k < i+row; k++) {
					if(k < 10) {
					System.out.print(k+"*"+j+"="+k*j+"\t");
					
					}else {
						break;
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
}
```  
![image](https://user-images.githubusercontent.com/67041069/87432143-90dfdf80-c622-11ea-9980-8ae74e32eef1.png)   ![image](https://user-images.githubusercontent.com/67041069/87505806-c2998a80-c6a4-11ea-9d9f-465940a9c261.png)

