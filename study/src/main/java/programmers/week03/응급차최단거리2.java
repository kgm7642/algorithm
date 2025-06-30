package programmers.week03;

import java.util.LinkedList;
import java.util.Queue;

public class 응급차최단거리2 {
    public static void main(String[] args) {
        int[][] city = {
                {0,0,1,0},
                {1,0,1,0},
                {1,0,0,0}
        };
        Solution_응급차최단거리2 solution = new Solution_응급차최단거리2();
        System.out.println(solution.solution(city));
    }
}

class Solution_응급차최단거리2 {
    public int solution(int[][] city) {
        int[] dr = {0,-1,-1,-1,0,1,1,1};
        int[] dc = {1,1,0,-1,-1,-1,0,1};
        int rowLength = city.length;
        int colLength = city[0].length;
        int dist = -1;

        if(city[0][0]==1 || city[rowLength-1][colLength-1]==1) return dist; // 시작점, 도착점 1이면 출발 불가


        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowLength][colLength];
        queue.offer(new int[]{0,0,1}); // 0,0 부터 시작 방문 노드는 1로 시작
        visited[0][0] = true; // 방문 표시

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];
            int cDist = current[2];

            // 목적지 도착하면 종료
            if(cr==rowLength-1 && cc==colLength-1) {
                dist = cDist;
                break;
            }

            for(int i=0; i<8; i++) {
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(nr>=0 && nr<rowLength && nc>=0 && nc<colLength) {
                    if(city[nr][nc] == 0 && !visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc, cDist+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return dist; // 조건에 안맞으면 -1
    }
}