package study.week02;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        int n = 5;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("방문: " + current);
            for(int i=0; i<graph.length; i++) {
                if(graph[current][i]==1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
