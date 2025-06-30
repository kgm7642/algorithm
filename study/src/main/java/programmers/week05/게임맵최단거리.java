package programmers.week05;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        Solution_게임맵최단거리 solution = new Solution_게임맵최단거리();
        System.out.println(solution.solution(maps));
    }
}

class Solution_게임맵최단거리 {
    public int solution(int[][] maps) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if(r==maps.length-1 && c ==maps[0].length-1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr < maps.length && nc >= 0 && nc < maps[0].length) {
                    if(maps[nr][nc]==1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }
        return -1;
    }
}
