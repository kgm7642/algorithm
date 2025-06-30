package programmers.week05;

import java.util.*;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        Solution_신고결과받기 solution = new Solution_신고결과받기();
        for(int el : solution.solution(id_list, report, k)) {
            System.out.println(el);
        }
    }
}

class Solution_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        int[] answer = new int[id_list.length];

        // 신고를 몇번 당했는지 카운트
        Map<String, Integer> reportCnt = new HashMap<>();

        // 신고자가 누구를 신고했는지 LIST로 저장
        Map<String, List<String>> iReport = new HashMap<>();

        for(String current : reportSet) {
            String from = current.split(" ")[0];
            String to = current.split(" ")[1];
            reportCnt.put(to, reportCnt.getOrDefault(to, 0) + 1) ;

            if(!iReport.containsKey(from)) {
                iReport.put(from, new ArrayList<>());
            }
            iReport.get(from).add(to);
        }

        for(int i=0; i<id_list.length; i++) {
            for(String str : iReport.getOrDefault(id_list[i], new ArrayList<>())) {
                if(reportCnt.get(str) >= k) {
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}