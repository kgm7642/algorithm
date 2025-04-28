package programmers.week02;

public class Study01_DFS {
    public static void main(String[] args) {
        Solution1_DFS s = new Solution1_DFS();
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(s.solution1(3, computers));
    }
}
class Solution1_DFS {
    public int solution1(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i=0; i< computers.length; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        for(int j=0; j< computers.length; j++) {
            if(computers[current][j] == 1 && !visited[j]) {
                dfs(j, computers, visited);
            }
        }
    }
}
