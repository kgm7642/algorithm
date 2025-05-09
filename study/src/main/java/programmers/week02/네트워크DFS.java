package programmers.week02;

public class 네트워크DFS {
    public static void main(String[] args) {
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(solution(3, computers));
    }

    public static int solution(int n, int[][] computers) {
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
