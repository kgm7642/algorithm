package programmers.week05;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";
        Solution_괄호회전하기 solution = new Solution_괄호회전하기();
        System.out.println(solution.solution(s));
    }
}

class Solution_괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        String sb = s + s;
        for(int i=0; i<s.length(); i++) {
            if (isValid(sb.substring(i, s.length()+i))) answer++;
        }
        return answer;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char current : s.toCharArray()) {
            if(current=='['||current=='{'||current=='(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) return false;

                char target = stack.pop();
                if((target=='['&&current!=']')
                ||(target=='{'&&current!='}')
                ||(target=='('&&current!=')')) return false;
            }
        }
        return stack.isEmpty();
    }
}
