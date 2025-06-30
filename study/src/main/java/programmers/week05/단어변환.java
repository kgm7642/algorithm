package programmers.week05;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Solution_단어변환 solution = new Solution_단어변환();
        System.out.println(solution.solution(begin, target, words));
    }
}

class Solution_단어변환 {
    public int solution(String begin, String target, String[] words) {
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Word(begin, 0));

        while(!queue.isEmpty()) {
            Word cur = queue.poll();
            for(int i=0; i< words.length; i++) {
                if(isChange(cur.word, words[i]) && !visited[i]) {
                    visited[i] = true;
                    if(words[i].equals(target)) {
                        return cur.count+1;
                    }
                    queue.offer(new Word(words[i], cur.count+1));
                }
            }
        }
        return 0;
    }

    boolean isChange(String a, String b) {
        int cnt = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                cnt++;
            }
        }
        return cnt==1;
    }

    static class Word {
        String word;
        int count;
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

}
