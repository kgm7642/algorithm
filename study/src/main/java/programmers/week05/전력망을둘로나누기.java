package programmers.week05;

import java.util.*;

public class 전력망을둘로나누기 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        Solution_전력망둘로나누기 solution = new Solution_전력망둘로나누기();
        System.out.println(solution.solution(n, wires));
    }
}

class Solution_전력망둘로나누기 {
    int answer;
    public int solution(int n, int[][] wires) {
        answer = n;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);

        return answer;
    }

    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int n) {
        int count = 1;
        visited[cur] = true;

        for(int next : graph.get(cur)) {
            if(!visited[next]) {
                count += dfs(graph, visited, next, n);
            }
        }
        answer = Math.min(answer, Math.abs(count-(n-count)));

        return count;
    }
}