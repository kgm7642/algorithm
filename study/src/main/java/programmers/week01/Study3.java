package programmers.week01;

import java.util.*;

public class Study3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}

class Solution3 {
    public String solution(String[] participant, String[] completion)  {
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for(String name : participant) {
            if(!map.containsKey(name) || map.get(name) == 0) {
                return name;
            }
            map.put(name, map.get(name)-1);
            map.values();
        }
        return "";
    }
}