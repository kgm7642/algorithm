package programmers.week03;

import java.util.LinkedList;
import java.util.Queue;

public class 이진행렬의최단경로 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        Solution_이진행렬의최단경로 solution = new Solution_이진행렬의최단경로();
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
}

class Solution_이진행렬의최단경로 {
    int rowLength;
    int colLength;
    int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
    int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        if(grid[0][0]==1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int d = current[2];

            if(r==rowLength-1 && c==colLength-1) {
                return d;
            }

            for(int i=0; i<8; i++) {
                int cr = r+dr[i];
                int cc = c+dc[i];

                if(cr>=0 && cr<rowLength && cc>=0 && cc<colLength) {
                    if(grid[cr][cc]==0 && !visited[cr][cc]) {
                        queue.offer(new int[]{cr, cc, d+1});
                        visited[cr][cc] = true;
                    }
                }
            }
        }

        return -1;
    }
}
