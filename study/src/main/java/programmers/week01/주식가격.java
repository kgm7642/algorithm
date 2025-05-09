package programmers.week01;

public class 주식가격 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 2, 3}));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++) {
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i]<=prices[j]) cnt++;
                else {
                    answer[i] = ++cnt;
                    break;
                }
                answer[i] = cnt;
            }
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}
