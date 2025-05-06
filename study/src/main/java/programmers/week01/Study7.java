package programmers.week01;

import java.util.Stack;

public class Study7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.solution(new int[] {73,74,75,71,69,72,76,73}));
    }
}

class Solution7 {
    public int[] solution(int[] temperatures) {
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