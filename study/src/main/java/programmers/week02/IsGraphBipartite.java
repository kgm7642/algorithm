package programmers.week02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        Solution_IsGraphBipartite solution = new Solution_IsGraphBipartite();
        System.out.println(solution.isBipartite(graph));
    }
}

class Solution_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                color[i] = 0;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for(int next : graph[cur]) {
                        if(color[next] == -1) {
                            color[next] = 1 - color[cur];
                            queue.offer(next);
                        } else if(color[next] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
