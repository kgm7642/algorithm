package programmers.week02;
import java.util.LinkedList;
import java.util.Queue;

public class Study01_DFS {
    public static void main(String[] args) {
        Solution1_DFS s = new Solution1_DFS();
        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(s.solution1(3, arr));
    }
}
class Solution1_DFS {
    public int solution1(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 각 컴퓨터가 방문됐는지 표시할 배열
        int answer = 0; // 네트워크 개수를 저장할 변수

        Queue<Integer> queue = new LinkedList<>(); // BFS에 사용할 큐

        // 모든 컴퓨터(i)를 하나씩 확인
        for (int i = 0; i < n; i++) {
            // 만약 i번째 컴퓨터가 아직 방문되지 않았다면
            if (!visited[i]) {
                // 이 컴퓨터는 새로운 네트워크의 시작점이므로
                queue.add(i); // 큐에 추가
                visited[i] = true; // 방문 처리

                // 이제 BFS 시작
                while (!queue.isEmpty()) {
                    int current = queue.poll(); // 큐에서 하나 꺼냄 (현재 컴퓨터)

                    // current 컴퓨터와 연결된 컴퓨터들을 찾기
                    for (int j = 0; j < n; j++) {
                        // 연결되어 있고 아직 방문 안한 컴퓨터라면
                        if (computers[current][j] == 1 && !visited[j]) {
                            queue.add(j); // 큐에 넣고
                            visited[j] = true; // 방문 처리
                        }
                    }
                }
                // BFS 한 번 끝났다는 것은 하나의 네트워크를 다 탐색했다는 뜻
                answer++; // 네트워크 개수 증가
            }
        }
        return answer; // 전체 네트워크 수 반환
    }
}
