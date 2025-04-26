package study.week02;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int n = 3;
        boolean[] visited = new boolean[n]; // 방문 여부
        int answer = 0; // 네트워크 개수

        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;

        for(int i=0; i< computers.length; i++) {
            if(computers[current][i]==1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}

