package programmers.week02;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크BFS {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(solution1(3, arr));
    }

    public static int solution1(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for(int j=0; j< computers.length; j++) {
                        if(computers[current][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}

