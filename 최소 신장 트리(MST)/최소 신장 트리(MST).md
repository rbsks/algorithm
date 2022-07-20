### 최소 신장 트리(MST : Minimum Spanning Tree)
  - 그래프 상의 모든 노드들을 최소 비용으로 연결하는 방법
  - 크루스칼, 프림 알고리즘이 있음
  
### 크루스칼(Kruskal)
  - 간선 중 최소 값을 가진 간선 부터 연결
  - 사이클 발생 시 다른 간선 선택(union-find를 이용)
  - 주로 간선 수가 적을 때 사용
  - O(ElogE)
  - java code
  ```java
    import java.util.Arrays;
    import java.util.Comparator;

    public class Main {

        static int[] parents;
        public static int kruskal(int[][] data, int v, int e) {
            int weightSum = 0;

            Arrays.sort(data, Comparator.comparingInt(x -> x[2]));

            parents = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < e; i++) {
                if (find(data[i][0]) != find(data[i][1])) {
                    union(data[i][0], data[i][1]);
                    weightSum += data[i][2];
                }
            }

            return weightSum;
        }

        public static void union(int a, int b) {
            int aP = find(a);
            int bP = find(b);

            if (aP != bP) {
                parents[aP] = bP;
            }
        }

        public static int find(int a) {
            if (a == parents[a]) {
                return a;
            }

            return parents[a] = find(parents[a]);
        }
    }
  ```

### 프림 (Prim)
  - 임의의 노드에서 시작
  - 연결된 노드들의 간선 중 낮은 가중치를 갖는 간선 선택
  - 간선의 수가 많을 때 크루스칼 보다 유리
  - visited 배열이 필요
  - PriorityQueue 사용시 O(ElogV)
  - java code
  ```java
    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.PriorityQueue;

    public class Main {

        static class Node {
            int to;
            int weight;

            public Node(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        public static int prim(int[][] data, int v, int e) {
            int weightSum = 0;
            ArrayList<ArrayList<Node>> graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
                graph.get(data[i][1]).add(new Node(data[i][0], data[i][2]));
            }

            boolean[] visited = new boolean[v + 1];
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
            pq.offer(new Node(1, 0));

            int cnt = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                cnt += 1;

                if (visited[cur.to]) {
                    continue;
                }

                visited[cur.to] = true;
                weightSum += cur.weight;

                if (cnt == v) {
                    return weightSum;
                }

                for (int i = 0; i < graph.get(cur.to).size(); i++) {
                    Node adjNode = graph.get(cur.to).get(i);
                    if(!visited[adjNode.to]) {
                        pq.offer(adjNode);
                    }
                }
            }

            return weightSum;
        }
    }
  ```
