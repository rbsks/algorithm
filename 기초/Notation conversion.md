#### 10진 -> 2, 8, 16진 
``` java  
package com.bit.conv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CardinalConversion {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.print("수를 입력하세요  > ");
        int quotient = Integer.parseInt(br.readLine()); // 주어지는 수이자 나중에는 몫
        System.out.print("진법을 입력하세요 > ");
        int cardinalNum = Integer.parseInt(br.readLine()); // 변환하고자 하는 진법
        String character = "0123456789ABCDEF"; // 나머지 값에 따라서 charAt으로 값을 뽑아서 ArrayList로 저장하기 위한 것
        ArrayList<Character> output = new ArrayList<>();

        while(quotient != 0) {
            output.add(character.charAt(quotient%cardinalNum)); // 나머지를 저장하고 String character에서 나머지 숫자에 맞응 위치에 값을 하나씩 꺼내서 ArrayList에 저장
            quotient /= cardinalNum;
        }
        
        Collections.reverse(output); // 가장 마지에 저장한 것이 먼저 나와야하기 때문에 거꾸로 출력
        
        bw.write("[");
        for(Character convertedNum : output) {
            bw.write(convertedNum);
        }
        bw.write("]");
        
        bw.flush();
        
    }
 
}
```  
#### 결과  
![image](https://user-images.githubusercontent.com/67041069/87869901-85a00180-c9de-11ea-83c7-d63a6ae8522a.png)  ![image](https://user-images.githubusercontent.com/67041069/87869905-8cc70f80-c9de-11ea-9aa0-8a84f3b450f5.png)  ![image](https://user-images.githubusercontent.com/67041069/87870033-58a01e80-c9df-11ea-956b-cc317e49d175.png)  ![image](https://user-images.githubusercontent.com/67041069/87870020-40c89a80-c9df-11ea-9f61-96e84cd0c367.png)

#### 2, 8, 16진 -> 10진 
``` java  
package com.bit.conv;

public class Test {

	// 2진 -> 10진
	public static int binaryToDacemal(String num) {
		int result = 0;
		int count = 0;
		int pow = 0;
		for (int i = num.length(); i >= 0; i--) {
			if (i == 0) {
				break;
			}
			pow = (int) Math.pow(2, count);
			result += pow * (num.charAt(i-1) -'0');
			count++;
		}
		return result;
	}
	
	// 8진 -> 10진
	public static int octToDacemal(String num) {
		int result = 0;
		int count = 0;
		int pow = 0;
		for (int i = num.length(); i >= 0; i--) {
			if (i == 0) {
				break;
			}
			pow = (int) Math.pow(8, count);
			result += pow * (num.charAt(i-1) -'0');
			count++;
		}
		return result;
	}
	
	// 16진 ->10진
	public static int hexToDacemal(String num) {
		int result = 0;
		int count = 0;
		int pow = 0;
		
		for (int i = num.length(); i >= 0; i--) {
			if (i == 0) {
				break;
			}
			char ch = num.charAt(i-1);
			pow = (int) Math.pow(16, count);
			if(ch > 64 && ch < 71) {
				result += pow * (ch -55);
			}else {
				result += pow * (ch -'0');
			}
			count++;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println("2진 -> 10진 : " + binaryToDacemal("001010111100"));
		System.out.println("8진 -> 10진 : " + octToDacemal("1274"));
		System.out.println("16진 -> 10진 : " + hexToDacemal("2BC"));
		
	}
	
	
}
```  
#### 결과  
![image](https://user-images.githubusercontent.com/67041069/87943037-6f766c00-cad8-11ea-8395-ecf3b86dd69c.png)
