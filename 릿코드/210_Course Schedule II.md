- java code
```java
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(graph, i, visiting, visited, result)) {
                return new int[0];
            }
        }
    
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public boolean dfs(List<Integer>[] graph, int curr, boolean[] visiting, boolean[] visited, List<Integer> result) {
        if(visited[curr]) {
            return true;
        }
        if(visiting[curr]) {
            return false;
        }
        visiting[curr] = true;
        for(int neighbour : graph[curr]) {
            if(!dfs(graph, neighbour, visiting, visited, result)) {
                return false;
            }
        }
        visiting[curr] = false;
        visited[curr] = true;
        result.add(curr);
        return true;
    }
}
```
