### 994 Rotating Oranges
- m * n 크기의 grid가 주어지며 각 칸은 아래 세가지 값들 중 하나입니다:
  - 0은 비어있는 칸을 뜻합니다
  - 1은 신선한 오렌지를 뜻합니다
  - 2는 썩어있는 오렌지를 뜻합니다

- 매 분마다, 신선한 오렌지들 중 상하좌우 4방향에 썩은 오렌지가 있는 오렌지는 따라서 썩게 됩니다.

- 신선한 오렌지가 하나도 남지 않는데 걸리는 최소 시간을 리턴하세요. 만약 불가능하다면 -1을 리턴합니다.
- java code
```java
  public class Solution {
  
      static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      static int R, C;
      public static int orangesRotting(int[][] grid) {
          R = grid.length;
          C = grid[0].length;
  
          for (int i = 0; i < R; i++) {
              for (int j = 0; j < C; j++) {
                  if (grid[i][j] == 2) {
                      dfs(i, j, 2, grid); // 이미 grid에서 0, 1, 2를 사용하고 있기 때문에 time 값을 2부터 시작
                  }
              }
          }
  
          int result = 2; // 방문하지 못 한곳을 제외한 나머지는 최소 값이 2 이기 때문에 결과 값을 2로 시작
          for (int i = 0; i < R; i++) {
              for (int j = 0; j < C; j++) {
                  if (grid[i][j] == 1) {
                      return -1;
                  } else {
                      result = Math.max(result, grid[i][j]);
                  }
              }
          }
  
          return result - 2; // 2로 시작했던 부분을 빼 줌
      }
  
      public static void dfs(int row, int col, int time, int[][] grid) {
          for (int[] ints : d) {
              int nextRow = row + ints[0];
              int nextCol = col + ints[1];
  
              if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
              if (grid[nextRow][nextCol] == 0) continue;
              // 다음으로 탐색할 곳이 시간 + 1 한 값 보다 작으면 재탐색
              if (grid[nextRow][nextCol] < time + 1 && grid[nextRow][nextCol] > 1) continue;
  
              grid[nextRow][nextCol] = time + 1;
              dfs(nextRow, nextCol, time + 1, grid);
          }
      }
  
      public static void main(String[] args) {
          System.out.println(orangesRotting(
                  new int[][] {
                          {2, 1, 1},
                          {1, 1, 0},
                          {0, 1, 1}
                  }
          ));
  
          System.out.println(orangesRotting(
                  new int[][] {
                          {0, 2}
                  }
          ));
      }
  }
```
