package study.week02;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0}, // 0번 노드: 1,2 연결
                {1, 0, 0, 1}, // 1번 노드: 0,3 연결
                {1, 0, 0, 1}, // 2번 노드: 0,3 연결
                {0, 1, 1, 0}  // 3번 노드: 1,2 연결
        };
        int n = 4;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                dfs(i, graph, visited);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        for(int j=0; j< computers.length; j++) {
            if(computers[current][j] == 1 && !visited[j]) {
                dfs(j, computers, visited);
            }
        }
    }
}

