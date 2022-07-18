### SPFA (Shortest Path Faster Algorithm)
  - 최단 경로를 구하는 알고리즘
  - 벨만 포드 알고리즘의 성능을 향상시킨 것으로 음수 간선이 있는 그래프에서 최단 경로를 빠르게 구할 수 있음
  - 최악의 시간 복잡도 O(VE)이지만 평균 시간 복잡도는 O(V+E)로 동작
  - 벨만 포드 알고리즘에서는 모든 간선들을 살펴보며 최단거리 갱신(relax)과정을  V - 1번 반복하는데 SPFA 알고리즘에서는 단순히 모든 간선을 반복하며 최단거리 갱신을 하는것이 아니라, 갱신된 점들에 대해 연결된 간선들만 갱신을 함
  - 최단거리 갱신을 시킬 간선들의 queue가 있고 갱신된 점과 연결된 간선들이 queue에 없다면 넣고 이를 반복하면 최단경로 계산이 완료되었을 때 queue가 비게 되고 종료
  - java code
  ```java
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.Queue;

    public class SPFA {

        public static void spfa(int v, int e, int[][] data, int start) {
            int[][] graph = new int[v + 1][v + 1];

            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], - 1);
            }

            for (int i = 0; i < data.length; i++) {
                graph[data[i][0]][data[i][1]] = data[i][2];
            }

            int[] distance = new int[v + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;

            boolean[] visited = new boolean[v + 1];
            visited[start] = true;

            Queue<Integer> spfa = new LinkedList<>();
            spfa.offer(start);
            
            int[] cycle = new int[10000001];
            ++cycle[start];

            // 0 8 3 7 5 10 3
            while (!spfa.isEmpty()) {
                int cur = spfa.poll();
                visited[cur] = false;

                for (int i = 1; i < v + 1; i++) {
                    if (graph[cur][i] != -1) {
                        if (distance[i] > distance[cur] + graph[cur][i]) {
                            distance[i] = distance[cur] + graph[cur][i];

                            if (!visited[i]) {
                                ++cycle[i];
                                if (cycle[i] >= v) {
                                  System.out.println("isMinusCycle");
                                  return;
                                }
                                spfa.offer(i);
                                visited[i] = true;
                            }
                        }
                    }
                }

            }

            for (int i = 1; i < v + 1; i++) {
              System.out.print(distance[i] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Test code
            int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
            spfa(7, 11, data, 1);

            data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
            spfa(7, 11, data, 1);
        }
    }
  ```
