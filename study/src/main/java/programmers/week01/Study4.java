package programmers.week01;

import java.util.*;

public class Study4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.solution("()[]{}"));
    }
}

class Solution4 {
    public boolean solution(String s)  {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if(map.containsValue(ch)) {
                stack.push(ch);
            } else if(map.containsKey(ch)) {
                if(stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}