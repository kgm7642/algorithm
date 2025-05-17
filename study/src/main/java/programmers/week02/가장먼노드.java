package programmers.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        int[][] vertex = {
                {3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}
        };
        int n = 6;
        Solution_가장먼노드 solution = new Solution_가장먼노드();
        System.out.println(solution.solution(6, vertex));
    }
}

class Solution_가장먼노드 {
    public int solution(int n, int[][] edge) {
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a); // 무방향 그래프
        }

        // BFS 준비
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        queue.offer(1);
        visited[1] = true;
        dist[1] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    dist[next] = dist[now]+1;
                }
            }
        }
        int max = 0;
        for(int el : dist) {
            if(el > max) max = el;
        }
        int count = 0;
        for(int el : dist) {
            if(max == el) count++;
        }
        return count;
    }
}
