### DFS와 BFS
  - 실버 2
  - [DFS와 BFS 풀러가기](https://www.acmicpc.net/problem/1260)
  - java code
  ```java
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;
    
    public class Main {
    
        static int N, M, V;
        static List<List<Integer>> graph = new ArrayList<>();
        static boolean[] visited;
        static StringBuilder dfsResult = new StringBuilder(), bfsResult = new StringBuilder();
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
    
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
    
            for (int i = 0; i < M; i++) {
                StringTokenizer coordinate = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(coordinate.nextToken());
                int v = Integer.parseInt(coordinate.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
    
            for (int i = 0; i <= N; i++) {
                graph.get(i).sort(Comparator.comparingInt(Integer::intValue));
            }
    
            visited = new boolean[N + 1];
            dfs(V);
            visited = new boolean[N + 1];
            bfs(V);
    
            System.out.println(dfsResult);
            System.out.println(bfsResult);
        }
    
        private static void dfs(int index) {
            dfsResult.append(index).append(" ");
            visited[index] = true;
    
            List<Integer> list = graph.get(index);
            for (int i = 0; i < list.size(); i++) {
                int nextIndex = list.get(i);
                if (!visited[nextIndex]) {
                    dfs(nextIndex);
                }
            }
        }
    
        private static void bfs(int index) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.offerLast(index);
    
            while (!deque.isEmpty()) {
                int nextIndex = deque.pollFirst();
                if (!visited[nextIndex]) {
                    List<Integer> list = graph.get(nextIndex);
                    for (int i = 0; i < list.size(); i++) {
                        deque.offerLast(list.get(i));
                    }
                    bfsResult.append(nextIndex).append(" ");
                    visited[nextIndex] = true;
                }
            }
        }
    }
  ```
