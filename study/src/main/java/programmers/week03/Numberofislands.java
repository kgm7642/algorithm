package programmers.week03;

import java.util.LinkedList;
import java.util.Queue;

public class Numberofislands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        Solution_Numberofislands solution = new Solution_Numberofislands();
        System.out.println(solution.numIslands(grid));
    }
}

class Solution_Numberofislands {
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int rowLength;
    int colLength;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        int count = 0;
        for(int r=0; r<rowLength; r++) {
            for(int c=0; c<colLength; c++) {
                if(grid[r][c]=='1' && !visited[r][c]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int cr = current[0];
                        int cc = current[1];

                        for(int i=0; i<4; i++) {
                            int nr = cr+dr[i];
                            int nc = cc+dc[i];
                            if(0<=nr && nr<rowLength && 0<=nc && nc<colLength) {
                                if(grid[nr][nc] == '1' && !visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}

//class Solution_Numberofislands {
//    int[] dr = {1, -1, 0, 0};
//    int[] dc = {0, 0, 1, -1};
//    int rowLength;
//    int colLength;
//    public int numIslands(char[][] grid) {
//        rowLength = grid.length;
//        colLength = grid[0].length;
//        boolean[][] visited = new boolean[rowLength][colLength];
//        int count = 0;
//        for(int r=0; r<rowLength; r++) {
//            for(int c=0; c<colLength; c++) {
//                if(grid[r][c]=='1' && !visited[r][c]) {
//                    dfs(r, c, grid, visited);
//                    count += 1;
//                }
//            }
//        }
//        return count;
//    }
//    public void dfs(int r, int c, char[][] grid, boolean[][] visited) {
//        visited[r][c] = true;
//        for (int i=0; i<4; i++) {
//            int nr = r + dr[i];
//            int nc = c + dc[i];
//            if(0 <= nr && nr < rowLength && 0 <= nc && nc < colLength && grid[nr][nc] == '1') {
//                if(!visited[nr][nc]) {
//                    dfs(nr, nc, grid, visited);
//                }
//            }
//        }
//    }
//}