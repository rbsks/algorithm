### Four Squares
  - 난이도 실버 3  
  - [Four Squares 풀러가기](https://www.acmicpc.net/problem/17626)
  - java code
  ```java
    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public class Main {

        static int N, result;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());


            if (Math.sqrt(N) % 1 == 0) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < Math.sqrt(N) + 1; i++) {
                for (int j = i; j < Math.sqrt(N) + 1; j++) {
                    if (N == i * i + j * j) {
                        System.out.println(2);
                        return;
                    }
                }
            }

            for (int i = 0; i < Math.sqrt(N) + 1; i++) {
                for (int j = i; j < Math.sqrt(N) + 1; j++) {
                    for (int k = j; k < Math.sqrt(N) + 1; k++) {
                        if (N == i * i + j * j + k * k) {
                            System.out.println(3);
                            return;
                        }
                    }
                }
            }

            System.out.println(4);
        }
    }
  ```
