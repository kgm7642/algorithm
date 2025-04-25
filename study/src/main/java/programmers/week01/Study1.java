package programmers.week01;

import java.util.Arrays;

public class Study1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.solution(new int[] {1,3,2,5,4}, 9));
    }
}

class Solution1 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int cnt = 0;
        int sum = 0;
        for(int el : d) {
            sum += el;
            if(sum>budget) return cnt;
            else if(sum == budget) return ++cnt;
            cnt++;
        }
        return cnt;
    }
}