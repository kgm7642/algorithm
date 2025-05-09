package programmers.week01;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,3,2,5,4}, 9));
    }

    public static int solution(int[] d, int budget) {
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