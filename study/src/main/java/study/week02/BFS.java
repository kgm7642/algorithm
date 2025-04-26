package study.week02;

import java.util.*;

public class BFS {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static final int N = 8; // 노드 수
    static boolean[] visited = new boolean[N];

    @Autowired()
    void aaa(People people) {

    }
    public static void bfs(int startVertex) {
        // 시작점 예약
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        // queue가 비어있을 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int curVertex = queue.remove();
            // 다음 노드 예약
            for (int nextVertex : graph.get(curVertex)) {
                if (!visited[nextVertex]) {
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
    }
}
