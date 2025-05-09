package programmers.week02;

import java.util.LinkedList;
import java.util.List;

public class KeysandRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
// 방 0번 열쇠 리스트
        List<Integer> room0 = new LinkedList<>();
        room0.add(1);
// 방 1번 열쇠 리스트
        List<Integer> room1 = new LinkedList<>();
        room1.add(2);
// 방 2번 열쇠 리스트
        List<Integer> room2 = new LinkedList<>();
        room2.add(3);
// 방 3번 열쇠 리스트 (빈 방)
        List<Integer> room3 = new LinkedList<>();
// 방 추가
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        KeysandRooms study02 = new KeysandRooms();
        System.out.println(study02.canVisitAllRooms(rooms));
    }

    int visitedCnt = 0;
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(0, rooms);
        return visitedCnt==rooms.size();
    }

    public void dfs(int currnet, List<List<Integer>> rooms) {
        visitedCnt++;
        visited[currnet] = true;

        for(int i=0; i<rooms.get(currnet).size(); i++) {
            if(!visited[rooms.get(currnet).get(i)]) {
                dfs(rooms.get(currnet).get(i), rooms);
            }
        }
    }
}
