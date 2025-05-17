package programmers.week02;

import java.util.LinkedList;
import java.util.Queue;

public class 동전잔돈 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int n = 11;
        Solution_동전잔돈 solution = new Solution_동전잔돈();
        System.out.println(solution.coinChange(coins, n));
    }
}

class Solution_동전잔돈 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        boolean[] visited = new boolean[amount + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{amount, 0});
        visited[amount] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowAmount = now[0];
            int nowCoin = now[1];
            if(nowAmount == 0) {
                return nowCoin;
            }
            for(int coin : coins) {
                int next = nowAmount - coin;
                if(next >= 0 && !visited[next]) {
                    queue.offer(new int[]{next, nowCoin+1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
