package programmers.week03;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 보물지도 {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] hole = {
                {2,3},
                {3,3}
        };
        Solution_보물지도 solution = new Solution_보물지도();
        System.out.println(solution.solution(n, m, hole));
    }
}

class Solution_보물지도 {

    // 상태 정보 저장 객체
    class State {
        int r;
        int c;
        int dist;
        int jumped;
        State(int r, int c, int dist, int jumped) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.jumped = jumped;
        }
    }

    public int solution(int n, int m, int[][] hole) {

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int[] dr2 = {2, -2, 0, 0,};
        int[] dc2 = {0, 0, 2, -2};

        Queue<State> queue = new ArrayDeque<>();
        int[][] maps = new int[m][n];
        for(int[] h: hole) {
            maps[h[1]-1][h[0]-1] =1;
        }
        boolean[][][] visited = new boolean[m][n][2];


        return 1;
    }
}