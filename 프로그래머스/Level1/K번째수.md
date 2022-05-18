### K번째수
  - 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
  - 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면 array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
  - 자른 배열을 정렬하면 [2, 3, 5, 6]입니다.
  - 배열의 3번째 숫자는 5입니다.
  - 자바 코드
  ```java
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int cnt = 0;
        for(int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int idx = command[2] - 1;
            
            // 배열을 start ~ end까지 잘라서 정렬 후 배열에 카피
            int[] arr = Arrays.stream(Arrays.copyOfRange(array, start, end)).sorted().toArray();
            // 배열의 idx번째 수를 answer에 넣어 줌
            answer[cnt] = arr[idx];
            cnt++;
        }
        
        return answer;
    }
  ```
