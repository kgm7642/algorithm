package programmers.week01;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {73,74,75,71,69,72,76,73}));
    }

    public static int[] solution(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }
        return answer;
    }
}
