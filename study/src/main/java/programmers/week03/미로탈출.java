package programmers.week03;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        Solution_미로탈출 solution = new Solution_미로탈출();
        System.out.println(solution.solution(maps));
    }
}

/*
S = 시작점
L = 레버
E = 출구
O = 통로
X = 벽 (막힘)
*/

class Solution_미로탈출 {
    public int solution(String[] maps) {
//        int[] dr = {1,-1,0,0};
//        int[] dc = {0,0,-1,1};
//
//        int n = maps.length;
//        int m = maps[0].length();
//        char[][] map = new char[n][m];
//
//        // 문자 맵으로 변환
//        for(int i=0; i<n; i++) {
//            map[i] = maps[i].toCharArray();
//        }
//
//        // 시작(S), 레버(L), 도착(E) 좌표 찾기
//        int startX = -1, startY = -1;
//        int leverX = -1, leverY = -1;
//        int endX = -1, endY = -1;
//
//        for(int i=0; i<n; i++) {
//            for(int tj=0; j<m; j++) {
//
//            }
//        }
//
///*
//S O O O L
//X X X X O
//O O O O O
//O X X X X
//O O O O E
//*/
//        Queue<int[]> queue2 = new LinkedList<>();
//        boolean[][] visited2 = new boolean[n][m];
//
//
//        return 0;
//    }
//
//    public int bfs(char[][] map, int startX, int startY, char target) {
//
//
//
        return -1;
    }
}